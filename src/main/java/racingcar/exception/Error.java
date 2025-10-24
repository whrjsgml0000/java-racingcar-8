package racingcar.exception;

public enum Error {
    NOT_EXIST_CONDITION(4000, "존재하지 않는 condition 입니다."),
    NOT_VALID_TRY_COUNT(4001, "입력한 시도 횟수가 적절하지 않습니다."),
    NOT_VALID_CAR_NAME_LENGTH(4002, "등록하려는 이름의 길이가 적절하지 않습니다."),
    CANT_REGISTER_WITH_DUPLICATED_NAME(4003, "중복된 이름으로 참가할 수 없습니다."),
    MINIMUM_PARTICIPANT_CAR(4004, "최소 1개 이상의 차가 참가해야 합니다."),
    NAME_SHOULD_NOT_BE_BLANK(4005, "이름을 공란으로 둘 수 없습니다."),
    SHOULD_INPUT_TRY_COUNT(4006, "시도 횟수를 입력하셔야 합니다."),
    TRY_COUNT_SHOULD_BE_POSITIVE_INTEGER(4007, "시도 횟수는 양의 정수만 입력 가능합니다."),
    RACE_NOT_FINISHED(5000, "끝나지 않은 경기의 최종 우승자를 확인할 수 없습니다.");

    private final int code;
    private final String message;

    Error(int code, String message){
        this.code = code;
        this.message = message;
    }

    public String print() {
        return "[%d ERROR] : %s".formatted(code, message);
    }
}
