package Ex_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class K_M_P_Search {
    public static void main (String[] arg){

        Scanner s = new Scanner(System.in);
        System.out.println("String:");
        String string = s.nextLine();
        System.out.println("Substring:");
        String substring = s.nextLine();
        System.out.println("Register: (0-No, 1 - Yes)");
        int res = s.nextInt();

        if (res==1){
            string.toLowerCase();
            substring.toLowerCase();
        }

        long start = System.nanoTime();
        KMPSearch(string,substring);
        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println(Arrays.toString(KMPSearch(string,substring).toArray()));
        System.out.println("ремя работы: " + (double)elapsed/1000000+"мс");
    }
    static int[] prefixFunction(String sample) {//функция для поиска повторений подсроки в самой себе
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {//что-то вроде простого поиска???
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;//возвращает массив повторений строки в самой себе
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {//основной метод поиска
        ArrayList<Integer> found = new ArrayList<>();//массив с вхождениями

        int[] prefixFunc = prefixFunction(sample);//массив с повторениями подстроки в самой ссебе

        int i = 0;
        int j = 0;
        //aabaab
      //  aaabaaaaaaaabaab

        while (i < text.length()) {//идем по тексту
            if (sample.charAt(j) == text.charAt(i)) {//если совпадение найдено двигаемся вперед
                j++;
                i++;
            }
            if (j == sample.length()) {//если подстрока закончилась, то добавляем индекс вхождения в массив
                found.add(i - j);
                j = prefixFunc[j - 1];//индекс внутри подстроки мы берем из префиксной функции
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {//если совпадение не найдено и текст не кончился
                if (j != 0) {//если не первый символ подстроки. то
                    j = prefixFunc[j - 1];//получаем новый индекс из префиксной функции
                } else {
                    i = i + 1;//иначе берем новый символ текста
                }
            }
        }

        return found;
    }
}
