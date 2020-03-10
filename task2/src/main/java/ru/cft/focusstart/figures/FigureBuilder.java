package ru.cft.focusstart.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.FigureNotValidException;

public class FigureBuilder {

    private static final Logger log = LoggerFactory.getLogger(FigureBuilder.class);

    public Figure create(FigureType figureName, double[] parameters) {
        switch (figureName) {
            case CIRCLE:
                checkFigure(figureName, parameters);
                return new Circle(parameters[0]);
            case RECTANGLE:
                checkFigure(figureName, parameters);
                return new Rectangle(parameters[0], parameters[1]);
            case TRIANGLE:
                checkTriangle(parameters);
                return new Triangle(parameters[0], parameters[1], parameters[2]);
            default:
                return null;
        }
    }

    private void checkFigure(FigureType figureName, double[] parameters) {
        if (AbstractFigure.validateFigure(parameters)) {
            log.error("Параметры {} не позволяют построить фигуру {}", parameters, figureName);
            throw new FigureNotValidException(figureName, parameters);
        }
    }

    private void checkTriangle(double[] parameters) {
        if (!Triangle.validateTriangle(parameters)) {
            log.error("Треугольник не валидный, параметры: {}", parameters);
            throw new FigureNotValidException(parameters);
        }
    }
}
