package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.config.ComponentManager;

public class Application {

    public static void main(String[] args) {
        ComponentManager instance = ComponentManager.getInstance();
        try {
            instance.run();
        } finally {
            Console.close();
        }
    }
}
