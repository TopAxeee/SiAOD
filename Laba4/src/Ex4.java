import java.util.Deque;
import java.util.LinkedList;
import java.io.*;
import java.util.Stack;

public class Ex4 {
    public static <ex> void main(String[] arg) {
        //создаем стек
        Stack<String> first = new Stack<String>();
        //char[] text;
        //создаеи ридер файла
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#4.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                char[] text = line.toCharArray();
                for (int i=0; i<text.length; i++){
                    if (text [i] == '(' ){
                        first.push(line);//записываем строки в стек с записью наверх!!!
                    }
                    if (text [i]== ')'){
                        if (first.isEmpty()== true){
                            System.out.println("Wrong");
                            break;
                        }
                        first.pop();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (first.isEmpty() == true){
            System.out.println("Correct");
        }
        else {
            System.out.println("Wrong");
        }
    }
}
//основная работа: