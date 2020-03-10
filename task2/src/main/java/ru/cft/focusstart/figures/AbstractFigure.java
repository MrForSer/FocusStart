package ru.cft.focusstart.figures;

import java.text.DecimalFormat;

class AbstractFigure {

    static final DecimalFormat DF = new DecimalFormat("#.##");
    double area;
    double perimeter;

    static boolean validateFigure(double[] parameters) {
        boolean flag = true;
        for (double parameter : parameters) {
            if (parameter <= 0) {
                flag = false;
                break;
            }
        }
        return !flag;
    }

    static boolean validateFigure(double parameter) {
        boolean flag = true;
        if (parameter <= 0) {
            flag = false;
        }
        return flag;
    }

    String getCommonResults(String name, double area, double perimeter) {
        return (ResultParametersNames.TYPE + name + System.lineSeparator() +
                ResultParametersNames.AREA + DF.format(area) + ResultParametersNames.SQUARE_UNITS + System.lineSeparator() +
                ResultParametersNames.PERIMETER + DF.format(perimeter) + ResultParametersNames.UNITS + System.lineSeparator());
    }
}