package ru.cft.focusstart.exceptions;

import ru.cft.focusstart.figures.FigureType;

import java.util.Arrays;

public class IllegalNumberOfArgumentsException extends IllegalArgumentException {

    public IllegalNumberOfArgumentsException(FigureType figureName, double[] parameters) {
        System.out.printf("Некорректное количество параметров %s для фигуры %s%n", Arrays.toString(parameters), figureName);
    }
}
