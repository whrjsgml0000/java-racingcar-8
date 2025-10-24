package racingcar.controller;

import java.util.List;
import racingcar.domain.car.dto.req.CreateCarDTO;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.domain.race.entity.Race;
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
        Race race = createRace();
        startRace(race);
        printWinner(race);
    }

    private void startRace(Race race) {
        ioHandler.beforePrintRaceResult();

        while(!race.isEnd()){
            CurrentRaceStatusDTO currentRaceStatus = racingService.runOnce(race);
            ioHandler.printCurrentRaceStatus(currentRaceStatus);
        }
    }

    private void printWinner(Race race) {
        List<String> raceWinner = racingService.getRaceWinner(race);
        ioHandler.printWinner(raceWinner);
    }

    private Race createRace() {
        List<CreateCarDTO> createCarDTOs = ioHandler.requestCarNames();
        int tryCount = ioHandler.requestTryCount();
        return racingService.createRace(createCarDTOs, tryCount);
    }
}
