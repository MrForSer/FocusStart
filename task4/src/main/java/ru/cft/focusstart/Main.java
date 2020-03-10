package ru.cft.focusstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

public class Main {

    public static final int START_NUMBER = 1;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UserInput userInput = new UserInput();
        int inputNumber = userInput.getInput();
        log.info("Введено значение {}", inputNumber);

        Task task = new Task(START_NUMBER, inputNumber);
        log.info("Запуск вычислений в 1 поток");
        BigDecimal singleThreadResult = task.call();
        log.info("Получен результат {}", singleThreadResult);

        int threadsCount = Runtime.getRuntime().availableProcessors();
        TaskManager taskManager = new TaskManager(threadsCount);
        log.info("Запуск многопоточных вычислений");
        BigDecimal multiThreadResult = taskManager.runCalculationTasks(inputNumber);
        log.info("Получен результат {}", multiThreadResult);
    }
}