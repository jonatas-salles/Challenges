package praticaHeranca;

public class Circulo extends Figura{
    private double raio;
    public Circulo(int x, int y, double raio) {
        super(x, y);
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public String toString() {
        return String.format("Circulo = %s | raio = %.2f | area = %.2f", super.toString(), raio, getArea());
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}
