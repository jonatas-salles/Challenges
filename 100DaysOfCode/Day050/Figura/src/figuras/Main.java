package figuras;

public class Main {
    public static void main(String[] args) {

        Figura[] figuras;
        figuras = new Figura[150];
        int idxFiguras = 0;
        double soma = 0;

        for (int i=1; i<=50; i++) {
            Figura triangulo = new Triangulo(1, 1, i, i, i);
            figuras[idxFiguras++] = triangulo;
        }

        for (int i=1; i<=50; i++) {
            Figura circulo = new Circulo(1, 1, i);
            figuras[idxFiguras++] = circulo;
        }

        for (int i=1; i<=50; i++) {
            Figura retangulo = new Retangulo(1, 1, i, i);
            figuras[idxFiguras++] = retangulo;
        }

        for (int i=0; i<idxFiguras; i++) {
            soma += figuras[i].area();
        }

        System.out.println("Soma da area das 150 figuras: " + soma);
    }
}