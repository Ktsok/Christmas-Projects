package gr.aueb.cf.javaProjects;

import java.io.IOException;
import java.util.Scanner;

public class Project4 {
    public static void main(String[] args) {

        boolean isFirstPlayerPlaying = true;
        boolean isGameOver = false;
        boolean isInputValid = false;
        int currentPlayer = 1;
        int[][] board = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int column = 0;

        while (!isGameOver) {
            try {
                isInputValid = false;
                while (!isInputValid) {
                    if (isFirstPlayerPlaying) {
                        System.out.println("Ο πρώτος παίκτης να εισάγει γραμμή");
                        row = scanner.nextInt();
                        System.out.println("Ο πρώτος παίκτης να εισάγει στήλη");
                        column = scanner.nextInt();
                    } else {
                        System.out.println("Ο δεύτερος παίκτης να εισάγει γραμμή");
                        row = scanner.nextInt();
                        System.out.println("Ο δεύτερος παίκτης να εισάγει στήλη");
                        column = scanner.nextInt();
                    }
                    if (row < 0 || row > 2 || column < 0 || column > 2 || board[row][column] > 0) {
                        System.out.println("Η εισαγωγή δεν είναι έγκυρη, προσπαθείστε ξανά");
                    } else {
                        if (isFirstPlayerPlaying) {
                            board[row][column] = 1;
                        } else {
                            board[row][column] = 2;
                        }
                        isInputValid = true;
                    }
                }

//                  if (isFirstPlayerPlaying) {
//                      currentPlayer = 1;
//                  }else {
//                      currentPlayer = 2;
//                  }

                System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2]);

                if (board[0][0] == board[0][1] && board[0][1] == board[0][2] ||
                        board[1][0] == board[1][1] && board[1][1] == board[1][2] ||
                        board[2][0] == board[2][1] && board[2][1] == board[2][2] ||
                        board[0][0] == board[1][0] && board[1][0] == board[2][0] ||
                        board[1][0] == board[1][1] && board[1][1] == board[1][2] ||
                        board[2][0] == board[2][1] && board[2][1] == board[2][2] ||
                        board[0][0] == board[1][1] && board[1][1] == board[2][2] ||
                        board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
                    if (isFirstPlayerPlaying) {
                        System.out.println("Ο πρώτος παίκτης κέρδισε!");
                    } else {
                        System.out.println("Ο δεύτερος παίκτης κέρδισε!");
                    }
                    isGameOver = true;
                } else {
                    boolean isBoardFilled = true;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (board[i][j] != 1 && board[i][j] != 2) {
                                isBoardFilled = false;
                            }
                        }
                    }
                    if (isBoardFilled) {
                        isGameOver = true;
                        System.out.println("Κέρδισε το άθλημα");
                    }
                }

                isFirstPlayerPlaying = !isFirstPlayerPlaying;
            } catch (Exception exception) {
                System.out.println("Πρόβλημα κατά την εισαγωγλή δεδομένων");
            }
        }
    }
}
