import java.util.Scanner;

public class Main {

    public static void displayBoard(char[][] board) {
        System.out.println();
        System.out.printf(
            """
            +++++++++++++
            | %c | %c | %c |
            +++++++++++++
            | %c | %c | %c |
            +++++++++++++
            | %c | %c | %c |
            +++++++++++++
            %n""", board[0][0], board[0][1], board[0][2], board[1][0], board[1][1], board[1][2], board[2][0], board[2][1], board[2][2]
        );
    }

    public static void displayRules() {
        System.out.println(
                """
                
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

    public static void main(String[] args) {
        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        boolean run = true;
        displayBoard(board);
    }
}
