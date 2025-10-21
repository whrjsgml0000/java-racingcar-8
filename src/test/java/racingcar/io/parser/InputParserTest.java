package racingcar.io.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import racingcar.io.parser.impl.InputParserImpl;

class InputParserTest {

    InputParser inputParser = new InputParserImpl();

    @Nested
    @DisplayName("차 이름 파싱 테스트")
    class ParseCarNames {

        @ParameterizedTest
        @CsvFileSource(resources = "차_이름_파싱_성공.csv")
        void success(String rawCarNames, String rawResult) {
            List<String> result = Arrays.stream(rawResult.split(",")).toList();
            // given
            // when
            List<String> parsedCarNames = inputParser.parseCarNames(rawCarNames);

            // then
            assertThat(parsedCarNames).isEqualTo(result);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "차_이름_파싱_실패.csv")
        void failure(String rawCarNames, String messageKeyword) {
            // given
            // when & then
            assertThatThrownBy(()->inputParser.parseCarNames(rawCarNames))
                    .hasMessageContaining(messageKeyword);
        }
    }

    @Nested
    @DisplayName("시도 횟수 파싱 테스트")
    class ParseTryCount {

        @ParameterizedTest
        @CsvFileSource(resources = "시도_횟수_파싱_성공.csv")
        void success(String rawTryCount, int result) {
            // given
            // when
            int parsedTryCount = inputParser.parseTryCount(rawTryCount);

            // then
            assertThat(parsedTryCount).isEqualTo(result);
        }

        @ParameterizedTest
        @CsvFileSource(resources = "시도_횟수_파싱_실패.csv")
        void failure(String rawTryCount, String messageKeyword) {
            // given
            // when & then
            assertThatThrownBy(()->inputParser.parseTryCount(rawTryCount))
                    .hasMessageContaining(messageKeyword);
        }
    }
}
