package racingcar.domain.car.entity;

import racingcar.domain.car.entity.Car.State;

public interface Condition {
    State getNextAction();
}
