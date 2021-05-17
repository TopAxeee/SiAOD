package Ex_2;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main (String[] arg){
        int[][] blocks = new int[][]{{1,2,3,4}, {5,6,7,8}, {13, 9, 11, 12,}, {10, 14, 15, 0}};
        Print(blocks);
        int counter = 0;
        for (int i=0;i<4;i++){//суммируем количесвто чисел меньше текущего
            for (int j=0;j<4;j++){
                if (blocks[i][j]==0){
                    counter+=j;//номер ряда пустой ячейки
                }else
                counter +=Count (blocks[i][j],blocks,i,j);
            }
        }
        if(counter%2==0){
            Board initial = new Board(blocks);
            Solver solver = new Solver(initial);
            System.out.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                System.out.println(board);
        }else{
            System.out.println("No!");
        }
    }
    public static void Print(int [][]blocks){
        for (int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(blocks[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int Count (int max, int [][]blocks, int i_max,int j_max){
        int count = 0;
        for (int i=i_max;i<4;i++){
            for (int j=j_max;j<4;j++){
                if (blocks[i][j]<max) count++;
            }
        }
        return count;
    }
}
