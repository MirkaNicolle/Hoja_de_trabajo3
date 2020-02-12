import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        WriteFile("../numeros.txt");

        boolean seguir = true;

        Numeros[] n = ReadFile("../numeros.txt"); //read
        Gnome.gnomeSort(n);

        while (seguir){
            System.out.println(MainMenu()); //mainmenu
            System.out.println("Ingrese la opcion deseada: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            switch (option){
                case 1:
                    Gnome.gnomeSort(n);
                    break;
                case 2:
                    Merge.mergeSort(n, n.length);
                    break;
                case 3:
                    QuickSort.quickSort(n, n.length);
                    break;
                case 4:
                    Radix.bpass(n, n.length);
                    break;
                case 5:
                    Bubble.bubbleSort(n);
                    break;
                case 6:
                    seguir = false;
                default:
                    System.out.println("La opcion no es valida");
            }

        }

    }

    public static Numeros[] ReadFile(String fileName){
        ArrayList dataArray = new ArrayList();
        Numeros[] n;
        int i = 0;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();

            while (line != null){
                dataArray.add(i, Integer.parseInt((line)));
                line = bufferedReader.readLine();
                i++;
            }
        } catch (Exception var){
            System.out.println(var);
        }

        n = new Numeros[i];

        for (int j = 0; j < i; ++j){
            n[j] = new Numeros((Integer)dataArray.get(j));
        }
        return n;
    }

    public static void WriteFile(String fileName){
        try {
            File f = new File(fileName);
            FileOutputStream g = new FileOutputStream(f);
            BufferedWriter h = new BufferedWriter(new OutputStreamWriter(g));

            Random generator = new Random();

            for (int i = 0; i <= 10; i++){
                int num = generator.nextInt(10);
                h.write("" + num);
                h.newLine();
            }

            h.close();
        }

        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String MainMenu(){
        return "\n\n\tMenu\n\n" +
                "1. Gnome Sort\n" +
                "2. Merge Sort\n" +
                "3. Quick Sort\n" +
                "4. Radix Sort\n" +
                "5. Bubble Sort\n" +
                "6. Salir";
    }
}
