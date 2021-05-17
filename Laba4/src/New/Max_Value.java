package New;

import java.util.Scanner;

public class Max_Value {//4,30,34,5,9
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите количесвто отрезков:");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Вводите отрезки:");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        String [] str = new String[n];
        for (int i=0;i<n;i++){
            str[i]=String.valueOf(arr[i]);
        }
        String res = "";
        while (str.length!=0){
            res+=Max(str);
            str =Delete(str,Max(str));
        }
        System.out.println(res);

    }
    public static String Max(String[] s){
        String max="";
        int maxim = 0;
        for(int i=0;i<s.length;i++){
            if(Integer.parseInt (String.valueOf(s[i].charAt(0)))>maxim){
                max=s[i];
            }
        }return max;
    }
    public static String[] Delete (String[] s, String max){
        String[] s1 = new String[s.length-1];
        for (int i=0;i<s.length;i++){
            if(s[i]!=max) s1[i]=s[i];
        }return s1;
    }
}
