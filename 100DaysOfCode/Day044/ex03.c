#include <stdio.h>
#include <string.h>

int main() {
    int i, j;
    char aux[40];
    char nomes[10][40];
    char nomes_crescente[10][40];

    for (i=0; i<10; i++) {
        printf("Digite o %d nome: ", i+1);
        gets(nomes[i]);
    }

    int pode_trocar = 1;
    while (pode_trocar) {
        pode_trocar = 0;
        for (i=0; i<9; i++) {
            if (stricmp(nomes[i], nomes[i+1])>0) {
                strcpy(aux, nomes[i]);
                strcpy(nomes[i], nomes[i+1]);
                strcpy(nomes[i+1], aux);
                pode_trocar = 1;
            }
        }
    }

    for (i=0; i<10; i++) {
        puts(nomes[i]);
    }
}
