package figuras;

abstract class Figura {
    private int x;
    private int y;
    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract double area();

}
