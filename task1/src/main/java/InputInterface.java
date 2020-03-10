import java.util.Scanner;

final class InputInterface {
    private static final String INQUIRY = "Введите размер таблицы (число от " +
            MultiplicationTable.MIN_TABLE_SIZE + " до " + MultiplicationTable.MAX_TABLE_SIZE + "):";
    private static final String INCORRECT_INPUT = "Входные данные не соответствуют требуемому формату.";
    private static final String EXIT_CONDITION = "ВЫХОД";

    private InputInterface() {
    }

    static int askForTableSize() {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println(INQUIRY);
            while (!scanner.hasNextInt()) {
                System.out.println(INCORRECT_INPUT);
                String flag = scanner.next();
                if (flag.equals(EXIT_CONDITION)) {
                    System.exit(0);
                }
            }
            size = scanner.nextInt();
        } while (size > MultiplicationTable.MAX_TABLE_SIZE || size < MultiplicationTable.MIN_TABLE_SIZE);
        return size;
    }
}