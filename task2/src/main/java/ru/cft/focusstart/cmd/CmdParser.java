package ru.cft.focusstart.cmd;

public class CmdParser {

    private String inputFile;
    private String outputType;

    public CmdParser(String[] args) {
        inputFile = args[0];
        outputType = args[1];
    }

    public String getOutputType() {
        return outputType;
    }

    public String getInputFile() {
        return inputFile;
    }

}
