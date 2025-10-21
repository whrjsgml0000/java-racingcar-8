package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.io.parser.InputParser;

class InputTest {

    Input input = new Input(new InputParser() {
        @Override
        public List<String> parseCarNames(String rawCarNames) {
            return List.of("hello","my","name");
        }

        @Override
        public int parseTryCount(String rawTryCount) {
            return 5;
        }
    });

    @Test
    void readCarNames() {
        // given
        String inputValue = "hello,my,name";
        System.setIn(new ByteArrayInputStream(inputValue.getBytes(StandardCharsets.UTF_8)));

        // when
        List<String> carNames = input.readCarNames();

        // then
        assertThat(carNames).isEqualTo(Arrays.stream(inputValue.split(",")).toList());
    }

    @Test
    void readTryCount() {
        // given
        String inputValue = "5";
        System.setIn(new ByteArrayInputStream(inputValue.getBytes(StandardCharsets.UTF_8)));

        // when
        int tryCount = input.readTryCount();

        // then
        assertThat(tryCount).isEqualTo(5);
    }
}
