package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import racingcar.domain.car.dto.req.CreateCarDTO;
import racingcar.domain.car.entity.Car;
import racingcar.domain.car.entity.Car.Action;
import racingcar.domain.car.factory.impl.CarFactoryImpl;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.domain.race.entity.Race;
import racingcar.service.impl.RacingServiceImpl;

class RacingServiceTest {

    RacingService racingService = new RacingServiceImpl(new CarFactoryImpl());

    @Nested
    @DisplayName("레이스 생성 테스트")
    class CreateRace {


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

    @Nested
    @DisplayName("레이스 진행 테스트")
    class RunOnce {

        @Test
        @DisplayName("레이스 한턴 진행 후 현황 확인")
        void success() {
            // given
            int tryCount = 5;
            Race race = new Race(tryCount);
            race.registerCar(new Car("car1", () -> Action.GO));

            // when
            CurrentRaceStatusDTO currentRaceStatusDTO = racingService.runOnce(race);

            // then
            int progress = currentRaceStatusDTO.currentCarProgresses().getFirst().progress();
            assertThat(progress).isEqualTo(1);
        }
    }
}