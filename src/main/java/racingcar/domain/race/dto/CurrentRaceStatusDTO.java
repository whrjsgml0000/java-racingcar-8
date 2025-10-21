package racingcar.domain.race.dto;

import java.util.List;
import racingcar.domain.car.dto.CurrentCarProgressDTO;

public record CurrentRaceStatusDTO(List<CurrentCarProgressDTO> currentCarProgresses) {

}
