package imposto;

public class Main {
    public static void main(String[] args) {
        Gasto gasto1 = new Gasto(1, "Saude", 1200, "1331");
        Gasto gasto2 = new Gasto(2, "Educacao", 2000, "1332");
        Gasto gasto3 = new Gasto(3, "Manutencao", 200, "1333");
        Gasto gasto4 = new Gasto(4, "Lazer", 500, "1334");

        Declaracao declaracao = new Declaracao();
        declaracao.addGasto(gasto1);
        declaracao.addGasto(gasto2);

        System.out.println("Valor do imposto com gasto1 e gasto2: " + declaracao.getValorImposto());

        System.out.println(declaracao.getGastos());
        declaracao.addGasto(gasto3);

        System.out.println("Valor do imposto com gasto1, gasto2 e gasto3: " + declaracao.getValorImposto() + "\n");

        declaracao.removeGasto(gasto1);

        System.out.println("Valor do imposto apos remover gasto 1: " + declaracao.getValorImposto());
        System.out.println(declaracao.getGastos());

        System.out.println("Metodo toString() do gasto4: " + gasto4);
    }
}
