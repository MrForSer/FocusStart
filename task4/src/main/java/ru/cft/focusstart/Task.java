package ru.cft.focusstart;

import java.math.BigDecimal;
import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class Task implements Callable<BigDecimal> {

    private final int firstNumber;
    private final int lastNumber;
    private BigDecimal sum = BigDecimal.ZERO;

    Task(int firstNumber, int lastNumber) {
        this.firstNumber = firstNumber;
        this.lastNumber = lastNumber;
    }

    public void calculateRange(int firstNumber, int lastNumber) {
        IntStream.rangeClosed(firstNumber, lastNumber).forEach(i -> sum = sum.add(calculate(i)));
    }

    private BigDecimal calculate(int number) {
        return BigDecimal.valueOf(Math.tan(Math.log(number) * (5 * number) / (3 * number) - Math.cos(number) - Math.pow(number, 2) + 1));
    }

    @Override
    public BigDecimal call() {
        calculateRange(firstNumber, lastNumber);
        return sum;
    }
}