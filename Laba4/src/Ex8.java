import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Ex8 {
    public static <ex> void main (String[] arg) {
        Stack<String> stack = new Stack<>();
        System.out.println("Text:");
        try (FileReader reader = new FileReader("#8.txt");
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                stack.push(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Create_File();
        //
        try{
            FileWriter writer = new FileWriter("#8_new.txt",true);
            while (stack.isEmpty()!=true) {
                writer.write(stack.pop()+'\n');
            }
            writer.flush();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        //

    }
    public static void Create_File(){
        try{
            File file = new File ("C:\\Users\\Final\\Desktop\\Laba4\\#8_new.txt");
            if (file.createNewFile())
                System.out.println("Good");
            else System.out.println("Error");
        }catch (Exception e){
            System.err.println(e);
        }
    }
}
