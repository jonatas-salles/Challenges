#include <stdio.h>
#include <string.h>

int main() {
    char nome[40];

    printf("Insira um nome: ");
    gets(nome);

    printf("Esse nome possui %d letras", strlen(nome));
}