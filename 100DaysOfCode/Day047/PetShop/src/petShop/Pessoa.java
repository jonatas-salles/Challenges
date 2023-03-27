package petShop;

public class Pessoa {
    private String nome;
    private String cpf;
    private Cachorro[] cachorros;
    private int idxCachorros = 0;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.cachorros = new Cachorro[20];
    }

    public void addCachorro(Cachorro cachorro) {
        cachorro.setDono(this);
        cachorros[idxCachorros++] = cachorro;
    }

    public void removeCachorro(Cachorro cachorro) {
        int idx = getIdxCachorro(cachorro);
        if (idx<0 || idx>idxCachorros) return;
        for (int i=idx; i<idxCachorros-1; i++) {
            cachorros[i] = cachorros[i+1];
        }
        cachorros[--idxCachorros] = null;
    }

    public String getNome() {
        return this.nome;
    }

    public void listarCachorros() {
        for (int i=0; i<idxCachorros; i++) {
            System.out.println(cachorros[i].getInfo());
        }
    }

    private int getIdxCachorro(Cachorro cachorro) {
        for (int i=0; i<idxCachorros; i++) {
            if (cachorros[i] == cachorro) {
                return i;
            }
        }
        return -1;
    }
}
