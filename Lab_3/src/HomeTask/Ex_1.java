package HomeTask;

import java.util.Scanner;

public class Ex_1 {
    public static void main(String[] arg) {
        //запрашиваем входные данные
        Scanner s = new Scanner(System.in);
        System.out.println("String 1:");
        String string1 = s.nextLine();//принимаем первую строку
        System.out.println("String 2:");
        String string2 = s.nextLine();//принимаем вторую строку
        if (string1.length() != string2.length())
            System.out.println("Different strings");//строки разной длины
        else {
            int count1 = 0;//счестчики цены букв
            int count2 = 0;
            for (int i = 0; i < string1.length(); i++) {//бежим по строкам
                count1 += Method (string1.charAt(i));//суммируем ценность букв
                count2 += Method (string2.charAt(i));
            }
            System.out.println(count2<count1);//возвращаем ответ
        }
    }
    public static int Method (char a){//метод сопоставляющий букву из слова и ее ценность
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
            for (int i=0; i < 28;i++){
                if (a == arr[i]){
                    return i;
                }
            }
        return 0;
    }
}
