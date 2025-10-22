package racingcar.controller;

import java.util.List;
import racingcar.io.IOHandler;
import racingcar.service.RacingService;

public class RacingController {

    private final RacingService racingService;
    private final IOHandler ioHandler;

    public RacingController(RacingService racingService, IOHandler ioHandler) {
        this.racingService = racingService;
        this.ioHandler = ioHandler;
    }

    public void run() {
        List<String> carNames = ioHandler.requestCarNames();
        int tryCount = ioHandler.requestTryCount();
    }
}
