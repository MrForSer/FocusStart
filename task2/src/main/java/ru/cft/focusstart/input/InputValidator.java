package ru.cft.focusstart.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.IllegalNumberOfArgumentsException;
import ru.cft.focusstart.figures.FigureType;

public class InputValidator {

    private static final Logger log = LoggerFactory.getLogger(InputValidator.class);

    public void checkNumberOfParametersForFigureType(FigureType figureName, double[] parameters) {
        if (!(figureName.equals(FigureType.CIRCLE) && parameters.length == 1) &&
                !(figureName.equals(FigureType.RECTANGLE) && parameters.length == 2) &&
                !(figureName.equals(FigureType.TRIANGLE) && parameters.length == 3)) {
            log.error("Количество переданных параметров не соответствует типу фигуры");
            throw new IllegalNumberOfArgumentsException(figureName, parameters);
        }
    }
}
