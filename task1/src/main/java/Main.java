class Main {

    public static void main(String[] args) {

        int tableSize = InputInterface.askForTableSize();
        String multiplicationTable = MultiplicationTable.createTable(tableSize);
        System.out.println(multiplicationTable);

    }
}