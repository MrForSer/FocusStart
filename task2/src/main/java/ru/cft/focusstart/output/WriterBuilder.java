package ru.cft.focusstart.output;

public class WriterBuilder {

    public FigureWriter create(OutputType outputType) {
        switch (outputType) {
            case INFILE:
                return new TextFileFigureWriter();
            case INCONSOLE:
                return new ConsoleFigureWriter();
            default:
                return null;
        }
    }
}
