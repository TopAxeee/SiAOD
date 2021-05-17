import java.util.*;
public class EX_3 {
        public static Stack<Integer>[] tower = new Stack[4];
        public static int temp;

    public static void TowersOfHanoiThree(int numDisk)
    {
        //adding disk to stack
        temp = numDisk;
        tower = new Stack[4];

        for(int a = 0; a <= 3; a++)
        {
            tower[a] = new Stack<Integer>();
        }

        for (int i = numDisk; i > 0; i--)
        {
            tower[1].push(i); // to show "1 2 3" i changed the value which was pushed in the stack
// from tower[1].push(numDisk) to tower[1].push(i)
        }
        show(); //In your example this method call was placed inside the for loop.
//Moving it outside will show the stacks only after the values are added
        solver(numDisk, 1, 3, 2);
    }

    public static void show() {
            for (int i = 1; i < tower.length; i++) { // iterate over your array of stacks
                String pillar = "Pillar " + i + ":"; // e.g. "Pillar 1: "
                for (int disk : tower[i]) { // iterate over the stack located at index i
                    pillar += " " + disk; // concatenate the current disk to the String
                }
                System.out.println(pillar); // Display this pillar
            }
            System.out.println(); // Line break to seperate the show() calls
    }// end show

        public static void solver(int numDisk, int start, int middle, int end)
        {
            if(numDisk > 0)
            {
                try
                {
                    //sorting disks
                    solver(numDisk - 1, start, end, middle);
                    int dis = tower[start].pop(); //move disk top-most disk of start
                    tower[middle].push(dis);
                    show();
                    solver(numDisk - 1, end, middle, start);
                }
                catch(Exception e)
                {
                }
            }
        }

        public static void main(String args[])
        {
            tower[1] = new Stack<Integer>();
            tower[2] = new Stack<Integer>();
            tower[3] = new Stack<Integer>();

            System.out.println("Get numbers:");
Scanner s= new Scanner(System.in);
        int num = s.nextInt();
            TowersOfHanoiThree(num);
        }
}
