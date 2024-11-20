package controller;

import ListaP;
import Nodo;

public class Ordenamientos{
    
    public Nodo partir(Nodo low, Nodo high) {
        int pivote = low.dato;  // Usamos el primer nodo como pivote
        Nodo left = low;
        Nodo right = high;

        while (left != right) {
            // Mover right hasta encontrar un valor menor que el pivote
            while (left != right && right.dato >= pivote) {
                right = right.siguiente;
            }

            // Si left != right, intercambiamos los valores de los nodos
            if (left != right) {
                left.swap(right);
            }

            // Mover left hasta encontrar un valor mayor que el pivote
            while (left != right && left.dato <= pivote) {
                left = left.siguiente;
            }

            // Si left != right, intercambiamos los valores de los nodos
            if (left != right) {
                left.swap(right);
            }
        }

        return left;  // Retorna el nodo pivote
    }

    // Método recursivo de quicksort para ordenar la lista
    public void qSort(Nodo low, Nodo high) {
        if (low != null && high != null && low != high && low != high.siguiente) {
            Nodo pivote = partir(low, high);

            // Recursión para la sublista izquierda
            Nodo leftSublist = low;
            Nodo rightSublist = pivote.siguiente;
            qSort(leftSublist, pivote);  // Ordena la parte antes del pivote
            qSort(rightSublist, high);  // Ordena la parte después del pivote
        }
    }

    // Método para encontrar el último nodo
    public void quickSort(Nodo head) {
        // Necesitamos encontrar el último nodo (high)
        Nodo high = head;
        while (high != null && high.siguiente != null) {
            high = high.siguiente;
        }
        qSort(head, high);  // Llamada al método qSort
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

    static void seleccion(ListaP lista, int tamayo){
		for (int i = 0; i < lista.obtenerTamayo() - 1; i++) {
            Nodo nI = lista.get(i);
            Nodo minIndex = lista.get(i);
            for (int j = i + 1; j < lista.obtenerTamayo(); j++) {
                Nodo nJ = lista.get(j);
                if (nJ.dato < minIndex.dato) {
                    minIndex =  nJ;
                }
            }
            
            int temp = nI.dato;
            nI.dato = minIndex.dato;
            minIndex.dato = temp;
        }
	}

	public void burbujaMejorada(ListaP lista) {
	    boolean huboIntercambios;
	    for (int i = 0; i < lista.obtenerTamayo() - 1; i++) {
	        huboIntercambios = false;
	        for (int j = 0; j < lista.obtenerTamayo() - 1 - i; j++) {
	            Nodo nodo1 = lista.get(j);
	            Nodo nodo2 = lista.get(j + 1);
	            if (nodo1.dato > nodo2.dato) {
	                
	                int temp = nodo1.dato;
	                nodo1.dato = nodo2.dato;
	                nodo2.dato = temp;
	                huboIntercambios = true;
	            }
	        }
	        if (!huboIntercambios) break;
	}

	
	  public void insercion(ListaP lista) {
	    for (int i = 1; i < lista.obtenerTamayo(); i++) {
	        Nodo clave = lista.get(i);  
	        int j = i - 1;
	
	        while (j >= 0 && lista.get(j).dato > clave.dato) {
	            Nodo nodoActual = lista.get(j);
	            Nodo siguienteNodo = lista.get(j + 1);
	            nodoActual.dato = siguienteNodo.dato;  
	            j--;
	        }
	        
	        lista.get(j + 1).dato = clave.dato;
	    }
	}

    
        
            public static void main(String[] args) {
                // Crear la lista enlazada: 5 -> 3 -> 8 -> 1 -> null
                ListaP lista = new ListaP();

                lista.push(73,0);
                lista.push(12,1);
                lista.push(2,2);
                lista.push(13,3);
        
                // Crear el objeto QuicksortLista y ordenar
                Ordenamientos ordenamientos = new Ordenamientos();
                seleccion(lista, lista.obtenerTamayo());
        
                System.out.println("\nAfter sorting:");
                for (int i = 0; i < lista.obtenerTamayo(); i++) {
                System.out.println("Node " + i + ": " + lista.get(i).dato);
                }
            }
    
}
