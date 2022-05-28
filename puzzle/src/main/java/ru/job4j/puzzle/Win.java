package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1 && (monoVertical(board, i) || monoHorizontal(board, i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        for (int cell = 0; cell < board[row].length; cell++) {
            if (board[row][cell] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean monoVertical(int[][] board, int column) {
        for (int[] ints : board) {
            if (ints[column] != 1) {
                return false;
            }
        }
        return true;
    }
}
