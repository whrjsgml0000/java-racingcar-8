package racingcar.domain.car.dto.req;

public class CreateCarDTO {

    private final String carName;
    private final String conditionName;

    public CreateCarDTO(String carName){
        this(carName, "randomNumber");
    }

    public CreateCarDTO(String carName, String conditionName) {
        this.carName = carName;
        this.conditionName = conditionName;
    }

    public String getCarName() {
        return carName;
    }

    public String getConditionName() {
        return conditionName;
    }
}
