package racingcar.config;

import racingcar.controller.RacingController;
import racingcar.domain.car.factory.CarFactory;
import racingcar.domain.car.factory.impl.CarFactoryImpl;
import racingcar.io.IOHandler;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.io.converter.Converter;
import racingcar.io.converter.GraphConverter;
import racingcar.io.parser.InputParser;
import racingcar.io.parser.impl.InputParserImpl;
import racingcar.service.RacingService;
import racingcar.service.impl.RacingServiceImpl;

public class ComponentManager {
    private static final ComponentManager INSTANCE = new ComponentManager();
    private final Converter converter;
    private final InputParser inputParser;
    private final Input input;
    private final Output output;
    private final IOHandler ioHandler;
    private final CarFactory carFactory;
    private final RacingService racingService;
    private final RacingController racingController;

    private ComponentManager() {
        converter = new GraphConverter();
        inputParser = new InputParserImpl();
        input = new Input(inputParser);
        output = new Output(converter);
        ioHandler = new IOHandler(input, output);
        carFactory = new CarFactoryImpl();
        racingService = new RacingServiceImpl(carFactory);
        racingController = new RacingController(racingService, ioHandler);
    }

    public static ComponentManager getInstance() {
        return INSTANCE;
    }

    public void run() {
        racingController.run();
    }
}
