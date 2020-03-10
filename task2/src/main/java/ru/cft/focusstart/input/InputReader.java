package ru.cft.focusstart.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {

    private static final Logger log = LoggerFactory.getLogger(InputReader.class);

    public String[] readLinesFromFile(String fileName) {
        String[] inputValues = new String[2];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            inputValues[0] = bufferedReader.readLine();
            inputValues[1] = bufferedReader.readLine();
        } catch (IOException e) {
            log.error(e.getMessage());
            System.out.println("Ошибка при чтении данных из файла. Убедитесь, что файл доступен и содержит необходимые данные (2 строки)");
        }
        return inputValues;
    }

}