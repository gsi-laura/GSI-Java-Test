package com.blueliv.javatest;

import com.blueliv.javatest.exceptions.ValidationsExceptions;
import com.blueliv.javatest.utils.LineUtils;
import com.blueliv.javatest.utils.Validations;

import java.io.IOException;

/**
 * The ReadFile program, which receives a text ﬁle and returns a specific output.
 * This output will depend on the input filter.
 * @author  Laura Estrada
 * @version 1.0
 * @since   2019-04-09
 */
public class ReadFile {


    /**
     * This is the main method which makes use of Validations class and LineUtils class
     * to read file process.
     * @param args Console data entry.
     * @exception IOException On input error.
     * @see IOException
     */
    public static void main(String args[]) {
        try {
            Validations.validateCommand(args);
            LineUtils.start(args);
        }catch (ValidationsExceptions validationsExceptions){
            System.err.println(validationsExceptions.getMessage());
        } catch (IOException e) {
            System.err.println(Validations.FILE_ERROR);
        }
    }




}
