package Ex3;

public class Chess_2 {
    static int [][]board = new int [8][8];
    public static final String ANSI_RED = "\u001B[31m";//red color for text
    public static final String ANSI_GREEN = "\u001B[32m";//green color for text
    public static final String ANSI_RESET = "\u001B[0m";//reset text color
   public static void setQueen(int i, int j) {
        for (int x = 0; x < 8; ++x){
            ++board[x][j];
            ++board[i][x];
            int foo;
            foo = j - i + x;
            if (foo >= 0 && foo < 8)
                ++board[x][foo];
            foo = j + i - x;
            if (foo >= 0 && foo < 8)
                ++board[x][foo];
        }
        board[i][j] = -1;
   }

    public static void resetQueen(int i, int j)
    {
        for (int x = 0; x < 8; ++x)
        {
            --board[x][j];
            --board[i][x];
            int foo;
            foo = j - i + x;
            if (foo >= 0 && foo < 8)
                --board[x][foo];
            foo = j + i - x;
            if (foo >= 0 && foo < 8)
                --board[x][foo];
        }
        board[i][j] = 0;
    }

    public static boolean tryQueen(int i) {
        boolean result = false;
        for (int j = 0; j < 8; ++j)
        {
            if (board[i][j] == 0)
            {
                setQueen(i, j);
                if (i == 7)
                    result = true;
                else
                {
                    if (!(result = tryQueen(i + 1)))
                        resetQueen(i, j);
                }
            }
            if (result)
                break;
        }
        return result;
    }

    public static void main(String[] arg) {
        for (int i = 0; i < 8; ++i)
            for (int j = 0; j < 8; ++j)
                board[i][j] = 0;
                tryQueen(0);


                //vivod
        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j){
                if (board[i][j] == -1)
                    System.out.print(ANSI_GREEN+"5  "+ANSI_RESET);//
                else
                    System.out.print(ANSI_RED+"1  "+ANSI_RESET);
            }
            System.out.println();
        }
    }
}
