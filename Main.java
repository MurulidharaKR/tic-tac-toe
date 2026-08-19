import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            char[][] board = new char[3][3];

            for (int i = 0; i < 3; i++) {
                Arrays.fill(board[i], ' ');
            }

            char player = 'X';

            for (int moves = 0; moves < 9; moves++) {
                printBoard(board);

                System.out.println("Player " + player + ", enter row and column (0-2):");
                int row = sc.nextInt();
                int col = sc.nextInt();

                if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
                    System.out.println("Invalid move!");
                    moves--;
                    continue;
                }

                board[row][col] = player;

                if (hasWon(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " wins!");
                    return;
                }

                player = (player == 'X') ? 'O' : 'X';
            }
            
            printBoard(board);
            System.out.println("It's a draw!");
        }
    }

    private static boolean hasWon(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static void printBoard(char[][] board) {
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);

            if (i < 2) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }
}