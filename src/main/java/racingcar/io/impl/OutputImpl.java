package racingcar.io.impl;

import java.util.List;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.io.Output;

public class OutputImpl implements Output {

    @Override
    public void printlnMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void printCurrentRaceStatusToGraph(CurrentRaceStatusDTO currentRaceStatusDTO) {
        StringBuilder currentRaceStatusBuilder = new StringBuilder();
        List<CurrentCarProgressDTO> currentCarProgressDTOs = currentRaceStatusDTO.currentCarProgresses();
        currentCarProgressDTOs.stream().map(OutputImpl::toGraph)
                .forEach(currentRaceStatusBuilder::append);

        System.out.println(currentRaceStatusBuilder);
    }

    private static String toGraph(CurrentCarProgressDTO currentCarProgressDTO) {
        // ToDo : 상수처리 필요
        return "%s : %s%n".formatted(currentCarProgressDTO.name(), "-".repeat(currentCarProgressDTO.progress()));
    }
}
