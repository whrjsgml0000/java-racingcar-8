package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String readLine() {
        try {
            return Console.readLine();
        } finally {
            Console.close();
        }
    }
}
