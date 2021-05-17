package Ex1;

import java.util.Arrays;
import java.util.Scanner;

public class Inter_Search {
    public static int interpolationSearch(int[] sortedArray, int toFind) {
        // Возвращает индекс элемента со значением toFind или -1, если такого элемента не существует
        int mid;
        int low = 0;
        int high = sortedArray.length - 1;

        while (sortedArray[low] < toFind && sortedArray[high] > toFind) {
            if (sortedArray[high] == sortedArray[low]) // Защита от деления на 0
            {
                break;
            }
            mid = low + ((toFind - sortedArray[low]) * (high - low)) / (sortedArray[high] - sortedArray[low]);

            if (sortedArray[mid] < toFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > toFind) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        if (sortedArray[low] == toFind) {
            return low;
        }
        if (sortedArray[high] == toFind) {
            return high;
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
        System.out.println(search + " является " + (interpolationSearch(array,search)+1) + " элементом в массиве");
        long after = System.nanoTime();//засекаем время завершения работы
        System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");

        System.out.println("Для добавления элемента в массив введите новое число:");
        int n_e_w = scan.nextInt();
        array=Add(array,n_e_w);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Для удаления элемента из массива введите искомый элемент:");
        n_e_w = scan.nextInt();
        array=Sub(array,interpolationSearch(array,n_e_w));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static int[] Random (int []array){
        //получает массив
        for (int i=0;i< array.length;i++){
            array[i]=(int)(Math.random()*100);
        }
        return array;
        //выводит массив случайных чисел
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
}
