public class Gnome {
    public static void gnomeSort(Comparable[] dataArray){
        for (int i = 1; i < dataArray.length;){
            if (dataArray[i-1].compareTo(dataArray[i]) <= 0){
                ++i;
            }
            else {
                Comparable temp = dataArray[i];
                dataArray[i] = dataArray[i -1];
                dataArray[i -1] = temp;
                --i;

                if (i == 0){
                    i = 1;
                }
            }
        }
    }
}
