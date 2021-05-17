import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

public class Ex7 {
    public static <ex> void main (String[] arg) {
        Deque<Integer> first = new LinkedList<>();
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#7.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                int num = Integer.valueOf(line);
                if(num>=0) first.addLast(num);
                else first.addFirst(num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("NEW");
        while (first.isEmpty()!=true){
            System.out.println(first.pollFirst()+"  ");
        }
    }

}
