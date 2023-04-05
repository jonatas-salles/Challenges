package PetShop;

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
    void addDog(Dog newDog) {
        if (dogs.contains(newDog)) return;
        for (Dog dog : dogs) {
            if (dog.getName().equals(newDog.getName())) return;
        }
        dogs.add(newDog);
    }

    void removeDog(String name) {
        dogs.removeIf(dog -> dog.getName().equals(name));
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
                "\ncpf='" + cpf + '\'';
    }
}
