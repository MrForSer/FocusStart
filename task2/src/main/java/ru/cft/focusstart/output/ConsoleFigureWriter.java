package ru.cft.focusstart.output;

import ru.cft.focusstart.figures.Figure;

public class ConsoleFigureWriter implements FigureWriter {

    @Override
    public void write(Figure figure) {
        System.out.println(figure.getResults());
    }
}
