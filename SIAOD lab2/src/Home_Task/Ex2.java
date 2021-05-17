package Home_Task;

import java.util.Scanner;

public class Ex2 {
    public static void main (String[] args){
        int N;//число вершин
        Scanner in = new Scanner(System.in);
        System.out.print("Введите N: ");
        N = in.nextInt();
        for (int i=3;i<N+1;i++){//ищем наименьший делитель числа
            if (N%i==0) {
                System.out.print("наименьшее количество вершин: "+i);
                break;
            }
        }

    }
}
