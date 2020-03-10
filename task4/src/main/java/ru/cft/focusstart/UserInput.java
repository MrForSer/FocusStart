package ru.cft.focusstart;

import java.util.Scanner;

public class UserInput {

    private static final String INQUIRY = "Введите целое число от 10'000'000 до 100'000'000";
    private static final String INCORRECT_INPUT = "Введенные данные не соответствуют требуемому формату. Если вы передумали и хотите выйти, введите 'ВЫХОД'";
    private static final String EXIT_CONDITION = "ВЫХОД";
    private static final int MIN_INPUT = 10000000;
    private static final int MAX_INPUT = 100000000;

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println(INQUIRY);
            while (!scanner.hasNextInt()) {
                String flag = scanner.next();
                if (flag.equals(EXIT_CONDITION)) {
                    System.exit(0);
                }
                System.out.println(INCORRECT_INPUT);
            }
            size = scanner.nextInt();
        } while (size > MAX_INPUT || size < MIN_INPUT);
        return size;
    }
}