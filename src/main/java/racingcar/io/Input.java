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
        try {
            String rawCarNames = Console.readLine();
            return inputParser.parseCarNames(rawCarNames);
        } finally {
            Console.close();
        }
    }

    public int readTryCount() {
        try {
            String rawTryCount = Console.readLine();
            return inputParser.parseTryCount(rawTryCount);
        } finally {
            Console.close();
        }
    }
}
