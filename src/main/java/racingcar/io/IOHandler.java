package racingcar.io;

import java.util.List;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.io.parser.InputParser;

public class IOHandler {

    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final Input input;
    private final Output output;

    public IOHandler(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public List<String> requestCarNames() {
        output.printlnMessage(REQUEST_CAR_NAMES_MESSAGE);
        return input.readCarNames();
    }

    public int requestTryCount() {
        output.printlnMessage(REQUEST_TRY_COUNT_MESSAGE);
        return input.readTryCount();
    }

    public void printCurrentRaceStatus(CurrentRaceStatusDTO currentRaceStatusDTO) {
        output.printCurrentRaceStatus(currentRaceStatusDTO);
    }
}
