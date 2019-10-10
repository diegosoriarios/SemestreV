#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <fstream>

using namespace std;

void generateArrayRand(int a[], int TAM, string tipo) {
	tipo = "Aleatório";
	for(int i = 0; i < TAM; i++) {
		a[i] = rand() % 100;
	}
}

void generateArrayCresc(int a[], int TAM, string tipo) {
	tipo = "Crescente";
	for(int i = 0; i < TAM; i++) {
		a[i] = i;
	}
}

void generateArrayDecresc(int a[], int TAM, string tipo) {
	tipo = "Decrescente";
	for(int i = 0; i < TAM; i++) {
		a[i] = TAM - i;
	}
}

/**
 * Bubble Sort
 */
void swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

void bubbleSort(int *v, int n){
    if (n < 1)return;

    for (int i=0; i<n; i++)
        if (v[i] > v[i+1])
            swap(&v[i], &v[i+1]);
    bubbleSort(v, n-1);
}

/**
 * Check if is ordered
 */

bool isOrdered(int vetor[], int n) {
	int k, j, aux;

    for (k = 1; k < n; k++) {

        for (j = 0; j < n - 1; j++) {

            if (vetor[j] > vetor[j + 1]) {
                return false;
            }
        }
    }
	return true;
}

/**
 * Quick Sort
 */

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
	//TIME
	clock_t t;
	double time_taken;
	int TAM;
	ofstream myfile;

	string tipo = "";


	int tamanho;
	cout << "Qual é o tamanho do array: ";
	cin >> tamanho;

	int vetor[tamanho];

	srand (time(NULL));

	int opt;

	do {

		cout << "1 - Gera Array aleatório\n" <<
				"2 - Gera Array Decrescente\n" <<
				"3 - Gera Array Crescente\n" <<
				"4 - Ordenação c/ checkout \n" <<
				"5 - Ordenação s/ checkout\n" <<
				"6 - Pega dados do arquivo texto\n" <<
				"7 - Mostrar\n" <<
				"0 - Sair\n" <<
				"Digite a opção desejada: ";
		cin >> opt;

		switch (opt) {
			case 0:
				return 0;
			case 1:
				/**
				* RANDOM ARRAY
				*/
				generateArrayRand(vetor, tamanho, tipo);
				TAM = sizeof(vetor) / sizeof(vetor[0]);
				//mostra(vetor, TAM);
				break;
			case 2:
				generateArrayDecresc(vetor, tamanho, tipo);
				TAM = sizeof(vetor) / sizeof(vetor[0]);
				//mostra(vetor, TAM);
				break;
			case 3:
				generateArrayCresc(vetor, tamanho, tipo);
				TAM = sizeof(vetor) / sizeof(vetor[0]);
				//mostra(vetor, TAM);
				break;
			case 4:
				t = clock();

				quickSort(vetor, 0, TAM - 1);

				t = clock() - t;

				time_taken = ((double)t)/CLOCKS_PER_SEC;
				printf("took %f seconds to execute \n", time_taken);

				myfile.open ("time.txt", ios::app);
				myfile << tipo << "\n";
				myfile << "Tamanho do vetor: " << TAM << "\n";
				myfile << "Tempo: " << time_taken << "\n";
				myfile << "---------------------------------------------------------\n";
				myfile.close();

				//mostra(vetor, TAM);

				cout << "---------------------------------------------------------\n";
				break;
			case 5:
				t = clock();

				if(!isOrdened(vetor, TAM - 1)) { //Se bubble sorte não for usado quer dizer que não está em ordem
					quickSort(vetor, 0, TAM - 1);
				}

				t = clock() - t;

				time_taken = ((double)t)/CLOCKS_PER_SEC;
				printf("took %f seconds to execute \n", time_taken);

				myfile.open ("time.txt", ios::app);
				myfile << tipo << "\n";
				myfile << "Tamanho do vetor: " << TAM << "\n";
				myfile << "Tempo: " << time_taken << "\n";
				myfile << "---------------------------------------------------------\n";
				myfile.close();

				//mostra(vetor, TAM);

				cout << "---------------------------------------------------------\n";
				break;
			case 6:
				cout << "Não implementado";
				break;
            case 7:
                mostra(vetor, TAM - 1);
                break;
			default:
				cout << "Escolha uma opção correta";

		}
	}while(true);

}
