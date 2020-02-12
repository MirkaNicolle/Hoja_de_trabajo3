public class Bubble {
    public static void bubbleSort(Comparable[] dataArray){
        int n = dataArray.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (dataArray[j].compareTo(dataArray[j + 1]) == 1){
                    Comparable temp = dataArray[j];
                    dataArray[j] = dataArray[j + 1];
                    dataArray[j + 1] = temp;
                }
            }
        }
    }
}
