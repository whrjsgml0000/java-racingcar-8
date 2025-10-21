package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.dto.res.CurrentCarProgressDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;

class OutputTest {

    Output output;
    OutputStream outputStream;

    @BeforeEach
    void setUp() {
        output = new Output();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() throws IOException {
        output = null;
        outputStream.close();
    }

    @Test
    void printlnMessage() {
        // given
        String message = "woowa";

        // when
        output.printlnMessage(message);

        // then
        assertThat(outputStream.toString()).contains(message);
    }

    @Test
    void printCurrentRaceStatusToGraph() {
        // given
        List<CurrentCarProgressDTO> currentCarProgressDTOs = new ArrayList<>();
        currentCarProgressDTOs.add(new CurrentCarProgressDTO("pony",2));
        currentCarProgressDTOs.add(new CurrentCarProgressDTO("king",3));
        CurrentRaceStatusDTO currentRaceStatusDTO = new CurrentRaceStatusDTO(currentCarProgressDTOs);

        // when
        output.printCurrentRaceStatusToGraph(currentRaceStatusDTO);

        // then
        assertThat(outputStream.toString())
                .contains("pony : --")
                .contains("king : ---")
                .doesNotContain("pony : ---")
                .doesNotContain("king : ----");
    }
}