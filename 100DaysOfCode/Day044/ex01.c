#include <stdio.h>
#include <string.h>

int main() {
    char palavra[40];
    char palavra_invertida[40];

    printf("Digite a palavra que deseja verificar se e um palindromo: ");
    gets(palavra);

    strcpy(palavra_invertida, palavra);
    strrev(palavra_invertida);

    if(stricmp(palavra, palavra_invertida) == 0) {
        printf("E um palindromo\n");
    } else {
        printf("Nao e um palindromo\n");
    }
}