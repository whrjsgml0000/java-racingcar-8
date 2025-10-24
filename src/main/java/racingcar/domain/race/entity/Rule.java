package racingcar.domain.race.entity;

import java.util.Set;
import racingcar.domain.car.entity.Car;

public interface Rule {

    void validateRace(Race race) throws IllegalArgumentException;
    void validateCar(Car car, Set<Car> registeredCars) throws IllegalArgumentException;
}
