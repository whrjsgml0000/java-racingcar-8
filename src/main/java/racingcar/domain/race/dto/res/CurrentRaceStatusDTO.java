package racingcar.domain.race.dto.res;

import java.util.List;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;

public record CurrentRaceStatusDTO(List<CurrentCarProgressDTO> currentCarProgresses) {

}
