public class TicTacToe {

    // Game board
    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    // Entry point
    public static void main(String[] args) {
        // Test cases
        System.out.println("Move (1,1): " + isValidMove(1, 1)); // true
        board[1][1] = 'X';
        System.out.println("Move (1,1) again: " + isValidMove(1, 1)); // false
        System.out.println("Move (3,0): " + isValidMove(3, 0)); // false
    }

    /**
     * UC5: Validate User Move
     * Checks if move is within bounds and cell is empty
     */
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }
}
