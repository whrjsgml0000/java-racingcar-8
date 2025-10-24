package racingcar.domain.race.dto.res;

import java.util.List;
import java.util.Map;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.car.entity.Car;

public record CurrentRaceStatusDTO(List<CurrentCarProgressDTO> currentCarProgresses) {

    public static CurrentRaceStatusDTO toDto(Map<Car, Integer> raceStatus) {
        List<CurrentCarProgressDTO> currentCarProgressDTOs = raceStatus.entrySet().stream()
                .map(CurrentCarProgressDTO::toDto)
                .toList();

        return new CurrentRaceStatusDTO(currentCarProgressDTOs);
    }
}
