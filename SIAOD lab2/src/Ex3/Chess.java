package Ex3;

public class Chess {
    static int n=8;//quantity of cells
    static int q=5;//queen number
    static int counter  = 0;//counter for queens (max 8)
    public static final String ANSI_RED = "\u001B[31m";//red color for text
    public static final String ANSI_GREEN = "\u001B[32m";//green color for text
    public static final String ANSI_RESET = "\u001B[0m";//reset text color
    public static void main (String [] arg){
        int [][] board = new int [n][n];//chess board 8*8 cells
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board [i][j]=0;//all cells are free
            }
        }
            Search(board,0);
            Print_board(board);

    }
    public static void Closed_cells (int [][]board, int string, int column){
        //input: chess board, queen position
        //step 1: delete the line
        for (int i=0;i<n;i++){
            board[string][i]--;//we can't put the queen here
        }
        //step 2: delete the columns
        for (int i=0;i<n;i++){
            board[i][column]--;//we can't put the queen here
        }
        //step 3: delete the left diagonal
                //upper half
        int i=string; int j=column;
        while (i>0&&j<n-1){
            i--;j++;
            board[i][j]--;//we can't put the queen here
        }
                //bottom half
        i=string; j=column;
        while (i<n-1&&j>0){
            i++;j--;
            board[i][j]--;//we can't put the queen here
        }
        //step 4: delete the right diagonal
                //upper half
        i=string; j=column;
        while (i>0&&j>0){
            i--;j--;
            board[i][j]--;//we can't put the queen here
        }
                //bottom half
        i=string; j=column;
        while (i<n-1&&j<n-1){
            i++;j++;
            board[i][j]--;//we can't put the queen here
        }
        board[string][column]=q;//put the queen
        //output: board with closed cells and queen's cell
    }
    public static void Open_cells (int [][]board, int string, int column){
        //input: chess board, queen position
        //step 1: delete the line
        //input: chess board, queen position
        //step 1: delete the line
        for (int i=0;i<n;i++){
            board[string][i]++;//we can't put the queen here
        }
        //step 2: delete the columns
        for (int i=0;i<n;i++){
            board[i][column]++;//we can't put the queen here
        }
        //step 3: delete the left diagonal
        //upper half
        int i=string; int j=column;
        while (i>0&&j<n-1){
            i--;j++;
            board[i][j]++;//we can't put the queen here
        }
        //bottom half
        i=string; j=column;
        while (i<n-1&&j>0){
            i++;j--;
            board[i][j]++;//we can't put the queen here
        }
        //step 4: delete the right diagonal
        //upper half
        i=string; j=column;
        while (i>0&&j>0){
            i--;j--;
            board[i][j]++;//we can't put the queen here
        }
        //bottom half
        i=string; j=column;
        while (i<n-1&&j<n-1){
            i++;j++;
            board[i][j]++;//we can't put the queen here
        }
        board[string][column]=0;//put the queen
        //output: board with closed cells and queen's cell
    }
    public static void Print_board(int [][] board){
        //input: board with queens and closed cells positions
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (board [i][j]<0)//red color for closed cell
                    System.out.print(ANSI_RED+1+"  "+ANSI_RESET);
                if (board [i][j]==5)//green color for queen's sell
                    System.out.print(ANSI_GREEN+board [i][j]+"  "+ANSI_RESET);//
            }
            System.out.println();
        }
        //output:print colorful board array to console
    }
    public static boolean Search (int [][] board,int s){
        //input:chess board
        boolean result = false;
            for (int j=0;j<n;j++){
                if(board[s][j]==0){
                    Closed_cells(board, s,j);
                    counter++;
                    if (s == 7)
                    result = true;
                else
                    {
                        if (!(result = Search(board,s + 1)))
                            Open_cells(board,s, j);
                    }
                }
                if (result)
                    break;
            }
        return result;

    }
}
