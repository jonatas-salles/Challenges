package org.example.PetShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Person {
    private final String name;
    private final String cpf;
    private final List<Dog> dogs;

    Person(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
        this.dogs = new ArrayList<>();
    }
    boolean addDog(Dog newDog) {
        if (dogs.contains(newDog)) return false;
        for (Dog dog : dogs) {
            if (dog.getName().equalsIgnoreCase(newDog.getName())) return false;
        }
        dogs.add(newDog);
        return true;
    }

    boolean removeDog(String name) {
        if(dogs.stream().noneMatch(dog -> dog.getName().equals(name))) return false;
        dogs.removeIf(dog -> dog.getName().equals(name));
        return true;
    }

    Iterator<Dog> iteratorDogs() {
        return dogs.iterator();
    }

    String getName() {
        return name;
    }

    String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "\ncpf='" + cpf + '\'' +
                "\n";
    }
}
