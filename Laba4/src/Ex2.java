import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Ex2 {
    //создадим дек, хранящий алфавит
    //так как текстовый файл зашифрован буква алфавита+2
    static Deque<String> first =new LinkedList<String>();
    public static void Code (){
        char[] arr = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ','Ъ','Ы','Ь', 'Э', 'Ю', 'Я'};
        for (int i=0;i< arr.length;i++)
            first.addLast(String.valueOf(arr[i]));
    }
    static String str = "";
    public static void main (String [] arg){
        Code();//активируем дек
        //прочтаем файл и запишем его в строку
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#2.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String len;
            while ((len = br.readLine()) != null) {
                System.out.println(len);
                str=str + len;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' ')continue;
            int char_coast = Coast(str.charAt(i));
            while (Coast(first.peekFirst().charAt(0))!=char_coast){
                One();
            }
            TwoFirst();
            str=Replace(i);
        }
        System.out.println(str);
    }
    //Напишем метод, перекручивающий дек на два символа алфавита назад, для постановки правильной буквы С начала
    public static void TwoFirst(){
        String s1 = first.pollLast();
        first.addFirst(s1);
        String s2=first.pollLast();
        first.addFirst(s2);
    }
    //Напишем метод, перекручивающий дек на два символа алфавита назад, для постановки правильной буквы С конца
    public static void TwoLast(){
        String s1 = first.pollFirst();
        first.addLast(s1);
        String s2 = first.pollFirst();
        first.addLast(s2);
    }
    //Напишем метод, перекручивающий дек на один символа алфавита вперед, для поиска нужной буквы
    public static void One(){
        String s1 = first.pollFirst();
        first.addLast(s1);
    }
    public static int Coast(char ch) {//возвращает стоимость буквы
        char[] arr = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ','Ъ','Ы','Ь','Э', 'Ю', 'Я'};
        int g=0;
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]){
                g=i;
                break;
            }
        }
        return g;
    }
    public static String Replace (int i){
        String temp1="";
        for (int j=0;j<i;j++){
            temp1+=str.charAt(j);
        }
        String temp2="";
        for (int j=i+1;j<str.length();j++){
            temp2+=str.charAt(j);
        }
        String temp3 = temp1+first.peekFirst()+temp2;
        return temp3;
    }
}
