package praticaHeranca;

public abstract class Figura {
    private int x;
    private int y;
    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }

}
