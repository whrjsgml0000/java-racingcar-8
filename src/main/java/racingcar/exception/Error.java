package racingcar.exception;

public enum Error {
    ;

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
