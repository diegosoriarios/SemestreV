#include <iostream> 
#include <stdlib.h>
#include <time.h>

using namespace std; 

void troca(int* a, int* b) { 
	int t = *a; 
	*a = *b; 
	*b = t; 
}

void generateArray(int a[], int TAM) {
	for(int i = 0; i < TAM; i++) {
		a[i] = rand() % 100;
	}
}

int particiona(int a[], int p, int r) { 
	int pivo = a[r];
	int i = (p - 1);

	for (int j = p; j <= r - 1; j++) {
		if (a[j] < pivo) { 
			i++;
			troca(&a[i], &a[j]); 
		} 
	} 
	troca(&a[i + 1], &a[r]); 
	return (i + 1); 
} 

void quickSort(int a[], int p, int r) { 
	//SE NÂO PRECISAR TROCAR ESTÁ ORDENADO SENÃO FAZ QUICK SORT
	if (p < r) { 
		int q = particiona(a, p, r); 

		quickSort(a, p, q - 1); 
		quickSort(a, q + 1, r); 
	} 
} 

void mostra(int a[], int TAM) { 
	int i; 
	for (i = 0; i < TAM; i++) 
		cout << a[i] << " "; 
	cout << endl; 
} 

int main() { 
	int tamanho;
	cout << "Qual é o tamanho do array: ";
	cin >> tamanho;
	
	int vetor[tamanho];

	srand (time(NULL));
	
	generateArray(vetor, tamanho);
	int TAM = sizeof(vetor) / sizeof(vetor[0]); 
    	mostra(vetor, TAM); 
	quickSort(vetor, 0, TAM - 1); 
	cout << "Sorted array: \n"; 
	mostra(vetor, TAM); 
	return 0; 
}
