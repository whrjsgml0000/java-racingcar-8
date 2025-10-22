package racingcar.domain.car.entity;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.car.entity.Car.State;

public class RandomNumberCondition implements Condition {

    private static final int PICK_MIN_NUMBER = 0;
    private static final int PICK_MAX_NUMBER = 9;
    private static final int CAN_GO_MIN_NUMBER = 4;

    @Override
    public State getNextAction() {
        if(Randoms.pickNumberInRange(PICK_MIN_NUMBER, PICK_MAX_NUMBER) >= CAN_GO_MIN_NUMBER){
            return State.GO;
        }
        return State.STOP;
    }
}
