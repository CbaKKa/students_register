package ru.maxzhurov.students_register.services;

public enum Separators {
    GROUP(":"),
    STUDENT(" "),
    TASK("/"),
    NAME("_"),
    REPLACEMENT("");

    private final String text;

    private Separators(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
