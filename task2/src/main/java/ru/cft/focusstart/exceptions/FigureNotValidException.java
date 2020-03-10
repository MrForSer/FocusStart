package ru.cft.focusstart.exceptions;

import ru.cft.focusstart.figures.FigureType;

import java.text.MessageFormat;
import java.util.Arrays;

public class FigureNotValidException extends IllegalArgumentException {

    public FigureNotValidException(FigureType figureType, double[] parameters) {
        System.out.printf("Параметры %s не позволяют построить фигуру %s%n", Arrays.toString(parameters), figureType);
    }

    public FigureNotValidException(double[] parameters) {
        System.out.println(MessageFormat.format("Параметры {0} не позволяют построить фигуру", Arrays.toString(parameters)));
    }

    public FigureNotValidException(double sideA, double sideB, double sideC) {
        System.out.println(MessageFormat.format("Параметры {0}, {1}, {2} не позволяют построить фигуру", sideA, sideB, sideC));
    }

    public FigureNotValidException(double parameter) {
        System.out.println(MessageFormat.format("Параметр {0} не позволяет построить фигуру", parameter));
    }
}
