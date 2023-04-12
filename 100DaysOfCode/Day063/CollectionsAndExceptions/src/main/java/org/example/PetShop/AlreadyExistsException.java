package org.example.PetShop;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException(String msg) {
        super(msg + " : Already exists!");
    }
}
