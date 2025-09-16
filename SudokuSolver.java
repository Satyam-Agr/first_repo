package first_repo;

import java.util.Scanner;

public class SudokuSolver {

    // size of the sudoku
    private static final int SIZE = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[SIZE][SIZE];

        System.out.println("Enter the Sudoku puzzle (9 lines of 9 digits, 0 for empty):");
        for (int i = 0; i < SIZE; i++) {
            String line = sc.next();
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        if (solveSudoku(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }
        sc.close();
    }

    // backtracking solver
    private static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) { // empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // place the number
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // no valid number
                }
            }
        }
        return true; // no empty cell found -> solved
    }

    // check if placing num is valid
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // check row
        for (int j = 0; j < SIZE; j++) {
            if (board[row][j] == num) return false;
        }
        // check column
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) return false;
        }
        // check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    // print the sudoku grid
    private static void printBoard(int[][] board) {
        for (int i = 0; i < SIZE; i++) {
        	if(i==3||i==6){
        		for (int j = 0; j < SIZE+2; j++) {
                    System.out.print("-");
                }
        		System.out.println();
        	}
            for (int j = 0; j < SIZE; j++) {
            	if(j==3||j==6)
            		System.out.print("|");
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

