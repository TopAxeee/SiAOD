import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Ex3 {
    //создаем три стека
    static Stack<Integer> A = new Stack<>();
    static Stack<Integer> B = new Stack<>();
    static Stack<Integer> C = new Stack<>();
    static int count=0;
    public static <ex> void main(String[] arg) {
        System.out.println("Rings number?");
        Scanner s = new Scanner(System.in);
        count = s.nextInt();
        for (int i = count; i > 0; i--) {
            A.push(i);
        }
        Honoi(count, A, B, C);

    }

    public static int Size(Stack<Integer> S) {
        int counter = 0;
        while (S.isEmpty() != true) {
            S.pop();
            counter++;
        }
        return counter;
    }

    public static void Honoi(int count_H, Stack<Integer> A_H, Stack<Integer> B_H, Stack<Integer> C_H) {
        if (count_H == 1) {
            C_H.push(A_H.pop());
            Print(A_H,B_H,C_H);
        } else {
            Honoi(count_H - 1, A_H, C_H, B_H);
            Print(A_H, B_H, C_H);
            Honoi(count_H - 1, B_H, A_H, C_H);
        }
    }

    public static void Print(Stack<Integer> A_T, Stack<Integer> B_T, Stack<Integer> C_T) {
        String Pillar1 = "Pillar1: ";
        String Pillar2 = "Pillar2: ";
        String Pillar3 = "Pillar3: ";
        String emptyStr1 = "";
        String emptyStr2 = "";
        String emptyStr3 = "";  
        for (int x = 0; x <= count - 1; x++) {
            try{
                emptyStr1 += String.valueOf(A_T.get(x)) + " ";
            } catch (Exception e) {
                }
            try{
                emptyStr2 += String.valueOf(B_T.get(x)) + " ";
            } catch (Exception e) {
                }
            try {
                emptyStr3 += String.valueOf(C_T.get(x)) + " ";
            } catch (Exception e) {
                }
        }
        System.out.println(Pillar1 + emptyStr1);
        System.out.println(Pillar2 + emptyStr2);
        System.out.println(Pillar3 + emptyStr3);
        System.out.println();
    }
}
