#include <stdio.h>
#include <string.h>

void remove_ocorrencia(char *string, char letra) {
    int i, charIdx = -1;
    for (i=0; i<strlen(string) && charIdx == -1; i++) {
        if (string[i] == letra) {
            charIdx = i;
        }
    }
    
    if (charIdx >= 0) {
        for (i=charIdx; i<strlen(string); i++) {
            string[i] = string[i+1];
        }
    }
}

int main() {
    char string[100], letra;

    printf("Palavra: ");
    gets(string);

    printf("Letra: ");
    scanf("%c", &letra);

    remove_ocorrencia(string, letra);
    printf("\nString apos remover primeira ocorrencia com a letra %c: %s\n", letra, string);
}
