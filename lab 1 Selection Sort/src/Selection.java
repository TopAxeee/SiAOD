import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Selection {
    public static void selectionSort(int columns, int[] arr){

        for (int i = 0; i < columns; i++) {
        // предполагаем что текущий элемент минимальный
            int min = arr[i];
            int min_i = i;
        // в оставшейся части подмножества ищем элемент, который меньше предположенного минимума
            for (int j = i+1; j < columns; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        //Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }

    }

        public static void main (String[] arg){
            int string,columns;
            Scanner in = new Scanner(System.in);
            //вводим парметры массива
            System.out.print("Input strings: ");
            string = in.nextInt();
            System.out.print("Input columns: ");
            columns = in.nextInt();
            //создаем массив
            int [][]mas=new int[string][columns];
            //заполняем его рандомными числами
            Random r = new Random(); // рандом от 0 до 100
            for (int i=0;i<string;i++){
                for (int j=0;j<columns;j++){
                    mas[i][j]=r.nextInt(100) + 1;
                }
            }

            //сортруем массссив по строкам при помощи выборочной сортировки
            System.out.println("Selection sort:");
            long before = System.nanoTime();//засекаем время начала
            for (int i = 0; i<string;i++){
                int[] arr = new int [columns];
                for (int j=0;j<columns;j++){
                    arr[j]=mas[i][j];//записываем в новый массив текущую строку исходного
                }
                selectionSort(columns, arr);//сортируем
                //System.out.println(Arrays.toString(arr));
            }
            long after = System.nanoTime();//засекаем время завершения работы
            System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");


            //сортировка по-умолчанию
            System.out.println("Quick sort:");
            before = System.nanoTime();
            for (int i = 0; i<string;i++){
                int[] arr = new int [columns];//создаем новый массив для строки
                for (int j=0;j<columns;j++){
                    arr[j]=mas[i][j];//заполняем его
                }
                Arrays.sort(arr);//сортировка по умолчанию
            }
            after = System.nanoTime();
            System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");
        }
}
