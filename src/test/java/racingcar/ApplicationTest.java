package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    @DisplayName("참가자 입력 오류")
    class 참가자_입력 {

        @Test
        @DisplayName("입력 x")
        void 참가자_입력_x() {
            assertThatThrownBy(() -> run("\n"))
                    .hasMessageContaining("참가");
        }

        @Test
        @DisplayName("입력에 공백")
        void 참가자_입력에_공백() {
            assertThatThrownBy(() -> run(" \n"))
                    .hasMessageContaining("참가");
        }

        @Test
        @DisplayName("구분자만 입력")
        void 참가자_입력에_구분자만() {
            assertThatThrownBy(() -> run(","))
                    .hasMessageContaining("공란");
        }

        @Test
        @DisplayName("구분자만 뒤에 남는 경우")
        void 구분자만_뒤에_남는_경우() {
            assertThatThrownBy(() -> run("hello,\n"))
                    .hasMessageContaining("이름");
        }

        @Test
        @DisplayName("이름 없이 구분자로 시작")
        void 이름_없이_구분자로_시작() {
            assertThatThrownBy(() -> run(",hello\n"))
                    .hasMessageContaining("이름");
        }
    }
}
