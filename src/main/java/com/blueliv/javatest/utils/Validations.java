package com.blueliv.javatest.utils;

import com.blueliv.javatest.exceptions.ValidationsExceptions;

/** This class is in charge of program validations.
 *  @author  Laura Estrada
 *  @version 1.0
 *  @since   2019-04-09
 */
public class Validations {

    public static final String ERROR_MESSAGE = "ERROR";
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    public static final String FILE_ERROR = "OPEN FILE ERROR";
    public static final String INVALID_FORMAT_LINE = "INVALID FORMAT LINE ";
    public static final String INVALID_COMMAND_SIZE_MESSAGE = "INVALID COMMAND SIZE";
    public static final String INVALID_COMMAND_FILTER = "INVALID COMMAND FILTER";


    /**
     * This method validates console input.
     * @param args Console data entry.
     * @return String Validation success message.
     * @exception ValidationsExceptions
     * @see ValidationsExceptions
     */
    public static void validateCommand(String args[]) {
        if (args == null) {
            throw new ValidationsExceptions(INVALID_COMMAND_SIZE_MESSAGE);
        }
        if (args.length != 3) {
            throw new ValidationsExceptions(INVALID_COMMAND_SIZE_MESSAGE);
        }
        if (!args[1].equals(FilterType.CITY.getFilterTypeValue()) && !args[1].equals(FilterType.ID.getFilterTypeValue())) {
            throw new ValidationsExceptions(INVALID_COMMAND_FILTER);
        }
    }
    /**
     * This method validates format line.
     * @param line Current line.
     * @return String Validation success message or error message.
     */
    public static boolean validateFormatType(String line) {
        if (!line.equals(FormatType.F1.getFormatTypeValue()) && !line.equals(FormatType.F2.getFormatTypeValue())) {
            throw new ValidationsExceptions(INVALID_FORMAT_LINE);
        }
        return true;
    }
}
