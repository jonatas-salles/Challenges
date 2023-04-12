package org.example.PetShop;

public class NotFoundException extends Exception {
    public NotFoundException(String msg) {
        super(msg + " : Not found!");
    }
}
