public class QuickSort {
    private static int partition(Comparable data[], int left, int right){
        while (true){
            while (left < right && data[left].compareTo(data[right]) == -1 ) right --;
            if (left < right) swap(data, left++, right);
            else return left;

            while (left < right && data[left].compareTo(data[right]) == -1) left ++;
            if (left < right) swap(data, left, right--);
            else return right;
        }
    }

    public static void swap(Comparable data[], int i, int j){
        Comparable temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void quickSort(Comparable data[], int n){
        quickSortRecursive(data, 0, n - 1);
    }

    public static void quickSortRecursive(Comparable data[], int left, int right){
        //posicion final del valor a la izquierda
        int pivot;
        if (left >= right) return;
        pivot = partition(data, left, right); //lugar del pivot
        quickSortRecursive(data, left, pivot - 1); //sort del pequeño
        quickSortRecursive(data, pivot + 1, right); //sort del largo
    }
}
