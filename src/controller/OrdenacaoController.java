package Controller;

public class OrdenacaoController {

	public OrdenacaoController() {
		super();
	}
     
	//BUBBLE SORT
	public int[] bubbleSort(int[] vetor) {
		
		int tamanho = vetor.length;
		
		//Rodadas
		for (int i = 0; i < tamanho; i++) {
			
			for (int j = 0; j < tamanho - 1; j++) {
				if(vetor[j] > vetor[j + 1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
				}
			}
	
		}
		
		return vetor;
	}
	
	//MERGE SORT
	
	public int[] mergeSort(int[] vetor, int inicio, int fim) {
		
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetor, inicio, meio); // Esquerda
			mergeSort(vetor, meio + 1, fim); // Direita
			intercala(vetor, inicio, meio, fim);
		}
		
		return vetor;
	}

	private void intercala(int[] vetor, int inicio, int meio, int fim) {
		int novoVetor[] = new int [vetor.length];
		for(int i = inicio; i <= fim; i++) {
			novoVetor[i] = vetor[i];
		}
		
		int esq = inicio;
		int dir = meio + 1;
		
		for(int cont = inicio; cont <= fim; cont++) {
			if(esq > meio) {
				vetor[cont] = novoVetor[dir];
				dir++;
			} else if (dir > fim) {
				vetor[cont] = novoVetor[esq];
				esq++;
			} else if (novoVetor[esq] < novoVetor[dir]) {
				vetor[cont] = novoVetor[esq];
				esq++;
			} else {
				vetor[cont] = novoVetor[dir];
				dir++;
			}
		}
		
	}
	// QUICK SORT
	
	public int[] quickSort(int[] vetor, int inicio, int fim) {
		if(fim > inicio) {
			int pivoFixo = dividir(vetor, inicio, fim); 
			quickSort(vetor, inicio, pivoFixo - 1); //Esquerda
			quickSort(vetor, pivoFixo + 1, fim); //Direita 
		}
		
		return vetor;
	}
	
	private int dividir(int[] vetor, int inicio, int fim) {
		int pivo = vetor[inicio];
		int ponteiroEsquerda = inicio + 1;
		int ponteiroDireita = fim;
		
		
		while(ponteiroEsquerda <= ponteiroDireita) {
			while(ponteiroEsquerda <= ponteiroDireita && vetor[ponteiroEsquerda] <= pivo) {
				ponteiroEsquerda++;
			}
			while(ponteiroDireita >= ponteiroEsquerda && vetor[ponteiroDireita] > pivo) {
				ponteiroDireita--;
			}
			
			if(ponteiroEsquerda < ponteiroDireita) {
				trocar(vetor, ponteiroEsquerda, ponteiroDireita);
				ponteiroEsquerda++;
				ponteiroDireita--;
			}
		}
		
		trocar(vetor, inicio, ponteiroDireita);
		return ponteiroDireita;
		
	}

	private void trocar(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
		
	}
}
