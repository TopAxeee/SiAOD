import java.io.Console;
import java.util.Scanner;

public class Basketball {

    public static void main (String[] arg){

        System.out.println("Введите количество игроков:");
        int number;
        Scanner s = new Scanner(System.in);
        number = s.nextInt();
        int players[][] = new int[number][5];//players*characteristics

        System.out.println("Введите характеристики игроков:");
        for (int i=0;i<number;i++){
            for (int j=0;j<5;j++){
                players[i][j]=s.nextInt();//get characteristics all players
            }
        }

        System.out.println("Категории игроков:");
        for (int i=0;i<number;i++){
            int Counter=0;
            //get summary of all characteristics
            Counter+=Height(players[i][0]);
            Counter+=Arms(players[i][1]);
            Counter+=Points(players[i][2]);
            Counter+=Take(players[i][3]);
            Counter+=Pass(players[i][4]);

            if (Categories(Counter)==0){//unicorn?
                if (Arms(players[i][1])==1000||Height(players[i][0])==1000){//3000 points and arm or height characteristic?
                    System.out.println(Categories(Counter));//Unicorn!
                }
                else System.out.println(Categories(Counter)+1);//we have first category because height or arms not unicorn
            }
            else System.out.println(Categories(Counter));//not unicorn-> print category 
        }
    }

    public static int Height (int height){
    //input: player characteristic Height
        int counts=0;
        if (height>220){ //extra
            counts=1000;
        }
        else if (height<=220&&height>=205){ //upper range
            counts=100;
        }
        else counts=0;
        return counts;
    }

    public static int Arms (int arm){
    //input: player characteristic Arms
        int counts=0;
        if (arm>250){   //extra
            counts=1000;
        }
        else if (arm<=250&&arm>=225){ //upper range
            counts=100;
        }
        else counts=0;
        return counts;
    }

    public static int Points (int points){
    //input: player characteristic Points
        int counts=0;
        if (points>20){     //extra
            counts=1000;
        }
        else if (points<=20&&points>=15){ //upper range
            counts=100;
        }
        else counts=0;
        return counts;
    }

    public static int Take (int take){
    //input: player characteristic Take
        int counts=0;
        if (take>6){    //extra
            counts=1000;
        }
        else if (take<=6&&take>=4){ //upper range
            counts=100;
        }
        else counts=0;
        return counts;
    }

    public static int Pass (int pass){
    //input: player characteristic Pass
        int counts=0;
        if (pass>7){    //extra
            counts=1000;
        }
        else if (pass<=7&&pass>=5){ //upper range
            counts=100;
        }
        else counts=0;
        return counts;
    }


    public static int Categories (int points){
        //input: summary of player's counts
        if (points>=3000){  //may be the unicorn
            return 0;
        }
        else if (points>=2100){ //2 *1000 (extra)+100 (upper range)
            return 1;
        }
        else if (points>=1100||points>=300){//1000 (extra)+100 (upper range) or 3*100(upper range)
            return 2;
        }
        else return 3;

    }
}