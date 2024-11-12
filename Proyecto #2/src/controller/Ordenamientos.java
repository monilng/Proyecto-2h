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