package racingcar.domain.car.entity;

import racingcar.domain.car.entity.Car.Action;

public interface Condition {
    Action getNextAction();
}
