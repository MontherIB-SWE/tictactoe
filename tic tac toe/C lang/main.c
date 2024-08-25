#include <stdio.h>
#include <Windows.h>

int position[3][3] = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
int player = 1, choice[9];
char x;

void printBoard() {
    printf("   |   |   \n");
    printf(" %c | %c | %c \n", position[0][0], position[0][1], position[0][2]);
    printf("   |   |   \n");
    printf("______________\n");
    printf("   |   |   \n");
    printf(" %c | %c | %c \n", position[1][0], position[1][1], position[1][2]);
    printf("   |   |   \n");
    printf("______________\n");
    printf("   |   |  \n");
    printf(" %c | %c | %c \n", position[2][0], position[2][1], position[2][2]);
    printf("   |   |   \n");
}

int checkWin() {

    for (int i = 0; i < 3; i++) {
        if (position[i][0] == position[i][1] && position[i][0] == position[i][2]) {
            return 1; 
        }
    }

    for (int i = 0; i < 3; i++) {
        if (position[0][i] == position[1][i] && position[0][i] == position[2][i]) {
            return 1; 
        }
    }

    if (position[0][0] == position[1][1] && position[0][0] == position[2][2]) {
        return 1; 
    }
    if (position[0][2] == position[1][1] && position[0][2] == position[2][0]) {
        return 1; 
    }

    return 0; 
}

int main() {
    int moveCount = 0; 


    while (moveCount < 9) { 
        if (player == 1) {
            x = 'X';
        } else {
            x = 'O';
        }
            printBoard();

        int validChoice = 0;
        while (!validChoice) {
            printf("Player %d choose position: ", player);
            scanf("%d", &choice[moveCount]);

            if (choice[moveCount] >= 1 && choice[moveCount] <= 9) {
                int row = (choice[moveCount] - 1) / 3;
                int col = (choice[moveCount] - 1) % 3;
                if (position[row][col] != 'X' && position[row][col] != 'O') {
                    validChoice = 1;
                } else {
                    printf("Position already taken. Choose again.\n");
                }
            } else {
                printf("Invalid input. Choose a number between 1 and 9.\n");
            }
        }

        int row = (choice[moveCount] - 1) / 3;
        int col = (choice[moveCount] - 1) % 3;
        position[row][col] = x;

        

        system("cls");

        if (checkWin()) {
            
            printBoard();
            printf("Player %d is the winner!\n", player); 
            return 0;
        }
        player = (player == 1) ? 2 : 1; 
        moveCount++;
    }

    printf("It's a draw!\n");
    return 0;
}