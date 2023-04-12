package org.example.PetShop;

import java.util.*;

public class PetShop {
    private final String name;
    private final Map<String, Person> clients = new HashMap<>();

    public PetShop(String name) {
        this.name = name;
    }

    public void addClient(String cpf, String name) throws AlreadyExistsException {
        if (clients.containsKey(cpf)) throw new AlreadyExistsException("CPF");
        clients.put(cpf, new Person(cpf, name));
    }

    public void removeClient(String cpf) throws NotFoundException {
        if (!clients.containsKey(cpf)) throw new NotFoundException("CPF");
        clients.remove(cpf);
    }

    public void addDog(String cpf, String name, String breed, boolean is_vaccinated) throws AlreadyExistsException, NotFoundException {
        if (!clients.containsKey(cpf)) throw new NotFoundException("CPF");
        if (!clients.get(cpf).addDog(new Dog(name, breed, is_vaccinated))) throw new AlreadyExistsException("Dog with name " + name);
    }

    public void removeDog(String cpf, String name) throws NotFoundException {
        if (!clients.containsKey(cpf)) throw new NotFoundException("CPF");
        if(!clients.get(cpf).removeDog(name)) throw new NotFoundException("Dog with name " + name);
    }

    public Iterator<Person> listClients() {
        return clients.values().iterator();
    }

    public Iterator<Dog> listDogs(String cpf) throws NotFoundException {
        if (!clients.containsKey(cpf)) throw new NotFoundException("CPF");
        Person person = clients.get(cpf);

        return person.iteratorDogs();
    }

    public Iterator<Dog> listVaccinated(boolean is_vaccinated) {
        List<Dog> vaccinatedDogs = new ArrayList<Dog>();

        for (Person client : clients.values()) {
            Iterator<Dog> it = client.iteratorDogs();
            while (it.hasNext()) {
                Dog dog = it.next();
                if (dog.getVaccineStatus() == is_vaccinated) {
                    vaccinatedDogs.add(dog);
                }
            }
        }

        return vaccinatedDogs.iterator();
    }

    public Iterator<Dog> listVaccinated(boolean is_vaccinated, String cpf) throws NotFoundException {
        if (!clients.containsKey(cpf)) throw new NotFoundException("CPF");
        List<Dog> vaccinatedDogs = new ArrayList<Dog>();

        Person client = clients.get(cpf);
        Iterator<Dog> it = client.iteratorDogs();
        while (it.hasNext()) {
            Dog dog = it.next();
            if (dog.getVaccineStatus() == is_vaccinated) {
                vaccinatedDogs.add(dog);
            }
        }

        return vaccinatedDogs.iterator();
    }

    public String getName() {
        return name;
    }
}
