package racingcar.service;

import java.util.List;
import racingcar.domain.race.dto.res.CurrentRaceStatusDTO;
import racingcar.domain.race.entity.Race;

public interface RacingService {

    /**
     * 레이스를 만들고, 초기 차량을 등록한다.
     *
     * @param carNames 레이스에 등록할 초기 차량
     * @param tryCount 레이스 시도 횟수
     * @return 생성된 Race
     */
    Race createRace(List<String> carNames, int tryCount);

    /**
     * 레이스를 한 번 진행한다.
     *
     * @param race 진행시킬 레이스
     * @return 한 번 진행시킨 결과
     */
    CurrentRaceStatusDTO runOnce(Race race);

    /**
     * 레이스의 우승자를 확인한다.
     *
     * @param race 우승자를 확인할 레이스 
     * @return 우승자 목록
     */
    List<String> getRaceWinner(Race race);
}
