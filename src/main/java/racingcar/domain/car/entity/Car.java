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

    public boolean go() {
        return condition.getNextAction() == Action.GO;
    }

    public enum Action {
        GO, STOP
    }
}
