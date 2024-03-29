package figuras;

public class Retangulo extends Figura {
    private final double largura;
    private final double comprimento;
    public Retangulo(int x, int y, double largura, double comprimento) {
        super(x, y);
        this.largura = largura;
        this.comprimento = comprimento;
    }

    @Override
    public double area() {
        return largura * comprimento;
    }
}
