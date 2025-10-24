package racingcar.domain.race.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.entity.Car;

class SimpleRacingRuleTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 101, 102, 103, 104})
    @DisplayName("최소 시도 횟수 미만, 최대 시도 횟수 초과 실패 확인")
    void test1(int tryCount) {
        // given
        SimpleRacingRule rule = SimpleRacingRule.builder()
                .minimumTryCount(5)
                .maximumTryCount(100)
                .build();

        // when & then
        assertThatThrownBy(() -> new Race(tryCount, rule))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("4001");
    }

    @Test
    @DisplayName("최소 시도 횟수와 최대 시도 횟수 통과 확인")
    void test2() {
        // given
        int minimumTryCount = 1;
        int maximumTryCount = 5;
        SimpleRacingRule rule = SimpleRacingRule.builder()
                .minimumTryCount(minimumTryCount)
                .maximumTryCount(maximumTryCount)
                .build();

        // when & then
        for (int i = minimumTryCount; i <= maximumTryCount; i++) {
            int i1 = i;
            assertDoesNotThrow(() -> new Race(i1, rule));
        }

        assertThatThrownBy(() -> new Race(0, rule))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("4001");
        assertThatThrownBy(() -> new Race(6, rule))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("4001");
    }

    @Test
    @DisplayName("최소, 최대 이름 길이 확인")
    void test3() {
        // given
        SimpleRacingRule rule = SimpleRacingRule.builder()
                .minimumNameLength(1)
                .maximumNameLength(5)
                .build();

        Race race = new Race(5, rule);

        // when & then
        assertThatThrownBy(() -> race.registerCar(new Car("", null)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("4002");

        assertThatThrownBy(() -> race.registerCar(new Car("123456", null)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("4002");

        assertDoesNotThrow(() -> race.registerCar(new Car("1", null)));
        assertDoesNotThrow(() -> race.registerCar(new Car("12345", null)));
    }

    @Test
    @DisplayName("중복된 이름 허용 실패 확인")
    void test4() {
        // given
        SimpleRacingRule rule = SimpleRacingRule.builder()
                .allowDuplicatedName(false)
                .build();

        Race race = new Race(5, rule);

        race.registerCar(new Car("hello", null));
        // when & then
        assertThatThrownBy(() -> race.registerCar(new Car("hello", null)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("4003");

        assertDoesNotThrow(() -> race.registerCar(new Car("hell", null)));
    }

    @Test
    @DisplayName("중복된 이름 허용 성공 확인")
    void 중복된_이름_허용_성공_확인(){
        // given
        SimpleRacingRule rule = SimpleRacingRule.builder()
                .allowDuplicatedName(true)
                .build();

        Race race = new Race(5, rule);
        race.registerCar(new Car("hello",null));

        // when & then
        assertDoesNotThrow(()->race.registerCar(new Car("hello", null)));
        assertThat(race.getCurrentRaceStatus().keySet()).hasSize(2);
    }
}