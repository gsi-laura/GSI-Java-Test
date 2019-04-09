package com.blueliv.javatest.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;


/**
 * This class is in charge of file processing.
 *
 * @author Laura Estrada
 * @version 1.0
 * @since 2019-04-09
 */
public class LineUtils {

    private static final String RE_F1 = "(D)(\\s)((?:[a-zA-Z]+)).*?(,)((?:[A-Z]+)).*?(,)(\\d{8})([A-Z])";
    private static final String RE_F2 = "(D)(\\s)((?:[a-zA-Z]+)).*?(\\s+;\\s+)((?:[A-Z]+)).*?(\\s+;\\s+)(\\d{8})(-)([A-Z])";
    private static Pattern PATTER_F1 = Pattern.compile(RE_F1);
    private static Pattern PATTER_F2 = Pattern.compile(RE_F2);


    public static void start(String args[]) throws IOException {
        new LineUtils().startProcess(args);
    }

    /**
     * This method starts the file processing.
     *
     * @param args Console data entry.
     */
    private void startProcess(String args[]) throws IOException {
        String path = args[0];
        FilterType filterType = FilterType.valueOf(args[1]);
        String filterValue = args[2];
        Set<String> hashSet = new HashSet<>();
        try (FileInputStream inputStream = new FileInputStream(path); Scanner sc = new Scanner(inputStream, "UTF-8")) {

            FormatType format = null;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.startsWith("F")) {
                    try {
                        format = FormatType.valueOf(line);
                    } catch (IllegalArgumentException ex) {
                    }
                } else {
                    if (format ==null){
                        System.err.println("No current format. Ignoring line");
                    }
                    else {
                        String processLine = processingLine(line, format, filterType, filterValue);
                        if (processLine != null) {
                            if (!hashSet.contains(processLine)) {
                                System.out.println(processLine);
                                if (FilterType.ID.getFilterTypeValue().equals(filterType))
                                    hashSet.add(processLine);
                            }
                        }
                    }
                }

            }

            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        }

    }

    /**
     * This method is responsible for reading a line
     * depending on the format and filter being applied.
     *
     * @param line        Current line.
     * @param format      Line format ("F1" or "F2").
     * @param filterType  Filter type that is applied to the line.
     * @param filterValue Search value.
     * @return Optional.
     */
    public String processingLine(String line, FormatType format, FilterType filterType, String filterValue) {
        if (line.startsWith(FormatType.INFO_INIT.getFormatTypeValue())) {

            String regex = null;

            if (validateLineFormat(line, format)) {
                if (FormatType.F1.equals(format) && FilterType.CITY.equals(filterType))
                    regex = "," + filterValue + ",";

                if (FormatType.F1.equals(format) && FilterType.ID.equals(filterType))
                    regex = "," + filterValue;

                if (FormatType.F2.equals(format) && FilterType.CITY.equals(filterType))
                    regex = "; " + filterValue + " ;";

                if (FormatType.F2.equals(format) && FilterType.ID.equals(filterType)) {
                    filterValue = filterValue.substring(0, 8) + "-" + filterValue.substring(8, 9);
                    regex = "; " + filterValue;
                }

                if (line.contains(regex)) {
                    return getLineResponse(line, regex, format, filterType);
                }
            }
        }
        return null;
    }

    /**
     * This method validates the current line according to the provided format.
     *
     * @param line   Current line.
     * @param format Line format ("F1" or "F2").
     * @return boolean.
     */
    public boolean validateLineFormat(String line, FormatType format) {
        if (FormatType.F1.equals(format))
            return PATTER_F1.matcher(line).matches();
        if (FormatType.F2.equals(format))
            return PATTER_F2.matcher(line).matches();
        return false;
    }

    /**
     * This method is responsible for setting up the output line.
     *
     * @param line       Current line.
     * @param regex      Search value.
     * @param format     Line format ("F1" or "F2").
     * @param filterType Filter type that is applied to the line ("CITY" or "ID").
     * @return String Line out.
     */
    public String getLineResponse(String line, String regex, FormatType format, FilterType filterType) {
        String substring = line.substring(2);
        String[] splitInfo = substring.split(regex);
        if (filterType.equals(FilterType.CITY)) {
            if (format.equals(FormatType.F1))
                return splitInfo[0] + "," + splitInfo[1];
            else
                return splitInfo[0].trim() + "," + splitInfo[1].replace("-", "").trim();
        } else {
            String[] splitCity;
            if (format.equals(FormatType.F1))
                splitCity = splitInfo[0].split(",");
            else
                splitCity = splitInfo[0].split(" ; ");
            return splitCity[1].trim();
        }
    }
}
