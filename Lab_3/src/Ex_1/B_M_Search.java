package Ex_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B_M_Search {
    public static void main (String[] arg){
        //запрашиваем входные данные
        Scanner s = new Scanner(System.in);
        System.out.println("String:");
        String string = s.nextLine();
        System.out.println("Substring:");
        String substring = s.nextLine();
        System.out.println("Register: (0-No, 1 - Yes)");
        int res = s.nextInt();

        if (res==1){//если нечувствителен к регистру, то на всякий случай все делаем нижним регистром
            string.toLowerCase();
            substring.toLowerCase();
        }

        long start = System.nanoTime();//засекаем время
        getFirstEntry(string, substring);
        long finish = System.nanoTime();
        long elapsed = finish - start;

        System.out.println(Arrays.toString(getFirstEntry(string,substring).toArray()));
        System.out.println("ремя работы: " + (double)elapsed/1000000+"мс");
    }
    public static HashMap<Character, Integer> makeOffsetTable(String pattern) {
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, pattern.length());//для всех символов записываем длину строки
        }
        for (int i = 0; i < pattern.length() - 1; i++) {//для символов в подстроке
            offsetTable.put(pattern.charAt(i), pattern.length() - i - 1);//выставляем минимальное расстояние до конца слова
        }
        return offsetTable;
    }

    public static ArrayList<Integer>  getFirstEntry(String s, String p) {
        ArrayList<Integer> found = new ArrayList<>();//массив с вхождениями
        HashMap<Character, Integer> offsetTable = makeOffsetTable(p);//получаем "шаг" для каждогй цифры
        int i = p.length() - 1;
        int j = i;
        int k = i;

        while (j >= 0 && i <= s.length() - 1) {//бежим по строке, подстрока не кончилась
            j = p.length() - 1;
            k = i;
            while (j >= 0 && s.charAt(k) == p.charAt(j)) {//пока символы сошлись и подстрока не кончилась
                k--;
                j--;
            }
            i += offsetTable.get(s.charAt(i));//если совпадение не было найдено, то делаем шаг на число найденное в первом методе
        }
        if (k > s.length() - p.length()) {//если позиция вхождения неправильная (строка 10, подстрока 3, последнее вхождение может быть в 7 символе)
            found.add(0);
        } else {
            found.add((k+1));//если все хорошо, то возвращаем позицию вхождения
            j=p.length()-1;
            k=j;
        }
        return found;
    }
}
