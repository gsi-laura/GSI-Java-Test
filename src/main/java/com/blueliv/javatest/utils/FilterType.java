package com.blueliv.javatest.utils;

public enum FilterType {
    CITY("CITY"),
    ID("ID");

    private String filterTypeValue;

    FilterType(String filterTypeValue) {
        this.filterTypeValue = filterTypeValue;
    }

    public String getFilterTypeValue() {
        return filterTypeValue;
    }
}
