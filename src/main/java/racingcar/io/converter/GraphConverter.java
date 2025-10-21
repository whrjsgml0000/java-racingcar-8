package racingcar.io.converter;

import racingcar.domain.car.dto.res.CurrentCarProgressDTO;

public class GraphConverter implements Converter {

    @Override
    public String convert(CurrentCarProgressDTO currentCarProgressDTO) {
        return "%s : %s%n".formatted(currentCarProgressDTO.name(), "-".repeat(currentCarProgressDTO.progress()));
    }
}
