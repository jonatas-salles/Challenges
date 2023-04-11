package org.example;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(String msg) {
        super(msg + " : Already exists!");
    }
}
