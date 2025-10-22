package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.io.parser.InputParser;

public class Input {

    private final InputParser inputParser;

    public Input(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public List<String> readCarNames() {
        String rawCarNames = Console.readLine();
        return inputParser.parseCarNames(rawCarNames);
    }

    public int readTryCount() {
        String rawTryCount = Console.readLine();
        return inputParser.parseTryCount(rawTryCount);
    }
}
