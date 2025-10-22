package racingcar.domain.car.entity;

public class Car {

    private final String name;
    private final Condition condition;

    public Car(String name, Condition condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public State go() {
        return condition.getNextAction();
    }

    public enum State {
        GO, STOP
    }
}
