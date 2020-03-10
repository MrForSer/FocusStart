package ru.cft.focusstart.exceptions;


public class IllegalOutputParameterException extends IllegalArgumentException {

    public IllegalOutputParameterException(String outputParameter) {
        System.out.printf("Параметр вывода %s неизвестен %n", outputParameter);
    }
}
