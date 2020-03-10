package ru.cft.focusstart.figures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.FigureNotValidException;

/**
 * Класс рассчитывает параметры треугольника в соответствии длинной его сторон.
 * Валидация входных данных должна проводится до создания фигуры: (не передавайте в конструктор значения <= 0).
 * Для проверки на возможность построения треугольника по трем сторонам имеется метод validateTriangle
 * рекомендуется воспользоваться им до создания фигуры.
 */
public class Triangle extends AbstractFigure implements Figure {

    private static final Logger log = LoggerFactory.getLogger(Triangle.class);

    private static final String NAME = "Треугольник";
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final double oppositeAngleA;
    private final double oppositeAngleB;
    private final double oppositeAngleC;

    Triangle(double sideA, double sideB, double sideC) {
        if (!validateTriangle(sideA, sideB, sideC)) {
            log.error("Треугольник не валидный, параметры: {}, {}, {}", sideA, sideB, sideC);
            throw new FigureNotValidException(sideA, sideB, sideC);
        }
        log.trace("Создаем треугольник");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.oppositeAngleA = angleCalc(sideB, sideC, sideA);
        this.oppositeAngleB = angleCalc(sideA, sideC, sideB);
        this.oppositeAngleC = angleCalc(sideA, sideB, sideC);
        this.area = Math.round(calculateArea(sideA, sideB, sideC) * 100) / 100.0;
        this.perimeter = Math.round((sideA + sideB + sideC) * 100) / 100.0;
    }

    static boolean validateTriangle(double[] parameters) {
        double sideA = parameters[0];
        double sideB = parameters[1];
        double sideC = parameters[2];
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    private static boolean validateTriangle(double sideA, double sideB, double sideC) {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA) && sideA > 0 && sideB > 0 && sideC > 0;
    }

    @Override
    public String getResults() {
        log.trace("Передаем результаты расчета на выход");
        String parameters = (getCommonResults(NAME, area, perimeter) +
                ResultParametersNames.FIRST + ResultParametersNames.SIDE + DF.format(sideA) + ResultParametersNames.UNITS + System.lineSeparator() +
                ResultParametersNames.OPPOSITE_ANGLE + DF.format(oppositeAngleA) + ResultParametersNames.DEGREE + System.lineSeparator() +
                ResultParametersNames.SECOND + ResultParametersNames.SIDE + DF.format(sideB) + ResultParametersNames.UNITS + System.lineSeparator() +
                ResultParametersNames.OPPOSITE_ANGLE + DF.format(oppositeAngleB) + ResultParametersNames.DEGREE + System.lineSeparator() +
                ResultParametersNames.THIRD + ResultParametersNames.SIDE + DF.format(sideC) + ResultParametersNames.UNITS + System.lineSeparator() +
                ResultParametersNames.OPPOSITE_ANGLE + DF.format(oppositeAngleC) + ResultParametersNames.DEGREE);
        log.info("Получены результаты: {}", parameters);
        return parameters;
    }

    /**
     * Метод для расчета противолежащего угла стороны 'sideC'.
     *
     * @return противолежащий угол для третьей стороны (в градусах)
     */
    private double angleCalc(double sideA, double sideB, double sideC) {
        log.trace("Запускаем расчет противолежащего угла треугольника для стороны {}", sideC);
        return Math.round(
                Math.toDegrees(
                        Math.acos((Math.pow(sideA, 2) + Math.pow(sideB, 2) - Math.pow(sideC, 2)) / (2 * sideA * sideB))
                ) * 100) / 100.0;
    }

    private double calculateArea(double sideA, double sideB, double sideC) {
        log.trace("Запускаем расчет площади треугольника {} {} {}", sideA, sideB, sideC);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}
