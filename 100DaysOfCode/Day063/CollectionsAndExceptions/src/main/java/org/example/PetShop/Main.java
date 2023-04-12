package org.example.PetShop;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PetShop petShop = new PetShop("PetCare");

        System.out.println("Welcome to PetShop " + petShop.getName());


        boolean is_on = true;
        while (is_on) {
            System.out.println("""
                    --------------------
                    [1] Add client
                    [2] Add Dog
                    [3] List clients
                    [4] List client dogs
                    [5] List vaccinated dogs
                    [6] List client vaccinated dogs
                    [7] Remove client
                    [8] Remove client dog
                    
                    [0] Exit
                    --------------------
                    """);
            String cpf, name, breed;
            boolean is_vaccinated;
            int option;

            try {
                option = Integer.parseInt(in.nextLine());
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Cannot Parse " + e.getMessage() + " to Integer");
                option = 0;
            }

            switch (option) {
                case 0 -> is_on = false;
                case 1 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Client name: ");
                    name = in.nextLine();
                    try {
                        petShop.addClient(cpf, name);
                        System.out.println("Success!\n");
                    }
                    catch (AlreadyExistsException e) {
                        e.printStackTrace();
                    }
                }
                case 2 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Dog name: ");
                    name = in.nextLine();
                    System.out.println("Dog breed: ");
                    breed = in.nextLine();
                    System.out.println("Is dog vaccinated? (true/false) ");
                    is_vaccinated = Boolean.parseBoolean(in.nextLine());

                    try {
                        petShop.addDog(cpf, name, breed, is_vaccinated);
                    }
                    catch (AlreadyExistsException | NotFoundException e) {
                        e.printStackTrace();
                    }
                }
                case 3 -> {
                    Iterator<Person> itPerson = petShop.listClients();
                    while (itPerson.hasNext()) {
                        System.out.println(itPerson.next().toString());
                    }
                }
                case 4 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();

                    try {
                        Iterator<Dog> itClientDogs = petShop.listDogs(cpf);
                        while (itClientDogs.hasNext()) {
                            System.out.println(itClientDogs.next().toString());
                        }
                    }
                    catch (NotFoundException e) {
                        e.printStackTrace();
                        System.out.println("Please provide a valid cpf");
                    }
                }
                case 5 -> {
                    System.out.println("Is dog vaccinated? (true/false) ");
                    is_vaccinated = Boolean.parseBoolean(in.nextLine());
                    System.out.println(is_vaccinated);
                    Iterator<Dog> itVaccinatedDog = petShop.listVaccinated(is_vaccinated);

                    while (itVaccinatedDog.hasNext()) {
                        System.out.println(itVaccinatedDog.next().toString());
                    }
                }
                case 6 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Is dog vaccinated? (true/false) ");
                    is_vaccinated = Boolean.parseBoolean(in.nextLine());

                    try {
                        Iterator<Dog> itClientVaccinatedDogs = petShop.listVaccinated(is_vaccinated, cpf);
                        while (itClientVaccinatedDogs.hasNext()) {
                            System.out.println(itClientVaccinatedDogs.next().toString());
                        }
                    }
                    catch (NotFoundException e) {
                        e.printStackTrace();
                        System.out.println("Please provide a valid cpf");
                    }
                }
                case 7 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    try {
                        petShop.removeClient(cpf);
                        System.out.println("Success!\n");
                    }
                    catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
                case 8 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Dog name: ");
                    name = in.nextLine();

                    try {
                        petShop.removeDog(cpf, name);
                        System.out.println("Success!\n");
                    }
                    catch (NotFoundException e) {
                        e.printStackTrace();
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }
}
