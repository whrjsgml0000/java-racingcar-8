package racingcar.service.impl;

import java.util.List;
import racingcar.domain.car.dto.req.CreateCarDTO;
import racingcar.domain.car.factory.CarFactory;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.domain.race.entity.Race;
import racingcar.service.RacingService;

public class RacingServiceImpl implements RacingService {

    private final CarFactory carFactory;

    public RacingServiceImpl(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    @Override
    public Race createRace(List<CreateCarDTO> createCarDTOs, int tryCount) {
        Race race = new Race(tryCount);

        createCarDTOs.stream()
                .map(carFactory::createCar)
                .forEach(race::registerCar);

        return race;
    }

    @Override
    public CurrentRaceStatusDTO runOnce(Race race) {
        return null;
    }

    @Override
    public List<String> getRaceWinner(Race race) {
        return List.of();
    }
}
