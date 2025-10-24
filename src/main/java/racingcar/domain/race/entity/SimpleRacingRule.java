package racingcar.domain.race.entity;

import static racingcar.exception.Error.CANT_REGISTER_WITH_DUPLICATED_NAME;
import static racingcar.exception.Error.NOT_VALID_CAR_NAME_LENGTH;
import static racingcar.exception.Error.NOT_VALID_TRY_COUNT;

import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.car.entity.Car;

public class SimpleRacingRule implements Rule {

    private static final int DEFAULT_MINIMUM_TRY_COUNT = 1;
    private static final int DEFAULT_MAXIMUM_TRY_COUNT = 100;
    private static final int DEFAULT_MINIMUM_NAME_LENGTH = 1;
    private static final int DEFAULT_MAXIMUM_NAME_LENGTH = 5;
    private static final boolean DEFAULT_ALLOW_DUPLICATED_NAME = false;

    private int minimumTryCount = DEFAULT_MINIMUM_TRY_COUNT;
    private int maximumTryCount = DEFAULT_MAXIMUM_TRY_COUNT;
    private int minimumNameLength = DEFAULT_MINIMUM_NAME_LENGTH;
    private int maximumNameLength = DEFAULT_MAXIMUM_NAME_LENGTH;
    private boolean allowDuplicatedName = DEFAULT_ALLOW_DUPLICATED_NAME;

    public SimpleRacingRule() {
    }

    @Override
    public void validateRace(Race race) throws IllegalArgumentException {
        int raceRemainTryCount = race.getRemainTryCount();
        validateRaceTryCount(raceRemainTryCount);
    }

    private void validateRaceTryCount(int raceRemainTryCount) {
        if (raceRemainTryCount < minimumTryCount || raceRemainTryCount > maximumTryCount) {
            throw new IllegalArgumentException(NOT_VALID_TRY_COUNT.print());
        }
    }

    @Override
    public void validateCar(Car car, Set<Car> registeredCars) throws IllegalArgumentException {
        validateCarNameLength(car.getName());

        if(!allowDuplicatedName) {
            validateCarNameDuplicated(car.getName(), registeredCars.stream()
                    .map(Car::getName)
                    .collect(Collectors.toSet()));
        }
    }

    private void validateCarNameLength(String name) {
        if (name.length() < minimumNameLength || name.length() > maximumNameLength) {
            throw new IllegalArgumentException(NOT_VALID_CAR_NAME_LENGTH.print());
        }
    }

    private void validateCarNameDuplicated(String carName, Set<String> registeredCarNames) {
        if (registeredCarNames.contains(carName)) {
            throw new IllegalArgumentException(CANT_REGISTER_WITH_DUPLICATED_NAME.print());
        }
    }

    public SimpleRacingRule(int minimumTryCount, int maximumTryCount, int minimumNameLength, int maximumNameLength, boolean allowDuplicatedName) {
        this.minimumTryCount = minimumTryCount;
        this.maximumTryCount = maximumTryCount;
        this.minimumNameLength = minimumNameLength;
        this.maximumNameLength = maximumNameLength;
        this.allowDuplicatedName = allowDuplicatedName;
    }

    static SimpleRacingRuleBuilder builder() {
        return new SimpleRacingRuleBuilder();
    }

    static class SimpleRacingRuleBuilder {
        private int minimumTryCount = DEFAULT_MINIMUM_TRY_COUNT;
        private int maximumTryCount = DEFAULT_MAXIMUM_TRY_COUNT;
        private int minimumNameLength = DEFAULT_MINIMUM_NAME_LENGTH;
        private int maximumNameLength = DEFAULT_MAXIMUM_NAME_LENGTH;
        private boolean allowDuplicatedName = DEFAULT_ALLOW_DUPLICATED_NAME;

        public SimpleRacingRuleBuilder minimumTryCount(int minimumTryCount) {
            this.minimumTryCount = minimumTryCount;
            return this;
        }

        public SimpleRacingRuleBuilder maximumTryCount(int maximumTryCount) {
            this.maximumTryCount = maximumTryCount;
            return this;
        }

        public SimpleRacingRuleBuilder minimumNameLength(int minimumNameLength) {
            this.minimumNameLength = minimumNameLength;
            return this;
        }

        public SimpleRacingRuleBuilder maximumNameLength(int maximumNameLength) {
            this.maximumNameLength = maximumNameLength;
            return this;
        }

        public SimpleRacingRuleBuilder allowDuplicatedName(boolean allowDuplicatedName) {
            this.allowDuplicatedName = allowDuplicatedName;
            return this;
        }

        public SimpleRacingRule build() {
            return new SimpleRacingRule(this.minimumTryCount, this.maximumTryCount, this.minimumNameLength,
                    this.maximumNameLength, this.allowDuplicatedName);
        }
    }
}
