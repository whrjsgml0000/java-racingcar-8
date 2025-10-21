package racingcar.io;

import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;

public interface Output {

    void printlnMessage(String message);
    void printCurrentRaceStatusToGraph(CurrentRaceStatusDTO currentRaceStatusDTO);
}
