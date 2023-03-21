#include <stdio.h>
#include <stdlib.h>

int main() {
  int vetor[500];
  int aux, pode_trocar, num;
  int inicio = 0, meio = 0, fim = 500;
  
  for (int i=0; i<500; i++) { 
    vetor[i] = rand() % 1000 + 1;
  }

  pode_trocar = 1;
  while(pode_trocar) {
    pode_trocar = 0;
    for (int i=0; i<fim-1; i++) {
      if (vetor[i] > vetor[i+1]) {
        aux = vetor[i];
        vetor[i] = vetor[i+1];
        vetor[i+1] = aux;
        pode_trocar = 1;
      }
    }
  }

  printf("Informe um valor entre 0 e 1000 para ser encontrado no vetor: ");
  scanf("%d", &num);

  int encontrou = 0;
  // Busca sequencial
  for (int i=0; i<fim && encontrou == 0; i++) {
    if (num == vetor[i]) {
      printf("\nBusca sequencial:\nValor %d encontrado na posicao: %d", num, i);
      encontrou = 1;
    }
  }
  if (encontrou == 0) {
    printf("\nValor nao encontrado na busca sequencial");
  }

  // Busca binaria
  fim = fim-1;
  encontrou = 0;
  int execucao = 0;
  while (inicio <= fim && encontrou == 0) {
    meio = (inicio + fim) / 2;
    execucao++;

    if (num == vetor[meio]) {
      encontrou = 1;
      printf("\nBusca binaria:\nValor %d encontrado na execucao de numero: %d", vetor[meio], execucao);
    } 
    else { 
        if (num < vetor[meio]) {
          fim = meio-1;
        } 
        else {
          inicio = meio+1;
        }
    }
  }
  if (encontrou == 0) {
      printf("\nValor nao encontrado na busca binaria");
    }

    system("pause");
}
