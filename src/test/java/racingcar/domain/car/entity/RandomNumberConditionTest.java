package racingcar.domain.car.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.entity.Car.State;

class RandomNumberConditionTest {

    @Test
    void getNextAction() {
        // given
        RandomNumberCondition condition = new RandomNumberCondition();
        int stopCnt = 0;
        int goCnt = 0;

        // when
        for (int i = 0; i < 10000; i++) {
            State nextAction = condition.getNextAction();
            if (nextAction == State.GO) {
                goCnt++;
            } else if (nextAction == State.STOP) {
                stopCnt++;
            }
        }

        // then
        assertThat(goCnt).isCloseTo(6000, Percentage.withPercentage(3));
        assertThat(stopCnt).isCloseTo(4000, Percentage.withPercentage(3));
    }
}