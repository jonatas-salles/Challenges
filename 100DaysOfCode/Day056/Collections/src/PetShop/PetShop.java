package PetShop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PetShop {
    private final String name;
    private final Map<String, Person> clients = new HashMap<>();

    public PetShop(String name) {
        this.name = name;
    }

    public void addClient(String cpf, String name) {
        if (clients.containsKey(cpf)) return;
        clients.put(cpf, new Person(cpf, name));
    }

    public void removeClient(String cpf) {
        if (!clients.containsKey(cpf)) return;
        clients.remove(cpf);
    }

    public void addDog(String cpf, String name, String breed, boolean is_vaccinated) {
        if (!clients.containsKey(cpf)) return;
        clients.get(cpf).addDog(new Dog(name, breed, is_vaccinated));
    }

    public void removeDog(String cpf, String name) {
        if (!clients.containsKey(cpf)) return;
        clients.get(cpf).removeDog(name);
    }

    public void listClients() {
        for (Person person : clients.values()) {
            System.out.println(person.toString());
            System.out.println();
        }
    }

    public void listDogs(String cpf) {
        if (!clients.containsKey(cpf)) return;
        Person person = clients.get(cpf);
        Iterator<Dog> dogs = person.iteratorDogs();

        System.out.println("Tutor='" + person.getName() + "'\n");
        while (dogs.hasNext()) {
            System.out.println(dogs.next());
            System.out.println();
        }
    }

    public void listVaccinated(boolean is_vaccinated) {
        for (Person client : clients.values()) {
            Iterator<Dog> it = client.iteratorDogs();
            while (it.hasNext()) {
                Dog dog = it.next();
                if (dog.getVaccineStatus() == is_vaccinated) {
                    System.out.println(dog);
                    System.out.println();
                }
            }
        }
    }

    public void listVaccinated(boolean is_vaccinated, String cpf) {
        if (!clients.containsKey(cpf)) return;
        Person client = clients.get(cpf);
        Iterator<Dog> it = client.iteratorDogs();
        while (it.hasNext()) {
            Dog dog = it.next();
            if (dog.getVaccineStatus() == is_vaccinated) {
                System.out.println(dog);
                System.out.println();
            }
        }
    }

    public String getName() {
        return name;
    }
}
