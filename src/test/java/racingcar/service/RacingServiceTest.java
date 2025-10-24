package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import racingcar.domain.car.dto.req.CreateCarDTO;
import racingcar.domain.car.entity.Car;
import racingcar.service.impl.RacingServiceImpl;

class RacingServiceTest {

    @Nested
    @DisplayName("레이스 생성 테스트")
    class CreateRace {

        RacingService racingService = new RacingServiceImpl(createCarDTO -> {
            return new Car(createCarDTO.getCarName(), null);
        });

        @ParameterizedTest
        @CsvFileSource(resources = "레이스_생성_성공.csv")
        void success(String rawCarNames, int tryCount) {
            // given
            List<CreateCarDTO> createCarDTOs = Arrays.stream(rawCarNames.split(","))
                    .map(CreateCarDTO::new)
                    .toList();

            // when & then
            assertDoesNotThrow(() -> racingService.createRace(createCarDTOs, tryCount));
        }

        @ParameterizedTest
        @CsvFileSource(resources = "레이스_생성_실패.csv")
        void failure(String rawCarNames, int tryCount, String errorContainingMessage) {
            // given
            List<CreateCarDTO> createCarDTOs = Arrays.stream(rawCarNames.split(","))
                    .map(CreateCarDTO::new)
                    .toList();
            // when
            assertThatThrownBy(() -> racingService.createRace(createCarDTOs, tryCount))
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(errorContainingMessage);
        }
    }
}