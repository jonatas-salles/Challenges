#include <stdio.h>
#include <string.h>

void ordena_string(char *string) {
    int i, aux, pode_trocar;
    
    pode_trocar = 1;
    while(pode_trocar) {
        pode_trocar = 0;
        for(i = 0; i < strlen(string) - 1; i++) {
            if(string[i] > string[i+1]) {
                aux = string[i];
                string[i] = string[i+1];
                string[i+1] = aux;
                pode_trocar = 1;
            }
        }
    }
}

void remove_espacos(char *string) {
    int i, cont = 0;

    for (i=0; string[i] != '\0'; i++) {
        if (string[i] != ' ') {
            string[cont++] = string[i];
        }
    }

    string[cont] = '\0';
}

int verifica_anagrama(char *string1, char *string2) {

    remove_espacos(string1);
    remove_espacos(string2);

    ordena_string(string1);
    ordena_string(string2);

    if (stricmp(string1, string2) == 0) {
        return 1;
    } else {
        return 0;
    }
}

int main() {
    char str1[100];
    char str2[100];
    int resultado;

    printf("Insira a primeira string: ");
    gets(str1);

    printf("Insira a segunda string: ");
    gets(str2);

    resultado = verifica_anagrama(str1, str2);

    if (resultado == 1) {
        printf("\nAs strings formam um anagrama\n");
    } else {
        printf("\nAs strings nao formam um anagrama\n");
    }
}