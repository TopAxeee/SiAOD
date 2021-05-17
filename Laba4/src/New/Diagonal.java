package New;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Diagonal {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] new_arr;
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите количесвто строк:");
        int n1 = s.nextInt();
        System.out.println("Введите количесвто столбцов:");
        int m1 = s.nextInt();
        n=n1;
        m=m1;
        arr =new int[n][m];
        new_arr = new int[n][m];

       //заполняем массив строками
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                arr[i][j] = (int)((Math.random() * ((100 + 1))));
                //arr[i][j]=s.nextInt();
            }
        }
        //выводим массив
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                Diag(i,j);
            }
        }

        //отделяем место и выводим отсортированный массив
        System.out.println();
        System.out.println("New");
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                System.out.print(new_arr[i][j]+" ");
            }
            System.out.println();
        }


    }
    public static void Diag (int string, int column) {
        Deque <Integer> deque = new LinkedList<>();
        int count = 0;
        int i=string; int j=column;
        while (i< n&&j< m){
            if(arr[i][j]>0) {
                deque.addLast(arr[i][j]);
                count++;
                arr[i][j] = -1;
                i++;j++;
            }else{break;}
        }if(deque.isEmpty()!=true) {
            int[] diagonalArr = new int[count];
            for (int k = 0; k < count; k++) {
                diagonalArr[k] = deque.pollFirst();
            }
            Arrays.sort(diagonalArr);
            for (int k = 0; k < count; k++) {
                deque.addLast(diagonalArr[k]);
            }
            i = string;
            j = column;
            while (i < n && j < m) {
                new_arr[i][j] = deque.pollFirst();
                i++;
                j++;
            }
        }
    }

}

