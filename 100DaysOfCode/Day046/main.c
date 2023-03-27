#include <stdio.h>
#include <string.h>

struct Habitante {
    char sexo[15];
    float salario;
    int idade, filhos;
};

int main() {
    struct Habitante habitantes[20];
    int i;
    float media_salario = 0, media_filhos = 0, maior_salario, menor_salario, percentual_salario_mulheres, mulheres = 0, mulheres_superior = 0;

    for (i=0; i<20; i++) {
        printf("\nSexo: ");
        gets(habitantes[i].sexo);
        printf("Idade: ");
        scanf("%d", &habitantes[i].idade);
        printf("Quantidade de filhos: ");
        scanf("%d", &habitantes[i].filhos);
        printf("Salario: ");
        scanf("%f", &habitantes[i].salario);
        setbuf(stdin, NULL);
    }

    maior_salario = habitantes[0].salario;
    menor_salario = habitantes[0].salario;
    for (i=0; i<20; i++) {
        media_salario += habitantes[i].salario;
        media_filhos += habitantes[i].filhos;
        
        if (habitantes[i].salario > maior_salario) {
            maior_salario = habitantes[i].salario;
        }
        if (habitantes[i].salario < menor_salario) {
            menor_salario = habitantes[i].salario;
        }

        if (stricmp(habitantes[i].sexo, "feminino") == 0) {
            mulheres++;
            if (habitantes[i].salario > 1.500) {
                mulheres_superior++;
            }
        }
    }
    
    media_filhos = media_filhos/20;
    media_salario = media_salario/20;
    percentual_salario_mulheres = (mulheres_superior/mulheres) * 100;
   
    printf("\nMedia de salario da populacao: %.3f\nMedia de filhos: %.1f\nMaior salario: %.3f\nMenor salario: %.3f\nPercentual de mulheres com salario superior a 1.500: %.2f%%", media_salario, media_filhos, maior_salario, menor_salario, percentual_salario_mulheres);
}
