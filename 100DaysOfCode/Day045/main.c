#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Funcionario {
    char codigo[20], cargo[20], nome[60];
    int dependentes;
    float salario;
};

int main() {
    struct Funcionario funcionario;
    printf("Nome: ");
    gets(funcionario.nome);
    printf("Codigo: ");
    gets(funcionario.codigo);
    printf("Cargo: ");
    gets(funcionario.cargo);
    printf("Numero de dependentes: ");
    scanf("%d", &funcionario.dependentes);
    printf("Salario: ");
    scanf("%f", &funcionario.salario);
    setbuf(stdin, NULL);


    printf("\nNome: %s\nCodigo: %s\nCargo: %s\nDependentes: %d\nSalario: %.3f\n", funcionario.nome, funcionario.codigo, funcionario.cargo, funcionario.dependentes, funcionario.salario);

    printf("\nCargo: ");
    gets(funcionario.cargo);
    printf("Novo salario: ");
    scanf("%f", &funcionario.salario);

    printf("\nNome: %s\nCodigo: %s\nCargo: %s\nDependentes: %d\nSalario: %.3f", funcionario.nome, funcionario.codigo, funcionario.cargo, funcionario.dependentes, funcionario.salario);
}
