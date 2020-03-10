package ru.cft.focusstart.input;

public class InputParser {

    private String figureName;
    private double[] parameters;

    public String getFigureName() {
        return figureName;
    }

    public double[] getParameters() {
        return parameters;
    }

    public void parseParametersFromInput(String[] inputValues) {
        this.figureName = inputValues[0].toUpperCase().trim();
        String[] paramArray = inputValues[1].split("\\s");
        this.parameters = new double[paramArray.length];
        for (int i = 0; i < paramArray.length; i++) {
            parameters[i] = Double.parseDouble(paramArray[i]);
        }
    }
}
