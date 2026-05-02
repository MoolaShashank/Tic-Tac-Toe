import java.util.Random;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char computerSymbol = 'O';
    static Random rand = new Random();

    // Entry point
    public static void main(String[] args) {
        computerMove();
        printBoard();
    }

    /**
     * UC7: Computer makes a random valid move
     */
    static void computerMove() {
        int row, col;

        // Keep generating until a valid move is found
        while (true) {
            int slot = rand.nextInt(9) + 1; // 1–9

            // Convert slot to row & column
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            // Check if valid
            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                System.out.println("Computer chose slot: " + slot);
                break;
            }
        }
    }

    // UC5: Validate move
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // UC6: Place move
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // Utility: Print board
    static void printBoard() {
        System.out.println("Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
