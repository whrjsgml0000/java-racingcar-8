package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import racingcar.service.impl.RacingServiceImpl;

class RacingServiceTest {

    RacingService racingService = new RacingServiceImpl();

    @Nested
    @DisplayName("레이스 생성 테스트")
    class CreateRace {
        
        @ParameterizedTest
        @CsvFileSource(resources = "레이스_생성_성공.csv")
        void success(String rawCarNames, int tryCount) {
            // given
            List<String> carNames = Arrays.stream(rawCarNames.split(",")).toList();

            // when & then
            assertDoesNotThrow(() -> racingService.createRace(carNames, tryCount));
        }

        @ParameterizedTest
        @CsvFileSource(resources = "레이스_생성_실패.csv")
        void failure(String rawCarNames, int tryCount, String errorContainingMessage) {
            // given
            List<String> carNames = Arrays.stream(rawCarNames.split(",")).toList();

            // when
            assertThatThrownBy(() -> racingService.createRace(carNames, tryCount))
                    .isExactlyInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(errorContainingMessage);
        }
    }
}