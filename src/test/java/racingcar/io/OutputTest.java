package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.io.converter.GraphConverter;

class OutputTest {

    Output output;
    OutputStream outputStream;

    @BeforeEach
    void setUp() {
        output = new Output(new GraphConverter());
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() throws IOException {
        output = null;
        outputStream.close();
    }

    @Test
    @DisplayName("메시지 출력 확인")
    void printlnMessage() {
        // given
        String message = "woowa";

        // when
        output.printlnMessage(message);

        // then
        assertThat(outputStream.toString()).contains(message);
    }

    @Test
    @DisplayName("현재 레이스 상황 출력 확인")
    void printCurrentRaceStatus() {
        // given
        List<CurrentCarProgressDTO> currentCarProgressDTOs = new ArrayList<>();
        currentCarProgressDTOs.add(new CurrentCarProgressDTO("pony",2));
        currentCarProgressDTOs.add(new CurrentCarProgressDTO("king",3));
        CurrentRaceStatusDTO currentRaceStatusDTO = new CurrentRaceStatusDTO(currentCarProgressDTOs);

        // when
        output.printCurrentRaceStatus(currentRaceStatusDTO);

        // then
        assertThat(outputStream.toString())
                .contains("pony : --")
                .contains("king : ---")
                .doesNotContain("pony : ---")
                .doesNotContain("king : ----");
    }

    @Nested
    @DisplayName("우승자 출력")
    class PrintWinner{

        @Test
        @DisplayName("공동 우승 출력 양식 확인")
        void 공동_우승() {
            // given
            List<String> winnersName = List.of("hello","king");

            // when
            output.printWinner(winnersName);

            // then
            assertThat(outputStream.toString()).contains("결과 : hello,king");
        }

        @Test
        @DisplayName("단독 우승 출력 양식 확인")
        void 단독_우승() {
            // given
            List<String> winnerName = List.of("hello");

            // when
            output.printWinner(winnerName);

            // then
            assertThat(outputStream.toString()).contains("결과 : hello");
        }
    }
}