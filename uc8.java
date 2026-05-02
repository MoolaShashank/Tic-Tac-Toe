import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (!gameOver) {

            printBoard();

            if (isHumanTurn) {
                System.out.println("Your turn (row and column): ");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (isValidMove(row, col)) {
                    placeMove(row, col, 'X');
                    if (checkWin('X')) {
                        printBoard();
                        System.out.println("You win! 🎉");
                        gameOver = true;
                    } else if (isBoardFull()) {
                        printBoard();
                        System.out.println("It's a draw!");
                        gameOver = true;
                    } else {
                        isHumanTurn = false; // switch turn
                    }
                } else {
                    System.out.println("Invalid move, try again.");
                }

            } else {
                System.out.println("Computer's turn...");
                computerMove();

                if (checkWin('O')) {
                    printBoard();
                    System.out.println("Computer wins! 🤖");
                    gameOver = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    isHumanTurn = true; // switch turn
                }
            }
        }
    }

    // UC5
    static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 &&
               col >= 0 && col < 3 &&
               board[row][col] == '-';
    }

    // UC6
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7
    static void computerMove() {
        int row, col;
        while (true) {
            int slot = (int)(Math.random() * 9) + 1;
            row = (slot - 1) / 3;
            col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                placeMove(row, col, 'O');
                break;
            }
        }
    }

    // Check win
    static boolean checkWin(char symbol) {

        // rows & columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
                return true;

            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
                return true;
        }

        // diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
            return true;

        return false;
    }

    // Check draw
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-')
                    return false;
            }
        }
        return true;
    }

    // Print board
    static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
