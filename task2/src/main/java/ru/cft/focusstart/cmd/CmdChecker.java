package ru.cft.focusstart.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.cft.focusstart.exceptions.EmptyCmdParametersException;
import ru.cft.focusstart.output.OutputType;

public class CmdChecker {

    private static final Logger log = LoggerFactory.getLogger(CmdChecker.class);

    private CmdChecker() {
    }

    public static void checkCmdParameters(String[] args) {
        if (args.length < 2) {
            log.error("Параметры командной строки не заданы.");
            throw new EmptyCmdParametersException();
        }
    }

    public static void checkIfOutputParameterValid(String[] args) {
        OutputType.of(args[1]);
    }
}