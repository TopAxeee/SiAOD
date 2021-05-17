package Ex1;

import java.util.Arrays;
import java.util.Scanner;

public class Fib_Search {
    static Scanner scan = new Scanner(System.in);
    /* Возвращает индекс x, если присутствует, иначе возвращает -1 */
    public static int fibSearch(int arr[], int x, int n, int counter) {
        /* Инициализировать числа Фибоначчи */
        int fib_n1=0;
        int fib_n2=1;
        int sout = 0;
        int fib_i=fib_n1+fib_n2;
        while (fib_i<n){
            if(arr[fib_i-1]==x){
                sout = fib_i+counter;
                fib_i=n;
            }else if(arr[fib_i-1]<x){
                fib_n1=fib_n2;
                fib_n2=fib_i;
                fib_i=fib_n1+fib_n2;
            }else if(arr[fib_i-1]>x){
            counter=fib_n2;
            int []new_arr = new int [fib_n1];
            System.arraycopy(arr,fib_n2,new_arr,0,fib_n1);
            sout= fibSearch(new_arr,x, new_arr.length, counter);
                fib_i=n;
            }else {sout=-1;}
        }
        return sout;
    }
    // код драйвера
    public static void main(String[] args) {
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
        System.out.println(search + " является " + (fibSearch(array,search,number,0)) + " элементом в массиве");
        long after = System.nanoTime();//засекаем время завершения работы
        System.out.println("Время исполнения = " + (double)(after - before)/1000000 + " мс");

        System.out.println("Для добавления элемента в массив введите новое число:");
        int n_e_w = scan.nextInt();
        array=Add(array,n_e_w);
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        System.out.println("Для удаления элемента из массива введите искомый элемент:");
        n_e_w = scan.nextInt();
        array=Sub(array,fibSearch(array,n_e_w,number,0));
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
