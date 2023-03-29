package praticaHeranca;

public class Main {
    public static void main(String[] args) {
        final Triangulo triangulo = new Triangulo(1, 1, 3, 4, 5);
        final Circulo circulo = new Circulo(1, 1, 1);
        final Retangulo retangulo = new Retangulo(1, 1, 5, 4);

        System.out.println(triangulo);
        System.out.println(circulo);
        System.out.println(retangulo);
    }
}