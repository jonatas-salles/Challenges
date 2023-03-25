#include <stdio.h>
#include <string.h>

int main() {
    char nome[20];
    char sobrenome[20];

    printf("\nInsira o primeiro nome: ");
    gets(nome);

    printf("Escreva o sobrenome: ");
    gets(sobrenome);

    strcat(strcat(nome, " "), sobrenome);
    
    printf("\n%s", nome);
    printf("\nCaracteres: %d", strlen(nome));
    printf("\nPrimeira letra: %c", nome[0]);
    printf("\nUltima letra: %c\n", nome[strlen(nome)-1]);
}