package ru.cft.focusstart;

import ru.cft.focusstart.cmd.CmdChecker;
import ru.cft.focusstart.cmd.CmdParser;
import ru.cft.focusstart.figures.Figure;
import ru.cft.focusstart.figures.FigureBuilder;
import ru.cft.focusstart.figures.FigureType;
import ru.cft.focusstart.input.InputParser;
import ru.cft.focusstart.input.InputReader;
import ru.cft.focusstart.input.InputValidator;
import ru.cft.focusstart.output.FigureWriter;
import ru.cft.focusstart.output.OutputType;
import ru.cft.focusstart.output.WriterBuilder;

class Main {

    public static void main(String[] args) {

        CmdChecker.checkCmdParameters(args);
        CmdChecker.checkIfOutputParameterValid(args);
        CmdParser cp = new CmdParser(args);

        InputReader ir = new InputReader();
        String[] inputValues = ir.readLinesFromFile(cp.getInputFile());
        InputParser ip = new InputParser();
        ip.parseParametersFromInput(inputValues);
        InputValidator iv = new InputValidator();
        iv.checkNumberOfParametersForFigureType(FigureType.of(ip.getFigureName()), ip.getParameters());

        FigureBuilder figureBuilder = new FigureBuilder();
        Figure figure = figureBuilder.create(FigureType.of(ip.getFigureName()), ip.getParameters());

        WriterBuilder writerBuilder = new WriterBuilder();
        FigureWriter figureWriter = writerBuilder.create(OutputType.of(cp.getOutputType()));
        figureWriter.write(figure);
    }
}
