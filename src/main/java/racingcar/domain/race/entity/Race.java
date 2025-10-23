package racingcar.domain.race.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.car.entity.Car;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;

public class Race {

    private static final int START_LINE = 0;
    private final Map<Car, Integer> raceStatus = new LinkedHashMap();
    private int remainTryCount;

    public Race(int remainTryCount) {
        this.remainTryCount = remainTryCount;
    }

    public boolean isEnd() {
        return remainTryCount <= 0;
    }

    public void registerCar(Car car) {
        if (raceStatus.containsKey(car)) {
            throw new IllegalArgumentException("동일한 이름을 가진 차를 등록할 수 없습니다.");
        }
        raceStatus.put(car, START_LINE);
    }

    public void runOnce() {
        remainTryCount--;
    }

    public CurrentRaceStatusDTO getCurrentRaceStatus() {
        return null;
    }

}
