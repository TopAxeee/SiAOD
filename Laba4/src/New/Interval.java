package New;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Interval {
    public static void main (String [] args){
        String input="";
        System.out.println("Ввод:");
        Scanner s = new Scanner(System.in);
        input=s.nextLine();
        int [] array = Search_interval(input);
        int counter = 0;
        Deque <Integer> deque = new LinkedList<>();
        for (int i=0;i<(array.length)-2;i++){
            if (array[i+1]>=array[i+2]&&array[i+1]<=array[i+3]){
                deque.addLast(array[i]);
                deque.addLast(array[i+3]);
                i+=3;
                counter+=2;
            }
            else{
                deque.addLast(array[i]);
                deque.addLast(array[i+1]);
                counter+=2;
                i+=2;
            }
        }
        //костыль
        if(array[array.length-1]!= deque.peekLast()){
            deque.addLast(array[array.length-2]);
            deque.addLast(array[array.length-1]);
            counter+=2;
        }
        Print(Deq_to_int(deque,counter));
        //System.out.println(Arrays.toString(Deq_to_int(deque,counter)));
        //System.out.println(Arrays.toString(array));
    }
    public static int [] Search_interval(String string){
        Deque <Integer> deque = new LinkedList<>();
        int count = 0;
        String temp = "";
        for (int i=1;i<string.length()-1;i++){
            if (string.charAt(i)=='['){
                while (string.charAt(i)!=']'){
                    if(string.charAt(i)>='0'&&string.charAt(i)<='9'){
                        temp+=string.charAt(i);
                        i++;
                    }else if (string.charAt(i)==','){
                        deque.addLast(Integer.parseInt(temp));
                        count++;
                        i++;
                        temp="";
                    }else i++;
                }
                deque.addLast(Integer.parseInt(temp));
                count++;
                //i++;
                temp="";
            }

        }
        return Deq_to_int(deque,count);
    }
    public static int [] Deq_to_int (Deque <Integer> deque, int count){
        int [] arr = new int [count];
        for (int i=0;i<count;i++){
            arr[i]=deque.pollFirst();
        }
        return arr;
    }
    public static void Print (int []arr){
        String str = "[";
        for (int i=0;i< arr.length;i++){
            if (i%2==0){
                str+="["+arr[i]+",";
            }
            else {str+=arr[i]+"], ";}
        }
        str=str.substring(0, str.length() - 2);
        str+="]";
        System.out.println(str);
    }
}
