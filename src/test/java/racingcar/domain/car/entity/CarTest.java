package racingcar.domain.car.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("동일한 이름을 가진 차는 동일하다.")
    void testEquals() {
        Car car = new Car("hello",null);
        Car car1 = new Car("hello",null);

        assertEquals(car, car1);
    }
}