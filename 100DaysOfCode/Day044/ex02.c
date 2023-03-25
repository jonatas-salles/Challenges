#include <stdio.h>
#include <string.h>

int main() {
    int i;
    char nome[40];

    printf("Insira um nome: ");
    gets(nome);

    for (i=0; i<4; i++) {
        printf("%c", nome[i]);
    }
}

