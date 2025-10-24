package racingcar.domain.car.factory.impl;

import static racingcar.exception.Error.NOT_EXIST_CONDITION;

import racingcar.domain.car.dto.req.CreateCarDTO;
import racingcar.domain.car.entity.Car;
import racingcar.domain.car.entity.RandomNumberCondition;
import racingcar.domain.car.factory.CarFactory;

public class CarFactoryImpl implements CarFactory {

    @Override
    public Car createCar(CreateCarDTO createCarDTO) {
        if(createCarDTO.getConditionName().equals("randomNumber")) {
            return new Car(createCarDTO.getCarName(), new RandomNumberCondition());
        }
        throw new IllegalArgumentException(NOT_EXIST_CONDITION.print());
    }
}
