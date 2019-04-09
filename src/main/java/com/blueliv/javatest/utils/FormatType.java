package com.blueliv.javatest.utils;

public enum FormatType {
    INITIAL ("F"),
    F1("F1"),
    F2("F2"),
    INFO_INIT("D ");

    private String formatTypeValue;

    FormatType(String formatTypeValue) {
        this.formatTypeValue = formatTypeValue;
    }

    public String getFormatTypeValue() {
        return formatTypeValue;
    }
}
