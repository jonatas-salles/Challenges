package petShop;

public class Cachorro {
    private String nome;
    private String raca;
    private boolean statusVacina;
    private Pessoa dono;

    public Cachorro(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
        this.statusVacina = false;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public void setStatusVacina(boolean status) {
        this.statusVacina = status;
    }

    public String getInfo() {
        return String.format("Nome: %s\nRaca: %s\nVacinado: %b\nDono: %s\n", nome, raca, statusVacina, dono.getNome());
    }
}
