#include <stdio.h>
#include <string.h>

int main() {
    char nome[60];

    printf("Nome completo: ");
    gets(nome);
    
    printf("\nMinuscula: %s", strlwr(nome));
    printf("\nMaiuscula: %s", strupr(nome));
}