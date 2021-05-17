package New;

import java.util.Scanner;

public class Triangle {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Введите количесвто отрезков:");
        int n = s.nextInt();
        int [] arr = new int [n];
        System.out.println("Вводите отрезки:");
        for (int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int max = 0; int temp = 0;
        for (int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for (int k=j+1;k<n;k++){
                    if((arr[i]<(arr[j]+arr[k]))&&(arr[j]<(arr[i]+arr[k]))&&(arr[k]<(arr[j]+arr[i]))){
                        temp=arr[i]+arr[j]+arr[k];
                        if(temp>max){
                            max=temp;
                        }
                    }else continue;

                }
            }
        }
        System.out.println(max);
    }
}
