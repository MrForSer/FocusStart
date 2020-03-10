package ru.cft.focusstart.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.IllegalOutputParameterException;

import java.util.function.Supplier;

public enum OutputType implements Supplier<String> {

    INFILE("inFile"),
    INCONSOLE("inConsole");

    private static final Logger log = LoggerFactory.getLogger(OutputType.class);
    private final String name;

    OutputType(String name) {
        this.name = name;
    }

    public static OutputType of(String value) {
        for (OutputType outputType : OutputType.values()) {
            if (outputType.name().equalsIgnoreCase(value)) {
                return outputType;
            }
        }
        log.error("Параметр вывода {} не распознан", value);
        throw new IllegalOutputParameterException(value);
    }

    @Override
    public String get() {
        return name;
    }
}
