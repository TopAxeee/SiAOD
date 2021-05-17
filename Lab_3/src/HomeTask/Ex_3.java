package HomeTask;

import java.util.Scanner;

public class Ex_3 {
    public static void main(String[] arg){
        Scanner s = new Scanner(System.in);
        System.out.println("String:");
        String string1 = s.nextLine();//получаем строку
        int count = 0;
        for (int i=0; i<string1.length();i++){//определяем начало поиска
            String sub = "";
            for(int j=i; j<string1.length();j++){//добавляем
                sub+=string1.charAt(j);
                if (string1.indexOf(sub,j)==i+sub.length()){//если ближайшее вхождение текущего слова находится
                    count++;//сразу полсе его конца, то увеличиваем счетчик искомых слов
                    System.out.println(sub+" индекс его ближайшего вхождения: "+string1.indexOf(sub,j));
                }
            }
        }
        System.out.println(count);
    }
}
