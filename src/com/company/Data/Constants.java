package com.company.Data;

public enum Constants {
    PROGRAM_NAME("AssemblyProgram");
    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
