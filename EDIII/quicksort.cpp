#include <iostream> 
using namespace std; 

void troca(int* a, int* b) { 
	int t = *a; 
	*a = *b; 
	*b = t; 
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
	int vetor[] = {10, 7, 8, 9, 1, 5}; 
	int TAM = sizeof(vetor) / sizeof(vetor[0]); 
    	mostra(vetor, TAM); 
	quickSort(vetor, 0, TAM - 1); 
	cout << "Sorted array: \n"; 
	mostra(vetor, TAM); 
	return 0; 
}
