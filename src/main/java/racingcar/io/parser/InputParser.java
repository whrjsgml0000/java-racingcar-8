package racingcar.io.parser;

import java.util.List;

public interface InputParser {

    List<String> parseCarNames(String rawCarNames);
    int parseTryCount(String rawTryCount);
}
