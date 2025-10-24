package racingcar.io.parser.impl;

import static racingcar.exception.Error.MINIMUM_PARTICIPANT_CAR;
import static racingcar.exception.Error.NAME_SHOULD_NOT_BE_BLANK;
import static racingcar.exception.Error.SHOULD_INPUT_TRY_COUNT;
import static racingcar.exception.Error.TRY_COUNT_SHOULD_BE_POSITIVE_INTEGER;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.parser.InputParser;

public class InputParserImpl implements InputParser {

    private static final char DEFAULT_DELIMITER = ',';

    @Override
    public List<String> parseCarNames(String rawCarNames) {
        hasAnyParticipant(rawCarNames);

        List<String> carNames = split(rawCarNames, DEFAULT_DELIMITER).stream()
                .map(String::trim)
                .toList();

        carNames.forEach(InputParserImpl::isValidName);

        return carNames;
    }

    private static void hasAnyParticipant(String rawCarNames) {
        if (rawCarNames.isBlank()) {
            throw new IllegalArgumentException(MINIMUM_PARTICIPANT_CAR.print());
        }
    }

    private static List<String> split(String raw, char delimiter) {
        char[] chars = raw.toCharArray();
        List<String> names = new ArrayList<>();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == delimiter) {
                names.add(name.toString());
                name = new StringBuilder();
                continue;
            }
            name.append(chars[i]);
        }
        names.add(name.toString());
        return names;
    }

    private static void isValidName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(NAME_SHOULD_NOT_BE_BLANK.print());
        }
    }

    @Override
    public int parseTryCount(String rawTryCount) {
        if (rawTryCount.isBlank()) {
            throw new IllegalArgumentException(SHOULD_INPUT_TRY_COUNT.print());
        }
        if (!rawTryCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(TRY_COUNT_SHOULD_BE_POSITIVE_INTEGER.print());
        }

        return Integer.parseInt(rawTryCount);
    }
}
