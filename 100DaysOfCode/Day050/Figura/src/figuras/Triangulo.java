package figuras;

public class Triangulo extends Figura {
    private final double ladoA;
    private final double ladoB;
    private final double ladoC;

    public Triangulo(int x, int y, double ladoA, double ladoB, double ladoC) {
        super(x, y);
        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    @Override
    public double area() {
        double perimetro = (ladoA + ladoB + ladoC) / 2;
        return Math.sqrt(perimetro * (perimetro - ladoA) * (perimetro - ladoB) * (perimetro - ladoC));
    }
}
