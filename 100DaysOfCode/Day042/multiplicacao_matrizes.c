#include <stdio.h>
#include <stdlib.h>

int main() {
    int m, n;

    printf("Informe os valores {m, n} para as matrizes note que: matriz_a[m][n] e matriz_b[n][m]");
    scanf("%d", &m);
    scanf("%d", &n);

    int matriz_a[m][n];
    int matriz_b[n][m];
    int matriz_r[m][m];

    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            matriz_r[i][j] = 0;
        }
    }

    printf("Matriz A: \n");
    for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
            printf("Insira um valor na posicao [%d][%d]: ", i, j);
            scanf("%d", &matriz_a[i][j]);
        }
    }
    
    printf("Matriz B: \n");
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            printf("Insira um valor na posicao [%d][%d]: ", i, j);
            scanf("%d", &matriz_b[i][j]);
        }
    }

    for (int i=0; i<m; i++) {
        for (int j=0; j<m; j++) {
            for (int k=0; k<n; k++) {
                matriz_r[i][j] += (matriz_a[i][k] * matriz_b[k][j]);
            }
        }
    }

    for (int i=0; i<m; i++) {
        for (int j=0; j<m; j++) {
            printf("%d ", matriz_r[i][j]);
        }
        printf("\n");
    }
}
