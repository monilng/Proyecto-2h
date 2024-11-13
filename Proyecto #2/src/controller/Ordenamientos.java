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

    public static Object[] mergeSort(Object[] lista){

		if (lista.length <= 1){
			return lista;

		}
		int medio = lista.length/2;
		Object[] izq = new Object[medio];
		Object[] derecha = new Object[lista.length - medio];
		

		for(int i = 0; i < medio; i++){
			izq[i] = lista[i];
		}
		for(int i = medio; i < lista.length; i++){
			derecha[i - medio] = lista[i];
		}

		izq = mergeSort(izq);
		derecha = mergeSort(derecha);
		
		return merge(izq, derecha);

	}

	public static Object[] merge(Object[] izq, Object[] derecha){

		Object[] result = new Object[izq.length + derecha.length];
		int a = 0, b = 0, c =0;

		while ( a < izq.length && b < derecha.length){
			if (((Comparable) izq[a]).compareTo(derecha[b])<= 0){
				result[c++] = izq[a++]; 
			} else{
				result[c++] = derecha[b++];
			}
		}
		while (a < izq.length){
			result[c++] = izq[a++];
		}

		while (b < derecha.length){
			result[c++] = derecha[b++];
		}
		return result;

	}

    static void seleccion(Object[] lista, int tamayo){
		for(int a = 0, b = 0, c = 0; a < tamayo-1; a++){
			c = a;
			for(b = a+1; b < tamayo; b++){
				if(((Comparable) lista[c]).compareTo(lista[b]) > 0){
					c = b;
				}
			}
			Object tem = lista[a];
			lista[a] = lista[c];
			lista[c] = tem;
		}

	}

		

    /*    public static void main(String[] args) {
            int[] lista = {3, 1, 4, 1, 5, 9, 2, 6, 5};

            Ordenamientos ordenamientos = new Ordenamientos();
    
            // Mostrar el arreglo antes de ordenar
            System.out.println("Lista antes de ordenar:");
            for (int i : lista) {
                System.out.print(i + " ");
            }
    
            // Ordenar la lista usando QuickSort
            ordenamientos.quickSort(lista);
    
            // Mostrar el arreglo después de ordenar
            System.out.println("\nLista después de ordenar:");
            for (int i : lista) {
                System.out.print(i + " ");
            }

            ordenamientos.shellSort(lista, lista.length);
            System.out.println("\nLista después de ordenar (ShellSort):");
            for (int i : lista) {
                 System.out.print(i + " ");
            }

        } */
    
}