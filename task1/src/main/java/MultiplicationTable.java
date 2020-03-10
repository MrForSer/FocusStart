final class MultiplicationTable {

    static final int MIN_TABLE_SIZE = 1;
    static final int MAX_TABLE_SIZE = 32;
    private static final String CELL_SEPARATOR = "|";
    private static final String CELL_FLOOR = "-";
    private static final String CELL_CORNER = "+";
    private static final String GAP = " ";

    private MultiplicationTable() {
    }

    static String createTable(int tableSize) {
        return getHeadline(tableSize) +
                getBody(tableSize);
    }

    private static String getHeadline(int tableSize) {
        StringBuilder builder = new StringBuilder();
        builder.append(formatZero(tableSize));
        for (int headValue = 1; headValue <= tableSize; headValue++) {
            builder.append(formatValueByPosition(tableSize, headValue, headValue));
        }
        builder.append(getBottomBorder(tableSize));
        return builder.toString();
    }

    private static String getBody(int tableSize) {
        StringBuilder builder = new StringBuilder();
        for (int lineValue = 1; lineValue <= tableSize; lineValue++) {
            int columnCounter = 0;
            builder.append(formatValueByPosition(tableSize, lineValue, columnCounter));
            for (int columnValue = 1; columnValue <= tableSize; columnValue++) {
                int product = lineValue * columnValue;
                columnCounter++;
                builder.append(formatValueByPosition(tableSize, product, columnCounter));
            }
            builder.append(getBottomBorder(tableSize));
        }
        return builder.toString();
    }

    private static String formatValueByPosition(int tableSize, int value, int positionInLine) {
        String firstColumnFormat = "%" + getFirstColumnLength(tableSize) + "d";
        String maxColumnFormat = "%" + getMaxColumnLength(tableSize) + "d";
        String formattedValue;
        if (positionInLine == 0) {
            formattedValue = String.format(firstColumnFormat, value) + CELL_SEPARATOR;
        } else {
            formattedValue = String.format(maxColumnFormat, value);
            if (positionInLine < tableSize) {
                formattedValue += CELL_SEPARATOR;
            }
        }
        return formattedValue;
    }

    private static String formatZero(int tableSize) {
        return GAP.repeat(Math.max(0, getFirstColumnLength(tableSize))) + CELL_SEPARATOR;
    }

    private static String getBottomBorder(int tableSize) {
        StringBuilder grid = new StringBuilder(System.lineSeparator());
        grid.append(CELL_FLOOR.repeat(Math.max(0, getFirstColumnLength(tableSize))));
        for (int i = 0; i < tableSize; i++) {
            grid.append(CELL_CORNER);
            grid.append(CELL_FLOOR.repeat(Math.max(0, getMaxColumnLength(tableSize))));
        }
        grid.append(System.lineSeparator());
        return grid.toString();
    }

    private static int getFirstColumnLength(int tableSize) {
        return String.valueOf(tableSize).length();
    }

    private static int getMaxColumnLength(int tableSize) {
        return String.valueOf(tableSize * tableSize).length();
    }
}