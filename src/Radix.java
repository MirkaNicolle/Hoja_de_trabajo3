import java.util.Vector;

public class Radix {

    private static int digit(Comparable n, int d){
        if (d == 0) return Integer.parseInt(n.toString()) % 10;
        else return digit(Integer.parseInt(n.toString()) / 10, d - 1);
    }

    public static void bpass(Comparable data[], int d){
        int i, j;
        Comparable value;
        //asignacion
        Vector<Vector<Comparable>> b = new Vector<Vector<Comparable>>(10);
        b.setSize(10);
        //asignacion de vectores
        for (j = 0; j < 10; j++) b.set(j, new Vector<Comparable>());
        //distribucion de datos
        int n = data.length;
        for (i = 0; i < n; i++){
            Comparable x = data[i];
            value = x;
            //determina el valor
            j = digit(value.toString().trim(), d);
            b.get(j).add(value);
        }
        //datos de b para el array
        i = n;
        for (j = 9; j >= 0; j--) {
            while (!b.get(j).isEmpty()){
                i--;
                value = b.get(j).remove(j);
                data[i] = value;
            }
        }
    }

    private static void radixsort(Comparable data[]){
        for (int i = 0; i < 6; i++){
            bpass(data, i);
        }
    }
}
