import PetShop.PetShop;

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
            int option = Integer.parseInt(in.nextLine());

            switch (option) {
                case 0 -> is_on = false;
                case 1 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Client name: ");
                    name = in.nextLine();
                    petShop.addClient(cpf, name);
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
                    petShop.addDog(cpf, name, breed, is_vaccinated);
                }
                case 3 -> petShop.listClients();
                case 4 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    petShop.listDogs(cpf);
                }
                case 5 -> {
                    System.out.println("Is dog vaccinated? (true/false) ");
                    is_vaccinated = Boolean.parseBoolean(in.nextLine());
                    petShop.listVaccinated(is_vaccinated);
                }
                case 6 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Is dog vaccinated? (true/false) ");
                    is_vaccinated = Boolean.parseBoolean(in.nextLine());
                    petShop.listVaccinated(is_vaccinated, cpf);
                }
                case 7 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    petShop.removeClient(cpf);
                }
                case 8 -> {
                    System.out.println("Client cpf: ");
                    cpf = in.nextLine();
                    System.out.println("Dog name: ");
                    name = in.nextLine();
                    petShop.removeDog(cpf, name);
                }
            }
        }
    }
}
