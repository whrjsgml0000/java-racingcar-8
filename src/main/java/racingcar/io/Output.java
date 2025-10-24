package racingcar.io;

import java.util.List;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.io.converter.Converter;

public class Output {

    private static final String DEFAULT_WINNERS_JOIN_DELIMITER = ",";
    private static final String LAST_WINNER = "최종 우승자 : ";
    private final Converter converter;

    public Output(Converter converter) {
        this.converter = converter;
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printlnMessage(String message, int newLineCount) {
        System.out.print(System.lineSeparator().repeat(newLineCount));
        printlnMessage(message);
    }

    public void printCurrentRaceStatus(CurrentRaceStatusDTO currentRaceStatusDTO) {
        StringBuilder currentRaceStatusBuilder = new StringBuilder();
        List<CurrentCarProgressDTO> currentCarProgressDTOs = currentRaceStatusDTO.currentCarProgresses();
        currentCarProgressDTOs.stream().map(converter::convert)
                .forEach(currentRaceStatusBuilder::append);

        System.out.println(currentRaceStatusBuilder);
    }

    public void printWinner(List<String> raceWinner) {
        String winners = String.join(DEFAULT_WINNERS_JOIN_DELIMITER, raceWinner);
        System.out.println(LAST_WINNER + winners);
    }
}
