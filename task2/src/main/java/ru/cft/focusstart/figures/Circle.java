package ru.cft.focusstart.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.FigureNotValidException;

/**
 * Класс рассчитывает параметры круга в соответствии с его радиусом.
 * Валидация входных данных должна проводится до создания фигуры: (не передавайте в конструктор значения <= 0).
 */
public class Circle extends AbstractFigure implements Figure {

    private static final Logger log = LoggerFactory.getLogger(Circle.class);
    private static final String NAME = "Круг";
    private final double radius;
    private final double diameter;

    Circle(double radius) {
        if (!validateFigure(radius)) {
            log.error("Радиус {} меньше нуля. Невозможно построить круг", radius);
            throw new FigureNotValidException(radius);
        }
        this.radius = radius;
        this.area = Math.round(Math.pow(radius, 2) * Math.PI * 100) / 100.0;
        this.perimeter = Math.round(radius * (Math.PI * 2) * 100) / 100.0;
        this.diameter = (radius * 2);
    }

    @Override
    public String getResults() {
        log.info("Передаем результаты расчета на выход");
        String parameters = (getCommonResults(NAME, area, perimeter) +
                ResultParametersNames.RADIUS + DF.format(radius) + ResultParametersNames.UNITS + System.lineSeparator() +
                ResultParametersNames.DIAMETER + DF.format(diameter) + ResultParametersNames.UNITS);
        log.info("Получены результаты: {}", parameters);
        return parameters;
    }
}
