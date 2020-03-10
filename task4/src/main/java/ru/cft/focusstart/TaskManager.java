package ru.cft.focusstart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskManager {

    private final int threadsCount;

    public TaskManager(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    public BigDecimal runCalculationTasks(int inputNumber) throws ExecutionException, InterruptedException {
        List<Callable<BigDecimal>> calculations = prepareCalculations(inputNumber);
        List<Future<BigDecimal>> futures = getResults(calculations);
        return getFinalSum(futures);
    }

    private List<Callable<BigDecimal>> prepareCalculations(int inputNumber) {
        List<Callable<BigDecimal>> calculations = new ArrayList<>();
        List<Integer> partitionStart = createPartitions(inputNumber);
        for (int partitionNumber = 0; partitionNumber < threadsCount; partitionNumber++) {
            int partitionEnd = getPartitionEnd(inputNumber, partitionStart, partitionNumber);
            calculations.add(new Task(partitionStart.get(partitionNumber), partitionEnd));
        }
        return calculations;
    }

    private int getPartitionEnd(int inputNumber, List<Integer> partitionStart, int partitionNumber) {
        int partitionEnd;
        if (partitionNumber + 1 < partitionStart.size()) {
            partitionEnd = partitionStart.get(partitionNumber + 1) - 1;
        } else {
            partitionEnd = inputNumber;
        }
        return partitionEnd;
    }

    private List<Future<BigDecimal>> getResults(List<Callable<BigDecimal>> calculations) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
        List<Future<BigDecimal>> futures = executorService.invokeAll(calculations);
        executorService.shutdown();
        return futures;
    }

    private BigDecimal getFinalSum(List<Future<BigDecimal>> futures) throws ExecutionException, InterruptedException {
        BigDecimal sum = BigDecimal.ZERO;
        for (Future<BigDecimal> future : futures) {
            sum = sum.add(future.get());
        }
        return sum;
    }

    private List<Integer> createPartitions(int inputNumber) {
        List<Integer> partitions = new ArrayList<>();
        int count = inputNumber / threadsCount;
        int result = 1;
        for (int i = 0; i < threadsCount; i++) {
            partitions.add(result);
            result += count;
        }
        return partitions;
    }
}