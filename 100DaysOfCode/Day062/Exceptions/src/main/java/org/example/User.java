package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + "\n";
    }
}
