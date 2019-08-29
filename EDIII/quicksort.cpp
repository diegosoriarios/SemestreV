#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

void quick(int a[], int p, int r);
int particionamento(int a[], int p, int r);
void troca(int a, int b);
void mostrar(int a[], int tam);

int main() {
    int TAM = 7;
    int vetor[TAM];

    srand (time(NULL));
    for(int i = 0; i < TAM; i++) {
        vetor[i] = rand() % 10 + 1;
    }

    mostrar(vetor, TAM);

    quick(vetor, 0, TAM);

    mostrar(vetor, TAM);
}

void mostrar(int a[], int tam) {
    for(int i = 0; i < tam; i++) {
        cout << a[i] << "\t";
    }
    cout << "\n";
}

void quick(int a[], int p, int r) {
    if(p < r) {
        int q = particionamento(a, p, r);
        quick(a, p, q-1);
        quick(a, q+1, r);
    }
}

int particionamento(int a[], int p, int r) {
    int pivo = a[r];
    int i = p;
    int j = r - 1;
    while( i < j ) {
        while(a[i] <= pivo) {
            i++;
        }

        while(a[j] > pivo) {
            j--;
        }

        troca(a[i], a[j]);
        troca(a[r], a[j]);
        return j;
    }
    return j;
}

void troca(int a, int b) {
    int aux = b;
    b = a;
    a = aux;
}