package ru.cft.focusstart.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.IllegalFigureTypeException;

import java.util.function.Supplier;

public enum FigureType implements Supplier<String> {

    CIRCLE("CIRCLE"),
    RECTANGLE("RECTANGLE"),
    TRIANGLE("TRIANGLE");

    private static final Logger log = LoggerFactory.getLogger(FigureType.class);
    private final String name;

    FigureType(String name) {
        this.name = name;
    }

    public static FigureType of(String value) {
        for (FigureType figureType : FigureType.values()) {
            if (figureType.name().equals(value)) {
                return figureType;
            }
        }
        log.error("Тип фигуры {} не распознан", value);
        throw new IllegalFigureTypeException(value);
    }

    @Override
    public String get() {
        return name;
    }
}
