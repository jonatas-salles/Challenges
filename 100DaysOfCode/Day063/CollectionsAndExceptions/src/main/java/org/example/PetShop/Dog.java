package org.example.PetShop;

class Dog {
    private final String name;
    private final String breed;
    private final boolean is_vaccinated;

    public Dog(String name, String breed, boolean is_vaccinated) {
        this.name = name;
        this.breed = breed;
        this.is_vaccinated = is_vaccinated;
    }

    String getName() {
        return name;
    }

    String getBreed() {
        return breed;
    }

    boolean getVaccineStatus() {
        return is_vaccinated;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                "\nbreed='" + breed + '\'' +
                "\nis_vaccinated=" + is_vaccinated +
                "\n";
    }
}
