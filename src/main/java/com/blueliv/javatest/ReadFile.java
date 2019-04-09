package com.blueliv.javatest;

import com.blueliv.javatest.exceptions.ValidationsExceptions;
import com.blueliv.javatest.utils.LineUtils;
import com.blueliv.javatest.utils.Validations;

import java.io.IOException;

/**
 * The ReadFile program ingesting a text ﬁle and returns a specific output.
 * This output will depend on the input filter.
 * @author  Laura Estrada
 * @version 1.0
 * @since   2019-04-09
 */
public class ReadFile {


    /**
     * This is the main method which makes use of Validations class and LineUtils class
     * for read file process.
     * @param args Console data entry.
     * @exception IOException On input error.
     * @see IOException
     */
    public static void main(String args[]) {
        try {
            if (Validations.SUCCESS_MESSAGE.equals(Validations.validateCommand(args))) {
                LineUtils.start(args);
            }
        }catch (ValidationsExceptions validationsExceptions){
            System.out.println(validationsExceptions.getMessage());
        } catch (IOException e) {
            System.out.println(Validations.FILE_ERROR);
        }
    }




}
