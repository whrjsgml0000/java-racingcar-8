package racingcar.io;

import java.util.List;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;

public class Output {

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printCurrentRaceStatusToGraph(CurrentRaceStatusDTO currentRaceStatusDTO) {
        StringBuilder currentRaceStatusBuilder = new StringBuilder();
        List<CurrentCarProgressDTO> currentCarProgressDTOs = currentRaceStatusDTO.currentCarProgresses();
        currentCarProgressDTOs.stream().map(Output::toGraph)
                .forEach(currentRaceStatusBuilder::append);

        System.out.println(currentRaceStatusBuilder);
    }

    private static String toGraph(CurrentCarProgressDTO currentCarProgressDTO) {
        // ToDo : 상수처리 필요
        return "%s : %s%n".formatted(currentCarProgressDTO.name(), "-".repeat(currentCarProgressDTO.progress()));
    }
}
