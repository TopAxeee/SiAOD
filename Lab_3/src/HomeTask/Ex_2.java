package HomeTask;

import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] arg) {
        //запрашиваем входные данные
        Scanner s = new Scanner(System.in);
        System.out.println("String:");
        String string1 = s.nextLine();
        String sub_max = "";//самая длинная подстрока-полиндром
        for (int k=0;k<string1.length();k++) {//определяем с какой позиции начинать
            String sub = "";//текущая подстрока
            for (int i = k; i < string1.length(); i++) {//добавляем следующие буквы в наше слово
                sub += string1.charAt(i);
                if ((sub.equals(Palindrom(sub))) == true) {//если слово палиндром, то запоминаемего
                    if (sub.length() > sub_max.length())//если слово длиннее текущего палиндрома
                        sub_max = sub;
                }
            }
        }
        System.out.println(sub_max);

        //основная работа

    }
    public static String Palindrom (String s){//проверка на палиндром
        String sub = "";
        for(int i=(s.length()-1);i>=0;i--){
            sub+=s.charAt(i);
        }
        return sub;
    }

}
