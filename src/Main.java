import java.util.Scanner;

public class Main {

    // The below function is used to display the tic-tac-toe board
    public static void displayBoard(char[][] board) {
        System.out.printf(
            """
            +++++++++++++
            | %c | %c | %c |
            +++++++++++++
            | %c | %c | %c |
            +++++++++++++
            | %c | %c | %c |
            +++++++++++++
            """, board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]
        );
    }

    // The below functions tells about the rules of the tic-tac-toe game
    public static void displayRules() {
        System.out.println(
                """
                \n
                Here are the rules of Tic Tac Toe explained in points:
                1. Players and board: Tic Tac Toe is played between two players on a grid with nine squares arranged in a 3x3 format.
                2. Symbols: Each player chooses a symbol, traditionally "X" or "O".
                3. Taking turns: Players take turns placing their chosen symbol in one of the empty squares on the grid.
                4. Winning: The first player to get three of their symbols in a row (horizontally, vertically, or diagonally) wins the game.
                5. Draws: If all nine squares are filled and no player has achieved three in a row, the game ends in a draw.
                6. First move: Traditionally, the player who plays "X" goes first. However, some variations allow the first player to choose their symbol.
                7. Strategy: There are basic strategies to improve your chances of winning, like aiming for the center square or creating opportunities to win in two ways at once (a "fork").        
                8. Perfect play:  When both players use optimal strategies, the game usually ends in a draw.
                """
        );
    }

    // The below function tells about the controls regarding the game
    public static void displayControlRules() {
        System.out.println(
                """
                \n
                1. Enter 0 to quit the game
                2. Enter 10 to display the Game Rules
                3. Enter 11 to display the Game Control Rules
                4. Enter the value from 1 to 9 to fill in the board with your assigned character ( 'X' or 'O' )
                """
        );
    }

    // Function to fill the empty space with a character the function return 0 if the space is already occupied and 1 if the space is not occupied
    public static int fill(int index, char[][] board, char character) {
        if(index > 0 && index < 4) {
            if(board[0][index-1] != ' ' ) return 0;
            board[0][index-1] = character;
        } else if (index > 3 && index < 7) {
            if(board[1][(index-1)%3] != ' ' ) return 0;
            board[1][(index-1)%3] = character;
        } else if (index > 6 && index < 10) {
            if(board[2][(index-1)%3] != ' ' ) return 0;
            board[2][(index-1)%3] = character;
        }
        return 1;
    }

    // The below function reset's the board to empty
    public static void resetBoard(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                board[i][j] = ' ';
            }
        }
    }

    // The below function exits the program
    public static void exitGame() {
        System.out.println("Have a good day!");
        System.exit(0);
    }

    public static boolean isWinner(char[][] board, char character) {

        /*
        (0,0), (0,1), (0,2)
        (1,0), (1,1), (1,2)
        (2,0), (2,1), (2,2)
        */

        // Checking all the rows and columns to find whether three consecutive elements have same symbol
        for (char[] chars : board) {
            // Setting the variable to true
            boolean match = true;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] != character) {
                    match = false;
                    break;
                }
            }
            // If the element's in a row or column are consecutive we return true or else the looping continues
            if (match) return match;
        }

        boolean match = true;

        // The below function checks the diagonal from top-left to bottom-right(0,0), (1,1), (2,2)
        for(int i=0;i < board.length;i++) {
            if (board[i][i] != character) {
                match = false;
                break;
            };
        }

        if (match) return match;

        match = true;

        // The below function checks the diagonal from top-right to bottom-left (0,2), (1,1), (2,0)

        for(int i=0;i<board.length;i++) {
            if (board[i][2-i] != character) {
                return false;
            };
        }

        return match;
    }

    public static void main(String[] args) {

        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        char character = 'X';

        Scanner scanner = new Scanner(System.in);

        int num = 0;
        int count = 0;

        while (true) {
            if(count == 9) {
                displayBoard(board);
                System.out.println("The game is a draw\n Press 1 to play it again & Press 0 to quit it.\n");
                int quit = scanner.nextInt();
                while(true) {
                    if(quit == 0) {
                        exitGame();
                    } else if (quit == 1) {
                        count = 0;
                        resetBoard(board);
                        break;
                    } else {
                        System.out.println("Please enter a proper value\n");
                    }
                }
            }

            if(count%2==0) {
                System.out.println("\nPlayer 1 turn 1\n");
                character = 'X';
            } else {
                System.out.println("\nPlayer 2 turn 2\n");
                character = 'O';
            }

            displayBoard(board);
            num = scanner.nextInt();

            if (num == 0) {
                exitGame();
            } else if (num == 10) {
                displayRules();
            } else if (num == 11) {
                displayControlRules();
            }else if (num < 1 && num > 9) {
                System.out.println("Enter a valid number from 1 to 9");
            } else {
                if(fill(num,board,character) == 0) System.out.println("Enter valid number from 1 to 9");
                else {
                    if (isWinner(board, character)) {
                        if (character == 'X') System.out.println("Player 1 has won the game");
                        else System.out.println("Player 2 has won the game");
                        break;
                    } else {
                        count++;
                    }
                };
            }
        }
    }
}
