package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void readLine() {
        // given
        String inputValue = "hello";
        System.setIn(new ByteArrayInputStream(inputValue.getBytes(StandardCharsets.UTF_8)));

        Input input = new Input();
        // when
        String readValue = input.readLine();

        // then
        assertThat(readValue).isEqualTo(inputValue);
    }
}