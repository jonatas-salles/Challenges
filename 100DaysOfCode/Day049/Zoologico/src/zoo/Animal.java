package zoo;

abstract class Animal {
    String nome;
    public abstract void emitirSom();

    public Animal(String nome) {
        this.nome = nome;
    }
}

class Leao extends Animal implements PodeCorrer {
    public Leao(String nome) {
        super(nome);
    }

    @Override
    public void correr() {
        System.out.println("O leão está correndo...");
    }

    @Override
    public void emitirSom() {
        System.out.println("Leão faz: Rrrrwarrr");
    }
}

class Lobo extends Animal implements PodeCorrer {
    public Lobo(String nome) {
        super(nome);
    }

    @Override
    public void correr() {
        System.out.println("O lobo está correndo...");
    }
    @Override
    public void emitirSom() {
        System.out.println("Lobo faz: Auuuuuu Auuuuuuu");
    }
}

class Coruja extends Animal {
    public Coruja(String nome) {
        super(nome);
    }

    public void voar() {
        System.out.println("A coruja está voando...");
    }

    @Override
    public void emitirSom() {
        System.out.println("Coruja faz: Pruuu Pruuu");
    }
}
