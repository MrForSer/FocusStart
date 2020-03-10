package ru.cft.focusstart.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.FigureNotValidException;

import java.util.Arrays;

/**
 * Класс рассчитывает параметры прямоугольника в соответствии с длинной двух его сторон.
 * Валидация входных данных должна проводится до создания фигуры: (не передавайте в конструктор значения <= 0).
 */
public class Rectangle extends AbstractFigure implements Figure {

    private static final Logger log = LoggerFactory.getLogger(Rectangle.class);
    private static final String NAME = "Прямоугольник";
    private final double length;
    private final double width;
    private final double diagonal;

    Rectangle(double sideA, double sideB) {
        double[] sides = new double[2];
        sides[0] = sideA;
        sides[1] = sideB;
        Arrays.sort(sides);
        if (validateFigure(sides)) {
            log.error("Параметры {} не позволяют построить прямоугольник", sides);
            throw new FigureNotValidException(sides);
        }
        this.width = sides[0];
        this.length = sides[1];
        this.area = Math.round(length * width * 100) / 100.0;
        this.perimeter = Math.round((length + width) * 2 * 100) / 100.0;
        this.diagonal = Math.round(Math.sqrt((length * length) + (width * width)) * 100) / 100.0;
    }

    @Override
    public String getResults() {
        log.trace("Передаем результаты расчета на выход");
        String parameters = (getCommonResults(NAME, area, perimeter) +
                ResultParametersNames.LENGTH + DF.format(length) + ResultParametersNames.UNITS + System.lineSeparator() +
                ResultParametersNames.WIDTH + DF.format(width) + ResultParametersNames.UNITS + System.lineSeparator() +
                ResultParametersNames.DIAGONAL + DF.format(diagonal) + ResultParametersNames.UNITS);
        log.info("Получены результаты: {}", parameters);
        return parameters;
    }
}