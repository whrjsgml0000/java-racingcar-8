package racingcar.io.impl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.io.Input;

public class InputImpl implements Input {

    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } finally {
            Console.close();
        }
    }
}
