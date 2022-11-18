/**********************************************************************/
/*                                                                    */
/* Author      : Chan Pak Lam                                         */
/* StudentID   : 200074680                                            */
/* Class       : IT114105/1C                                          */
/* Date        : 2020-11-28                                           */
/* Description : Connect four with a 6x7 board                        */
/* Input       : disc of Player1, Player2                             */
/* Output      : winner, disc location player input,                  */
/* range out or not, put 9 to left                                    */
/*                                                                    */
/* History                                                            */
/* 11/11/2020   : Create and done                                     */
/* 18/11/2020     The check have bug, can't read row and col          */
/* 24/11/2020     fix bug and create fake board                       */
/* 28/11/2020     final test                                          */
/**********************************************************************/

import java.util.Scanner;
public class FinalAssignment {
    public static int[][] Board=new int[6][7];                 // Create Game Board
    public static int player=1;                    // 1 to Player1 and -1 to Player2
    public static int count=0;                                    // Caculate the number of discs

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Player1=O, Player2=X");
        int rol2=5;
        
        // Print fake board for player watch
        for(int rol=0; rol<6; ++rol) {   
            System.out.println(rol2-- +" | | | | | | | |");
        }
        System.out.println("  ---------------");
        System.out.println("   0 1 2 3 4 5 6");

        // Create two while(input and game), intput the location of coulmn
        while(true) {   

            // to change player 1 and 2
            while(true) {                       
                if(player == 1)
                    System.out.println("Player 1 type a column(0 - 6) or 9 to quit current game: "); 
                else
                    System.out.println("Player 2 type a column(0 - 6) or 9 to quit current game: "); 
                int column = input.nextInt();
                if(column==9) {
                    System.out.println("Bye Bye!");
                    System.exit(0); 
                }
                if (CheckRange(column, player) == true) {  
                    break;                         // if range is correct, break out                
                }  
            } 
            ShowChecker(); 
            // To Check winner use JudgingWin method
            if (CheckWinner(player) == true) {             
                if (player==1) 
                    System.out.println("Player 1 win this game!");

                else
                    System.out.println("Player 2 win this game!");    
                break;
            }
            if (count == 42) {                              
                System.out.println("Draw!");       
                break;                    
            }
            player=-player;
        }  
        System.out.println("Game Over!");
    }

    // Check range of user input, if out of range print erro
    public static boolean CheckRange(int x, int num)
    {
        if (x < 0 || x > 6) {           
            System.out.println("Range of column should be 0 to 6");  
            return false;  
        }
        int rol = 5;
        while (rol>=0)
        {
            if (Board[rol][x] == 0) {                            
                Board[rol][x] = num;
                count++;
                return true;  
            }
            else
            {
                rol--;
            }
        }
        System.out.println("Coulmn "+x+" is full!");
        return false;
    }

    // Check Winner is Player1 or 2 
    public static boolean CheckWinner(int num)    
    {
        for (int rol = 0; rol < 6; rol++) {       
            for (int col=0 ; col < 3 ; col++){
                if (Board[rol][col] == Board[rol][col+1] && Board[rol][col+1] == Board[rol][col+2]  
                && Board[rol][col+2] == Board[rol][col+3] && Board[rol][col+3] == num)   // Col Check
                {  
                    return true;  
                }
                else if (Board[col][rol] == Board[col+1][rol] && Board[col+1][rol] == Board[col+2][rol] 
                && Board[col+2][rol] == Board[col+3][rol] && Board[col+3][rol] == num)   //Row Check
                {  
                    return true;  
                }
            }
        }
        for (int rol = 0; rol < 3; rol++ ) {       
            for (int col = 0 ; col < 4 ; col++){
                if (Board[rol][col] == Board[rol+1][col+1] && Board[rol+1][col+1] == Board[rol+2][col+2]
                && Board[rol+2][col+2] == Board[rol+3][col+3]&&Board[rol+3][col+3]==num)
                {                                                                // Col Row Check
                    return true;
                }
                if (Board[rol][6-col] == Board[rol+1][5-col] && Board[rol+1][5-col] == Board[rol+2][4-col]
                && Board[rol+2][4-col] == Board[rol+3][3-col]&&Board[rol+3][3-col]==num)
                {                                                                // Row Col Check
                    return true;
                }
            }
        }
        return false;
    }

    //Print real board after check, print result "1" or "2" in board
    public static void ShowChecker()    
    {      
        int rol2=5;
        for (int rol = 0; rol < 6; ++rol) {  
            System.out.print(rol2-- +" |");             
            for (int col = 0; col < 7; ++col) {  
                if (Board[rol][col] == 1 )
                    System.out.print("O|");
                else if(Board[rol][col] == -1)
                    System.out.print("X|");
                else
                    System.out.print(" |");
            }  
            System.out.println();
        } 
        System.out.println("  ---------------");
        System.out.println("   0 1 2 3 4 5 6");
    } 
}
