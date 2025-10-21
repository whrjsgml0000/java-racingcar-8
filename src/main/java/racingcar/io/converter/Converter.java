package racingcar.io.converter;

import racingcar.domain.car.dto.res.CurrentCarProgressDTO;

public interface Converter {
    String convert(CurrentCarProgressDTO currentCarProgressDTO);
}
