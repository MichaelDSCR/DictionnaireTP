package com.formation.poe.java.dictionnaire.exceptions;

public class DictionnaireException extends Exception {
    public DictionnaireException(String message) {
        super(message);
    }

    public DictionnaireException(String message, Throwable cause) {
        super(message, cause);
    }
}