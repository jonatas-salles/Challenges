package imposto;

public class Declaracao {
    private int idxGastos = 0;

    private Gasto[] gastos = new Gasto[10];

    public double getValorImposto() {
        double gasto_total = 0;
        for (int i=0; i<idxGastos; i++) {
            gasto_total += gastos[i].getValor();
        }
        return gasto_total * 0.05;
    }

    public void addGasto(Gasto gasto) {
        gastos[idxGastos++] = gasto;
    }

    public void removeGasto(Gasto gasto) {
        int idxDelete = -1;
        for (int i=0; i<idxGastos && idxDelete == -1; i++) {
            if (gastos[i] == gasto) {
                idxDelete = i;
            }
        }

        if (idxDelete == -1) return;
        for (int i=idxDelete; i<idxGastos-1; i++) {
            gastos[i] = gastos[i+1];
        }
        gastos[--idxGastos] = null;
    }

    public String getGastos() {
        StringBuilder gasto = new StringBuilder("\nValores gastos:\n");
        for (int i=0; i<idxGastos; i++) {
            String str = gastos[i].getDescricao() + " = " + gastos[i].getValor() + "\n";
            gasto.append(str);
        }

        return String.valueOf(gasto);
    }
}
