package racingcar.domain.car.dto.res;

import java.util.Map.Entry;
import racingcar.domain.car.entity.Car;

public record CurrentCarProgressDTO(String name, int progress) {

    public static CurrentCarProgressDTO toDto(Entry<Car, Integer> currentRacingCarStatus) {
        return new CurrentCarProgressDTO(currentRacingCarStatus.getKey().getName(), currentRacingCarStatus.getValue());
    }
}
