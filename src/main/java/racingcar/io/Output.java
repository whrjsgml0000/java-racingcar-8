package racingcar.io;

import java.util.List;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.io.converter.Converter;

public class Output {

    private final Converter converter;

    public Output(Converter converter) {
        this.converter = converter;
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printCurrentRaceStatus(CurrentRaceStatusDTO currentRaceStatusDTO) {
        StringBuilder currentRaceStatusBuilder = new StringBuilder();
        List<CurrentCarProgressDTO> currentCarProgressDTOs = currentRaceStatusDTO.currentCarProgresses();
        currentCarProgressDTOs.stream().map(converter::convert)
                .forEach(currentRaceStatusBuilder::append);

        System.out.println(currentRaceStatusBuilder);
    }
}
