package zoo;

public class Main {
    public static void main(String[] args) {
        Zoologico zoo = new Zoologico();

        Animal leao = new Leao("Leao");
        Animal lobo = new Lobo("Lobo");
        Animal coruja = new Coruja("Coruja");

        zoo.addAnimal(leao);
        zoo.addAnimal(coruja);
        zoo.addAnimal(leao);
        zoo.addAnimal(coruja);
        zoo.addAnimal(leao);
        zoo.addAnimal(lobo);
        zoo.addAnimal(coruja);
        zoo.addAnimal(lobo);
        zoo.addAnimal(lobo);
        zoo.addAnimal(coruja);

        zoo.realizarAtividade();
    }
}