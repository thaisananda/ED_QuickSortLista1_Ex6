package ListaQuickSort;

import Controller.OrdenacaoController;

public class ex6 {
	
	public static void main(String[] args) {
		int tamanho = 1500;
		
		int[] vetorBubble = new int[tamanho];
        int[] vetorMerge = new int[tamanho];
        int[] vetorQuick = new int[tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            int valor = tamanho - 1 - i; // 1499, 1498, ...
            vetorBubble[i] = valor;
            vetorMerge[i] = valor;
            vetorQuick[i] = valor;
        }
        
        OrdenacaoController sort = new OrdenacaoController();
		
        // BUBBLE SORT
        long inicioBubble = System.nanoTime();
        sort.bubbleSort(vetorBubble);
        long fimBubble = System.nanoTime();
        double tempoBubble = (fimBubble - inicioBubble) / 1_000_000_000.0;
        System.out.println("Tempo BubbleSort: " + tempoBubble + " s");
        
        // MERGE SORT
        long inicioMerge = System.nanoTime();
        sort.mergeSort(vetorMerge, 0, vetorMerge.length - 1);
        long fimMerge = System.nanoTime();
        double tempoMerge = (fimMerge - inicioMerge)/ 1_000_000_000.0;
        System.out.println("Tempo MergeSort:  " + tempoMerge + " s");
        
        // QUICK SORT
        long inicioQuick = System.nanoTime();
        sort.quickSort(vetorQuick, 0, vetorQuick.length - 1);
        long fimQuick = System.nanoTime();
        double tempoQuick = (fimQuick - inicioQuick) / 1_000_000_000.0;
        System.out.println("Tempo QuickSort:  " + tempoQuick + " s");
    }
}

