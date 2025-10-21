package racingcar.io;

import racingcar.domain.race.dto.CurrentRaceStatusDTO;

public interface Output {

    void printlnMessage(String message);
    void printCurrentRaceStatusToGraph(CurrentRaceStatusDTO currentRaceStatusDTO);
}
