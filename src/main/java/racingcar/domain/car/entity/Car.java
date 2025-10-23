package racingcar.domain.car.entity;

import java.util.Objects;

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
        return condition.getNextAction() == State.GO;
    }

    public enum State {
        GO, STOP
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
