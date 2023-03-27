package petShop;

public class Main {
    public static void main(String[] args) {
        PetShop petCuidar = new PetShop("PetCuidar");

        Pessoa joao = new Pessoa("Joao", "111.111.111-11");
        Pessoa maria = new Pessoa("Maria", "222.222.222-22");

        Cachorro thor = new Cachorro("Thor", "PitBull");
        Cachorro bill = new Cachorro("Bill", "Border Collie");
        Cachorro kiara = new Cachorro("Kiara", "Boxer");

        joao.addCachorro(thor);
        maria.addCachorro(kiara);

        System.out.println("Cachorros do Joao:");
        joao.listarCachorros();

        System.out.println("Cachorros da Maria:");
        maria.listarCachorros();

        petCuidar.vacinar(thor);
        System.out.println("Cachorros do Joao apos vacinar Thor:");
        joao.listarCachorros();

        joao.addCachorro(bill);
        System.out.println("Cachorros do Joao apos adicionar Bill:");
        joao.listarCachorros();

        maria.removeCachorro(kiara);
        System.out.println("Cachorros da Maria apos remover Kiara:");
        maria.listarCachorros();
    }
}