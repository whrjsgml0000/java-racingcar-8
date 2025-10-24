package racingcar.service.impl;

import java.util.List;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.domain.race.entity.Race;
import racingcar.service.RacingService;

public class RacingServiceImpl implements RacingService {

    @Override
    public Race createRace(List<String> carNames, int tryCount) {
        return null;
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
