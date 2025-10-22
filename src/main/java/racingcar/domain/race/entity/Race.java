package racingcar.domain.race.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.car.entity.Car;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;

public class Race {

    private static final int START_VALUE = 0;
    private final Map<Car, Integer> registeredCars = new LinkedHashMap();
    private int remainTryCount;

    public Race(int remainTryCount) {
        this.remainTryCount = remainTryCount;
    }

    public void registerCar(Car car) {
        if (registeredCars.containsKey(car)) {
            throw new IllegalArgumentException("동일한 이름을 가진 차를 등록할 수 없습니다.");
        }
        registeredCars.put(car, START_VALUE);
    }

    public void runOnce() {

    }

    public CurrentRaceStatusDTO getCurrentRaceStatus() {
        return null;
    }

}
