package src.controller;

public class Ordenamientos{
    
    public int partir(Integer [] lista, int low, int high){

        int pivote = lista[low];
        while (low < high){
            while (low < high && lista[high] >= pivote){
                --high;
            }
            swap(lista, low, high);

            while(low < high && lista[low] <= pivote){
                low++;
            }
            swap(lista,low,high);
        }
        return low;

    }

    public void qSort(Integer [] lista, int low, int high){
        int pivote;
        if(low < high){
            pivote = partir(lista, low, high);
            qSort(lista, low, pivote - 1);
            qSort(lista, pivote + 1, high);
        }
    }

    public void quickSort(Integer []lista){
        qSort(lista,0, lista.length-1);
    }

    private void swap(Integer [] lista, int i, int j){
        int temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }

    public void shellSort(Integer [] lista, int size){
        int j, temp;
        int incrementar = size / 2;
        while (incrementar > 0) {
            for (int i = incrementar; i < size; i++){
                j = i;
                temp = lista[i];
                while ((j >= incrementar) && (lista[j - incrementar] > temp)) {
                    lista[j] = lista[j - incrementar];
                    j = j - incrementar;
                }
                lista[j] = temp;
            }
            incrementar /= 2;
        }
    }

    public static Integer[] mergeSort(Integer[] lista){

		if (lista.length <= 1) {
            return lista;
        }   

        
        int medio = lista.length / 2;
        Integer[] izq = new Integer[medio];
        Integer[] derecha = new Integer[lista.length - medio];

       
        for (int i = 0; i < medio; i++) {
            izq[i] = lista[i];
        }
        for (int i = medio; i < lista.length; i++) {
            derecha[i - medio] = lista[i];
        }

       
        izq = mergeSort(izq);
        derecha = mergeSort(derecha);

       
        return merge(izq, derecha);

	}

	public static Integer[] merge(Integer[] izq, Integer[] derecha){

		Integer[] result = new Integer[izq.length + derecha.length];
        int a = 0, b = 0, c = 0;

        
        while (a < izq.length && b < derecha.length) {
            if (izq[a] <= derecha[b]) {
                result[c++] = izq[a++];
            } else {
                result[c++] = derecha[b++];
            }
        }

      
        while (a < izq.length) {
            result[c++] = izq[a++];
        }

        
        while (b < derecha.length) {
            result[c++] = derecha[b++];
        }

        return result;
	}

    static void seleccion(Integer[] lista, int tamayo){
		for (int i = 0; i < lista.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[minIndex]) {
                    minIndex = j;
                }
            }
            
            Integer temp = lista[minIndex];
            lista[minIndex] = lista[i];
            lista[i] = temp;
        }

	}
    
}