package praticaHeranca;

public class Retangulo extends Figura {
    private double largura;
    private double comprimento;

    public Retangulo(int x, int y, double largura, double comprimento) {
        super(x, y);
        this.largura = largura;
        this.comprimento = comprimento;
    }

    @Override
    public double getArea() {
        return largura * comprimento;
    }

    @Override
    public String toString() {
        return String.format("Retangulo = %s | largura = %.2f | altura = %.2f | area = %.2f", super.toString(), largura, comprimento, getArea());
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
}
