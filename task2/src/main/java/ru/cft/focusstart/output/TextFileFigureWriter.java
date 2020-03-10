package ru.cft.focusstart.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.figures.Figure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class TextFileFigureWriter implements FigureWriter {

    private static final Logger log = LoggerFactory.getLogger(TextFileFigureWriter.class);

    @Override
    public void write(Figure figure) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"))) {
            writer.write(figure.getResults());

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}