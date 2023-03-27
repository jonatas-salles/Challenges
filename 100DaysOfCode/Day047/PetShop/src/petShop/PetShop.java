package petShop;

public class PetShop {
    private String nome;

    public PetShop(String nome) {
        this.nome = nome;
    }

    public void vacinar(Cachorro cachorro) {
        cachorro.setStatusVacina(true);
    }

    public void removerVacina(Cachorro cachorro) {
        cachorro.setStatusVacina(false);
    }
}
