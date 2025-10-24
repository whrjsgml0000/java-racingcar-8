package racingcar.io.parser.impl;

import java.util.Arrays;
import java.util.List;
import racingcar.io.parser.InputParser;

public class InputParserImpl implements InputParser {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 0;
    public static final int MAX_TRY_COUNT_LENGTH = 3;

    @Override
    public List<String> parseCarNames(String rawCarNames) {
        hasAnyParticipant(rawCarNames);

        List<String> carNames = Arrays.stream(rawCarNames.split(","))
                .map(String::trim)
                .toList();

        carNames.forEach(InputParserImpl::isValidName);

        return carNames;
    }

    private static void hasAnyParticipant(String rawCarNames) {
        if(rawCarNames.isBlank()){
            throw new IllegalArgumentException("1명 이상 참가를 해야합니다.");
        }
    }

    private static void isValidName(String carName) {
        if(carName.isBlank()){
            throw new IllegalArgumentException("이름을 공란으로 둘 수 없습니다.");
        }

        // ToDo: 이거 Input 에서 낼 오류가 맞는가?
        if(carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 " + MAX_CAR_NAME_LENGTH + "글자를 넘길 수 없습니다.");
        }
    }

    @Override
    public int parseTryCount(String rawTryCount) {
        if(!rawTryCount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수만 입력 가능합니다.");
        }
        if(rawTryCount.length() > MAX_TRY_COUNT_LENGTH){
            throw new IllegalArgumentException("시도 횟수는 " + MAX_TRY_COUNT_LENGTH + "자리 수까지 가능합니다.");
        }

        int parsedTryCount = Integer.parseInt(rawTryCount);
        if(parsedTryCount <= MIN_TRY_COUNT){
            throw new IllegalArgumentException("시도 횟수는 최소 " + MIN_TRY_COUNT + "회 이상만 가능합니다.");
        }
        return parsedTryCount;
    }
}
