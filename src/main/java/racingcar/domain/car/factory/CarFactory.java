package racingcar.domain.car.factory;

import racingcar.domain.car.dto.req.CreateCarDTO;
import racingcar.domain.car.entity.Car;

public interface CarFactory {

    Car createCar(CreateCarDTO createCarDTO);
}
