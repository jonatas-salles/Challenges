#include <stdio.h>
#include <locale.h>

#define max 100 // define o tamanho máximo do vetor de funcionarios

struct Funcionario
{
    int cod, num_dep;
    char nome[40], cargo[40];
    float salario;
};

int cadastrar_funcionario(struct Funcionario vet_func[], int *indice) {
    if (*indice>max) return 0;
    
    setbuf(stdin, NULL);
    printf("\nDigite o nome do funcionário: ");
    gets(vet_func[*indice].nome);
    printf("\nDigite o cargo do funcionário: ");
    gets(vet_func[*indice].cargo);
    printf("\nDigite o código do funcionário: ");
    scanf("%d", &vet_func[*indice].cod);
    printf("\nDigite o número de dependentes do funcionário: ");
    scanf("%d", &vet_func[*indice].num_dep);
    printf("\nDigite o salário do funcionário: ");
    scanf("%f", &vet_func[*indice].salario);
    setbuf(stdin, NULL);
    (*indice)++; // incrementa na variavel definida na função main

    return 1;
}

int consultar_funcionario(struct Funcionario vet_func[], int indice, int codigo) {
    int i;

    for (i=0; i<indice; i++) {
        if (vet_func[i].cod == codigo) {
            return i;
        }
    }

    return -1;
}

int remover_funcionario(struct Funcionario vet_func[], int *indice, int codigo) {
    int i;
    i = consultar_funcionario(vet_func, (*indice), codigo);

    if (i == -1) return 0;

    for (i; i<*indice-1; i++) {
        vet_func[i] = vet_func[i+1];
    }
    (*indice)--;

    return 1;
}

main() {
    setlocale(LC_ALL, "Portuguese");

    struct Funcionario funcionarios[max];
    int idx_funcionarios = 0, opcao;

    do {
        printf("\nMenu de opções:\n\t1. Inserir Funcionário\n\t2. Consultar Funcionário\n\t3. Remover Funcionário\n\t0. Sair\n");
        scanf("%d", &opcao);

        switch (opcao) {
        case 1:
            if (cadastrar_funcionario(funcionarios, &idx_funcionarios) == 1) {
                printf("Cadastro realizado com sucesso!\n");
            } else {
                printf("Cadastro falhou!\n");
            }
            
            break;
        
        case 2:
            int codigo, func_encontrado;
            
            printf("Insira o código que deseja buscar: ");
            scanf("%d", &codigo);

            func_encontrado = consultar_funcionario(funcionarios, idx_funcionarios, codigo);
            if (func_encontrado != -1) {
                printf("\nNome: %s\nCargo: %s\nCódigo: %d\nDependentes: %d\nSalário: %.2f\n", funcionarios[func_encontrado].nome, funcionarios[func_encontrado].cargo, funcionarios[func_encontrado].cod,
                funcionarios[func_encontrado].num_dep, funcionarios[func_encontrado].salario);
            } else {
                printf("A consulta não retornou nenhum funcionário.\n");
            }
            break;

        case 3:
            printf("Insira o código que deseja remover: ");
            scanf("%d", &codigo);
            
            if (remover_funcionario(funcionarios, &idx_funcionarios, codigo) == 1) {
                printf("\nRemoção realizada com sucesso!\n");
            } else {
                printf("\nRemoção falhou!\n");
            }

            break;
        
        default:
        printf("Opção não localizada.\nFinalizando o programa...\n");
            opcao = 0;
            break;
        }

    } while(opcao != 0);
}
