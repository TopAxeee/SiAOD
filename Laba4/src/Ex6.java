import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Ex6 {
    public static <ex> void main (String[] arg) {
        Stack<Integer> digits = new Stack<>();
        Stack<String> letters = new Stack<>();
        Stack<String> others = new Stack<>();
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#6.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                        digits.push(Integer.valueOf(String.valueOf(line.charAt(i))));
                    } else if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z' || line.charAt(i) >= 'a' && line.charAt(i) <= 'z' || line.charAt(i) >= 'А' && line.charAt(i) <= 'Я' || line.charAt(i) >= 'а' && line.charAt(i) <= 'я') {
                        letters.push(String.valueOf(line.charAt(i)));
                    } else {
                        others.push(String.valueOf(line.charAt(i)));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        String s1 = " ";
        String s2 = " ";
        String s3 = " ";
        Stack<Integer> temp1 = new Stack<>();
        while (digits.isEmpty()!=true) temp1.push(digits.pop());
        while (temp1.isEmpty()!=true)s1 = s1 + String.valueOf(temp1.pop()) + " ";
        Stack<String> temp2 = new Stack<>();
        while (letters.isEmpty()!=true) temp2.push(letters.pop());
        while (temp2.isEmpty()!=true) s2 = s2 + String.valueOf(temp2.pop()) + " ";
        Stack<String> temp3 = new Stack<>();
        while (others.isEmpty()!=true) temp3.push(others.pop());
        while (temp3.isEmpty()!=true) s3 = s3 + String.valueOf(temp3.pop()) + " ";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
