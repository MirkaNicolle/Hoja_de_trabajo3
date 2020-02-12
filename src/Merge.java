/* Fuente codigo: Lars Vogel (c) 2009, 2016 vogella GmbH Version 0.7, 04.10.2016*/

public class Merge {
    private static void merge(Comparable data[], Comparable temp[], int low, int middle, int high){
        int a = low;
        int b = low;
        int c = middle;

        while (b < middle && c <= high){
            if (data[c].compareTo(b) == -1){
                data[a++] = data[c++];
            } else {
                data[a++] = temp[b++];
            }
        }
        //datos fuera del array
        while (b < middle){
            data[a++] = temp[b++];
        }
    }

    public static void mergeSort(Comparable data[], int n){
        mergeSortRecursive(data, new Comparable[n],0,n - 1);
    }

    private static void mergeSortRecursive(Comparable data[], Comparable temp[], int low, int high){
        int n = high - low + 1;
        int middle = low + n / 2;
        int i;
        if (n < 2) return;
        for (i = low; i < middle; i++){
            temp[i] = data[i];
        }

        //sort de la mitad inferior del array
        mergeSortRecursive(data, temp, low, middle - 1);
        // sort de la mitad superior del array
        mergeSortRecursive(data, temp, low, high);
        //merge junta las dos mitades
        merge(data, temp, low, middle, high);
    }
}
