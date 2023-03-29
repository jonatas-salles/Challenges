package zoo;

public class Zoologico {
    private Animal[] jaula;
    private int idxAnimal = 0;

    public Zoologico() {
        this.jaula = new Animal[10];
    }

    public void addAnimal(Animal animal) {
        jaula[idxAnimal++] = animal;
    }

    public void realizarAtividade() {
        for (Animal animal : jaula) {
            System.out.println();
            animal.emitirSom();
            if (animal instanceof PodeCorrer) {
                ((PodeCorrer) animal).correr();
            }
        }
    }
}
