package racingcar.io.parser.impl;

import java.util.ArrayList;
import java.util.List;
import racingcar.io.parser.InputParser;

public class InputParserImpl implements InputParser {

    @Override
    public List<String> parseCarNames(String rawCarNames) {
        hasAnyParticipant(rawCarNames);

        List<String> carNames = split(rawCarNames, ',').stream()
                .map(String::trim)
                .toList();

        carNames.forEach(InputParserImpl::isValidName);

        return carNames;
    }

    private static void hasAnyParticipant(String rawCarNames) {
        if (rawCarNames.isBlank()) {
            throw new IllegalArgumentException("1명 이상 참가를 해야합니다.");
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
            throw new IllegalArgumentException("이름을 공란으로 둘 수 없습니다.");
        }
    }

    @Override
    public int parseTryCount(String rawTryCount) {
        if (rawTryCount.isBlank()) {
            throw new IllegalArgumentException("시도 횟수 입력을 하셔야합니다.");
        }
        if (!rawTryCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수만 입력 가능합니다.");
        }

        return Integer.parseInt(rawTryCount);
    }
}
