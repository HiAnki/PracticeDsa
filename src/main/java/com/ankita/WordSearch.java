package com.ankita;

public class WordSearch {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i=0; i<board.length; i++) {
            for (int j = 0; j<board[i].length; j++) {
                if (dfs(i, j, board, visited, word, new StringBuilder())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int startRow, int startCol, char[][] board, boolean[][] visited, String word, StringBuilder currentPath) {
        if (visited[startRow][startCol]) {
            return false;
        }
        visited[startRow][startCol] = true;

        currentPath.append(board[startRow][startCol]);

        if (word.equals(currentPath.toString())) {
            return true;
        }

        int[] row = {1, -1, 0 ,0};
        int[] col = {0, 0, -1, 1};

        for (int i=0; i<4; i++) {
            int nbrRow = startRow + row[i];
            int nbrCol = startCol + col[i];

            if (nbrRow >=0 && nbrRow < board.length && nbrCol >= 0 && nbrCol < board[0].length) {
                boolean result = dfs(nbrRow, nbrCol, board, visited, word, currentPath);
                if (result) {
                    return result;
                }
            }
        }

        visited[startRow][startCol] = false;
        currentPath.deleteCharAt(currentPath.length() - 1);

        return false;
    }
}
