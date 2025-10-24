package racingcar.domain.race.entity;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import racingcar.domain.car.entity.Car;

public class Race {

    private static final int START_LINE = 0;
    private final Map<Car, Integer> currentRaceStatus = new LinkedHashMap<>();
    private Rule rule;
    private int remainTryCount;

    public Race(int remainTryCount) {
        this(remainTryCount, new SimpleRacingRule());
    }

    public Race(int remainTryCount, Rule rule){
        this.remainTryCount = remainTryCount;
        this.rule = rule;
        rule.validateRace(this);
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public boolean isEnd() {
        return remainTryCount <= 0;
    }

    public int getRemainTryCount() {
        return remainTryCount;
    }

    public void registerCar(Car car) {
        rule.validateCar(car, currentRaceStatus.keySet());
        currentRaceStatus.put(car, START_LINE);
    }

    public void runOnce() {
        if(isEnd()) {
            return;
        }
        remainTryCount--;

        for (Car car : currentRaceStatus.keySet()) {
            if (car.go()) {
                currentRaceStatus.compute(car, (currentCar, progress) -> progress += 1);
            }
        }
    }

    public Map<Car, Integer> getCurrentRaceStatus() {
        return new LinkedHashMap<>(currentRaceStatus);
    }

    public List<Car> getWinner() {
        if (!isEnd()) {
            throw new IllegalArgumentException("아직 경기가 끝나지 않았습니다. -> 입력 오류 아님.");
        }
        int firstProgress = currentRaceStatus.values().stream()
                .mapToInt(value -> value)
                .max().getAsInt();
        return currentRaceStatus.entrySet().stream()
                .filter(carProgress -> carProgress.getValue() == firstProgress)
                .map(Entry::getKey).toList();
    }
}
