package Ex_1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Default_Search {
    public static void main (String[] arg){

        Scanner s = new Scanner(System.in);//запрос переменных
        System.out.println("String:");
        String string = s.nextLine();
        System.out.println("Substring:");
        String substring = s.nextLine();
        System.out.println("Register: (0-No, 1 - Yes)");
        int res = s.nextInt();

        if (res==0){//НЕ чувствительность к регистру
            string.toLowerCase();
            substring.toLowerCase();
        }

        ArrayList<Integer> found = new ArrayList<>();//массив с вхождениями

        int i=0;//шаг

        long start = System.nanoTime();
        while (i<string.length()){//бежим по строке
            found.add(string.indexOf(substring,i));//встроенная функция indexOf()
            if(i==string.indexOf(substring,i)){//если мы не сдвинулись с места. то двигаемся принудительно
                i++;
            }
        }
        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println(Arrays.toString(found.toArray()));
        System.out.println("ремя работы: " + (double)elapsed/1000000+"мс");
    }
}
