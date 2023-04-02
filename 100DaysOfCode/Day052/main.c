#include <stdio.h>

int * substitui_negativos(int valores[10]) {
    int i;
    for (i=0; i<10; i++) {
        if (valores[i] < 0) {
            valores[i] = 0;
        }
    }

    return valores;
}

int main() {
    int valores[] = {-15, 3, 7, -12, -1, 1, 10, 183, -993, 5}, *valores_substituidos;

    printf("Valores antes da substituicao:\n");
    for (int i=0; i<10; i++) {
        printf("%d ", valores[i]);
    }
    
    valores_substituidos = substitui_negativos(valores);

    printf("\nValores apos a substituicao:\n");
    for (int i=0; i<10; i++) {
        printf("%d ", valores_substituidos[i]);
    }
}
