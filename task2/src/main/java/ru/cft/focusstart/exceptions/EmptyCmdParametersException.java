package ru.cft.focusstart.exceptions;

public class EmptyCmdParametersException extends IllegalArgumentException {

    public EmptyCmdParametersException() {
        System.out.println("Параметры командной строки не заданы.");
    }
}
