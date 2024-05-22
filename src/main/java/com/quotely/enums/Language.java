package com.quotely.enums;

public enum Language {
    EN("en"), RU("ru");

    private final String stringValue;

    Language(final String stringValue){
        this.stringValue = stringValue;
    }
    public String toString() { return stringValue; }
}


