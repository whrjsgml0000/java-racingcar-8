package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import racingcar.io.impl.InputImpl;

class InputTest {

    @Test
    void readLine() {
        // given
        String inputValue = "hello";
        System.setIn(new ByteArrayInputStream(inputValue.getBytes(StandardCharsets.UTF_8)));

        Input input = new InputImpl();
        // when
        String readValue = input.readLine();

        // then
        assertThat(readValue).isEqualTo(inputValue);
    }
}