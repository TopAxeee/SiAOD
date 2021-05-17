import java.util.Deque;
import java.util.LinkedList;
import java.io.*;

public class Ex1 {
    public static <ex> void main (String[] arg){
        //создаем два дека
        int count=0;
        Deque <String> first =new LinkedList<String>();
        Deque <String> second =new LinkedList<String>();
        //создаеи ридер файла
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#1.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                //
                    first.addLast(line);//записываем строки в дек с записью в зад!!!
               // }else {
               //     second.addLast(line);//записываем строки в дек с записью в зад!!!
               // }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //основная работа:

    for (int i=0;i<count*5;i++){
        if (i%2==0){//Четное
           String line = first.pollLast();//переносим первую книгу с первого на второй
            second.add(line);
            while (first.isEmpty() != true) {
                if (Coast((first.peekLast()).charAt(0)) < Coast((second.peekLast()).charAt(0))) {//если текущее (1) меньше  или равно первого (2)
                    line = first.pollFirst();//переносим с первого на второй в начало
                    second.addFirst(line);
                } else {//если текущее (1) больше первого (2)
                    line = first.pollLast();//переносим с первого на второй в конец
                    second.addLast(line);
                }
            }
            //перезаписываем все обратно на первый
            while (second.isEmpty() != true) {
                line = second.pollFirst();//переносим с первого на второй в конец
                first.addLast(line);
            }
        }else {//НЕ Четное
            String line = first.pollFirst();//переносим с первого на второй
            second.add(line);
            while (first.isEmpty() != true) {
                if (Coast((first.peekFirst()).charAt(0)) <= Coast((second.peekFirst()).charAt(0))) {//если текущее (1) меньше  или равно первого (2)
                    line = first.pollFirst();//переносим с первого на второй в начало
                    second.addFirst(line);
                } else {//если текущее (1) больше первого (2)
                    line = first.pollFirst();//переносим с первого на второй в конец
                    second.addLast(line);
                }
            }
            //перезаписываем все обратно на первый
            while (second.isEmpty() != true) {
                line = second.pollFirst();//переносим с первого на второй в конец
                first.addLast(line);
            }
        }
    }
        //VIVOD
        System.out.println();
        System.out.println();
        System.out.println("New:");
        while (first.isEmpty()!=true) {//пока первый не пустой
             String line = first.pollFirst();//переносим с первого на второй в обратном порядке
            System.out.println(line);
        }


    }
    public static int Counter (Deque <String> first1){
        /**принцип работы:
         * номер шага   1             2           3
         * первый      ВГАМ          ГАМ         АМ
         * второй     *пусто*        В           ГВ
         *                      сравниваем    сравниваем
         *                      первые        первые
         *  Г больше В -> они по порядку
         *  А меьше Г ->  они не по порядку
         */
        int count = 0;
        Deque <String> second2 =new LinkedList<String>();
        while (first1.isEmpty()!=true){//пока первый не пустой
            String line = first1.pollFirst();//переносим с первого на второй в обратном порядке
            second2.add(line);
            if(first1.isEmpty()!=true){
            if(Coast((first1.peekFirst()).charAt(0))>Coast((second2.peekFirst()).charAt(0)))//проверяем, первые буквы
                count++;
            }
        }
        return count;
    }
    public static int Coast(char ch) {//возвращает стоимость буквы
        char[] arr = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Э', 'Ю', 'Я'};
        int g=0;
        for (int i = 0; i < arr.length; i++) {
            if (ch == arr[i]){
                g=i;
                break;
            }
        }
        return g;
    }
    public static Deque <String> SORT (Deque <String> deque){
        String str = deque.pollFirst();
        if (Coast(str.charAt(0)) <= Coast((deque.peekFirst()).charAt(0))) {//если текущее (1) меньше  или равно первого (2)
            deque.addFirst(str);
        } else {//если текущее (1) больше первого (2)
            deque.addLast(str);
        }
        return deque;
    }
}
