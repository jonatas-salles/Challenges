#include <stdio.h>
#include <string.h>

struct Habitante {
    char sexo[15];
    float salario;
    int idade, filhos;
};

float calcula_media_salarios(struct Habitante *habitantes, int qtd_habitantes) {
    int i;
    float salario = 0, media_salario;
    
    for (i=0; i<qtd_habitantes; i++) {
        salario += habitantes[i].salario;
    }

    media_salario = salario/qtd_habitantes;
    return media_salario;
}

float calcula_media_filhos(struct Habitante *habitantes, int qtd_habitantes) {
    int i;
    float filhos = 0, media_filhos;

    for (i=0; i<qtd_habitantes; i++) {
        filhos += habitantes[i].filhos;
    }

    media_filhos = filhos/qtd_habitantes;
    return media_filhos;
}

float get_maior_salario(struct Habitante *habitantes, int qtd_habitantes) {
    int i;
    float maior_salario = habitantes[0].salario;

    for (i=0; i<qtd_habitantes; i++) {
        if (habitantes[i].salario > maior_salario) {
            maior_salario = habitantes[i].salario;
        }
    }

    return maior_salario;
}

float get_menor_salario(struct Habitante *habitantes, int qtd_habitantes) {
    int i;
    float menor_salario = habitantes[0].salario;

    for (i=0; i<qtd_habitantes; i++) {
        if (habitantes[i].salario < menor_salario) {
            menor_salario = habitantes[i].salario;
        }
    }

    return menor_salario;
}

float percentual_mulheres_salario_superior(struct Habitante *habitantes, int qtd_habitantes) {
    int i; 
    float mulheres = 0, mulheres_superior = 0, percentual;

    for (i=0; i<qtd_habitantes; i++) {
        if (stricmp(habitantes[i].sexo, "f") == 0) {
            mulheres++;
            if (habitantes[i].salario > 1500) {
                mulheres_superior++;
            }
        }
    }

    percentual = (mulheres_superior/mulheres) * 100;
    return percentual;
}

int main() {
    int qtd_habitantes = 10, i;
    struct Habitante habitantes[qtd_habitantes];

    for (i=0; i<qtd_habitantes; i++) {
        printf("\nSexo: (m/f) ");
        gets(habitantes[i].sexo);
        printf("Idade: ");
        scanf("%d", &habitantes[i].idade);
        printf("Quantidade de filhos: ");
        scanf("%d", &habitantes[i].filhos);
        printf("Salario: ");
        scanf("%f", &habitantes[i].salario);
        setbuf(stdin, NULL);
    }

    printf("\n------------------------------------------------------------------------------------------");
    printf("Media de salario da populacao: %.2f\n", calcula_media_salarios(habitantes, qtd_habitantes));
    printf("Media de filhos da populacao: %.1f\n", calcula_media_filhos(habitantes, qtd_habitantes));
    printf("Maior salario: %.2f\n", get_maior_salario(habitantes, qtd_habitantes));
    printf("Menor salario: %.2f\n", get_menor_salario(habitantes, qtd_habitantes));
    printf("Percentual de mulheres com salario superior a 1500: %.2f%%", percentual_mulheres_salario_superior(habitantes, qtd_habitantes));
}
