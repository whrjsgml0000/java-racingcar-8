package racingcar.config;

import racingcar.io.IOHandler;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.io.converter.Converter;
import racingcar.io.converter.GraphConverter;

public class ComponentManager {
    private static final ComponentManager INSTANCE = new ComponentManager();
    private final Converter converter;
    private final Input input;
    private final Output output;
    private final IOHandler ioHandler;

    private ComponentManager() {
        converter = new GraphConverter();
        input = new Input();
        output = new Output(converter);
        ioHandler = new IOHandler(input, output);
    }

    public static ComponentManager getInstance() {
        return INSTANCE;
    }
}
