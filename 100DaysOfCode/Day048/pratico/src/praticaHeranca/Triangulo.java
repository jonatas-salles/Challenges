package praticaHeranca;

public class Triangulo extends Figura {
    private double ladoA;
    private double ladoB;
    private double ladoC;

    public Triangulo(int x, int y, double ladoA, double ladoB, double ladoC) {
        super(x, y);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double getArea() {
        double p = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(p * (p-ladoA) * (p-ladoB) * (p-ladoC));
    }

    @Override
    public String toString() {
        return String.format("Triangulo = %s | a = %.2f | b = %.2f, c = %.2f | area = %.2f", super.toString(), ladoA, ladoB, ladoC, getArea());
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        this.ladoC = ladoC;
    }
}
