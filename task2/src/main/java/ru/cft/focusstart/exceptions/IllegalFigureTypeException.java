package ru.cft.focusstart.exceptions;

public class IllegalFigureTypeException extends IllegalArgumentException {

    public IllegalFigureTypeException(String figure) {
        System.out.printf("Тип фигуры %s не распознан %n", figure);
    }
}
