package Ex1;

import java.util.Arrays;
import java.util.Scanner;
public class Binary_Search {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        //количесвто элементов в массиве
        System.out.println("Введите количесвто элементов массива:");
        int number = scan.nextInt();
        int [] array = new int [number];
        Random(array);

        //сортируем и выводим массив
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        //вызываем поиск
        System.out.println("Введите искомый элемент:");
        int search = scan.nextInt();
        long before = System.nanoTime();//засекаем время начала
        int [] arr=BinarySearch(array,0,array.length-1,search);//int [] arr = {first,last,comparisonCount,position};
        long after = System.nanoTime();//засекаем время завершения работы
        if (arr[0] <= arr[1]) {
            System.out.println(search + " является " + ++arr[3] + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + arr[2] +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + arr[2] + " сравнений");
        }
        System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");

        System.out.println("Для добавления элемента в массив введите новое число:");
        int n_e_w = scan.nextInt();
        array=Add(array,n_e_w);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Для удаления элемента из массива введите искомый элемент:");
        n_e_w = scan.nextInt();
        arr=BinarySearch(array,0,array.length-1,n_e_w);//int [] arr = {first,last,comparisonCount,position};
        array=Sub(array,arr[3]);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    // бинарный поиск
    public static int [] BinarySearch(int[] array, int first, int last, int item) {
        int position;
        int comparisonCount = 1;    // для подсчета количества сравнений

        // для начала найдем индекс среднего элемента массива
        position = (first + last) / 2;
        while ((array[position] != item) && (first <= last)) {
            comparisonCount++;
            if (array[position] > item) {  // если число заданного для поиска
                last = position - 1; // уменьшаем позицию на 1.
            } else {
                first = position + 1;    // иначе увеличиваем на 1
            }
            position = (first + last) / 2;
        }
        int [] arr = {first,last,comparisonCount,position};
        return arr;
    }
    public static int[] Add(int[] array, int n){
        //получает массив и новое число
        int[] newArray = new int[array.length+1];
        for (int i=0;i<array.length;i++){
            newArray[i]=array[i];
        }
        newArray[array.length] = n;
        return newArray;
        //вывод массив с числом на конце!
    }
    public static int[] Sub(int []array, int n){
        //получает массив и номер числа,которое нужно удалить
        int[] result = new int[array.length - 1]; // Array which will contain the result.
        System.arraycopy(array, 0, result, 0, n);
        System.arraycopy(array, n+1 , result, n, array.length - n - 1);
        return result;
        //выводит массив без одного числа
    }
    public static int[] Random (int []array){
        //получает массив
        for (int i=0;i< array.length;i++){
            array[i]=(int)(Math.random()*100);
        }
        return array;
        //выводит массив случайных чисел
    }
}

