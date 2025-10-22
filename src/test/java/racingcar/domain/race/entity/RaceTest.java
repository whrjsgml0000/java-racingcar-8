package racingcar.domain.race.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car;

class RaceTest {

    @Test
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
                .hasMessageContaining("동일한");
    }

    @Test
    void runOnce() {
    }

    @Test
    void getCurrentRaceStatus() {
    }
}