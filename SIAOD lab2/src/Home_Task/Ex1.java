package Home_Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Ex1 {
    public static void main(String[] arg) throws IOException {
        //экземпляры классов для считывания
        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Вводим кол-во строк
        System.out.println("Введите количесвто строк в записи заседания:");
        int number = sc.nextInt();
        //предварительная проверка на достоверность
        if(number%2!=0){
            System.out.println("В записи заседания должно быть четное количество записей! Иначе, запись неверна.");
        }else {
            //создаем и заполняем массив строк (запись заседания)
            String[] str = new String[number];
            System.out.println("Вводите строки из записи заседания:");
            for (int i = 0; i < number; i++) {//вводим строки
                str[i]=reader.readLine();
            }
            //выводим результат
            System.out.println(Result(str));
        }
    }

    public static boolean Result (String[] str){
        //получаем на вход массив строк
        Stack <String> stack = new Stack<>();
        //push - добавляет элемент на верх стека
        //pop - удаляет верхний элемент из стека и возвращает его
        //peek - возвращает верхний элемент стека, но не удаляет его из стека
        for (int i=0;i< str.length;i++){
            if(str[i].charAt(0)=='A'){//если это добавление
                stack.push(str[i].substring(str[i].length() - 1));//добавляем в Стек последнюю букву строки (название партии)
            }else if(str[i].charAt(0)=='V'){//если это принятие решения
                char ch = stack.pop().charAt(0);
                if(str[i].charAt(str[i].length()- 1)!=ch){//то сравниваем последнюю закрытую и последнюю открытую "скобки" (партии)
                    return false;//если "скобки" не одинаковы
                }
            }
        }
        return true;//если все получилось
    }
}
