package racingcar.domain.race.entity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car;
import racingcar.domain.car.entity.Car.State;

class RaceTest {

    @Test
    @DisplayName("동일한 이름을 가진 차 등록 실패")
    void registerCar() {
        // given
        Race race = new Race(5);
        Car hello = new Car("hello", null);
        Car god = new Car("god", null);
        Car hello1 = new Car("hello", null);
        race.registerCar(hello);
        race.registerCar(god);

        // when & then
        assertThatThrownBy(() -> race.registerCar(hello1))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("동일한");
    }

    @Nested
    @DisplayName("레이스 진행")
    class RunOnce{

        @Test
        @DisplayName("1번 레이스 진행 후 종료 확인")
        void runOnce() {
            // given
            Race race = new Race(1);
            Car car = new Car("car1", () -> State.GO);
            Car car1 = new Car("car2", () -> State.STOP);
            race.registerCar(car);
            race.registerCar(car1);

            // when & then
            assertDoesNotThrow(race::runOnce);
            assertThat(race.isEnd()).isTrue();
        }

        @Test
        @DisplayName("1번 레이스 진행 후 진행중 확인")
        void runOnce1() {
            // given
            Race race = new Race(2);
            Car car = new Car("car1", () -> State.GO);
            Car car1 = new Car("car2", () -> State.STOP);
            race.registerCar(car);
            race.registerCar(car1);

            // when & then
            assertDoesNotThrow(race::runOnce);
            assertThat(race.isEnd()).isFalse();
        }
    }

    @Test
    void getCurrentRaceStatus() {
    }
}