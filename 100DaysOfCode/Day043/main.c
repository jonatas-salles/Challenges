#include <stdio.h>
#include <stdlib.h>

int fibonacci(int n) {
    if (n<=2) {
        return n;
    }

    return fibonacci(n-1) + fibonacci(n-2);
}

int main() {
    int n;

    printf("Digite a posicao de fibonacci que deseja acessar (desconsidere os valores iniciais): ");
    scanf("%d", &n);

    printf("%d", fibonacci(n));
}
