#include <stdio.h>
#include <math.h>

int calcula_delta(int a, int b, int c) {
    return ((b*b) - 4) * a * c;
}

int calcula_raiz(int a, int b) {
    return (-b) / (2*a);
}

void calcula_raizes(int a, int b, int delta, int *x1, int *x2) {
    *x1 = (-b + sqrt(delta)) / (2*a);
    *x2 = (-b - sqrt(delta) / (2*a));
}

int main() {
    int delta, a, b, c, x1, x2;

    printf("A: ");
    scanf("%d", &a);
    printf("B: ");
    scanf("%d", &b);
    printf("C: ");
    scanf("%d", &c);

    delta = calcula_delta(a, b, c);

    if (delta == 0) {
        printf("\nX: %d", calcula_raiz(a, b));
    } else if (delta > 0) {
        calcula_raizes(a, b, delta, &x1, &x2);
        printf("\nX1: %d\nX2: %d", x1, x2);
    } else {
        printf("Nao existe raiz real");
    }
}
