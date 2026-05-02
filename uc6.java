public class TicTacToe {

    // Game board
    static char[][] board = new char[3][3];

    // Entry point
    public static void main(String[] args) {

        // Initialize board with '-'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Place a sample move
        placeMove(0, 0, 'X');

        // Print updated value
        System.out.println("Cell (0,0): " + board[0][0]);
    }

    /**
     * UC6: Place Move on Board
     * Updates the board with the given symbol
     */
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}
