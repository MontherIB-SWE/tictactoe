import java.util.Scanner;

public class TicTacToe {

    static char[][] position = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
    static int player = 1;
    static int[] choice = new int[9];
    static char x;

    public static void printBoard() {
        System.out.println("   |   |   ");
        System.out.println(" " + position[0][0] + " | " + position[0][1] + " | " + position[0][2] + " ");
        System.out.println("   |   |   ");
        System.out.println("---+---+---");
        System.out.println("   |   |   ");
        System.out.println(" " + position[1][0] + " | " + position[1][1] + " | " + position[1][2] + " ");
        System.out.println("   |   |   ");
        System.out.println("---+---+---");
        System.out.println("   |   |   ");
        System.out.println(" " + position[2][0] + " | " + position[2][1] + " | " + position[2][2] + " ");
        System.out.println("   |   |   ");
    }

    public static boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (position[i][0] == position[i][1] && position[i][0] == position[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (position[0][i] == position[1][i] && position[0][i] == position[2][i]) {
                return true;
            }
        }

        if (position[0][0] == position[1][1] && position[0][0] == position[2][2]) {
            return true;
        }
        if (position[0][2] == position[1][1] && position[0][2] == position[2][0]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int moveCount = 0;
        Scanner scanner = new Scanner(System.in);

        while (moveCount < 9) {
            if (player == 1) {
                x = 'X';
            } else {
                x = 'O';
            }
            printBoard();
            boolean validChoice = false;
            while (!validChoice) {
                System.out.print("Player " + player + " choose position: ");
                choice[moveCount] = scanner.nextInt();

                if (choice[moveCount] >= 1 && choice[moveCount] <= 9) {
                    int row = (choice[moveCount] - 1) / 3;
                    int col = (choice[moveCount] - 1) % 3;
                    if (position[row][col] != 'X' && position[row][col] != 'O') {
                        validChoice = true;
                    } else {
                        System.out.println("Position already taken. Choose again.");
                    }
                } else {
                    System.out.println("Invalid input. Choose a number between 1 and 9.");
                }
            }

            int row = (choice[moveCount] - 1) / 3;
            int col = (choice[moveCount] - 1) % 3;
            position[row][col] = x;

            if (checkWin()) {
                printBoard();
                System.out.println("Player " + player + " is the winner!");
                scanner.close();
                return;
            }
            player = (player == 1) ? 2 : 1;
            moveCount++;
        }

        System.out.println("It's a draw!");
        scanner.close();
    }
}