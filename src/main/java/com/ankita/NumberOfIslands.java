package com.ankita;

public class NumberOfIslands {

    public static void main(String[] args) {


    }

    // time m*n
    // space m*n --> if make the visited 1 to 0, space is O(1)

    private int function(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int ans = 0;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (!visited[i][j] && matrix[i][j] == '1') {
                    dfs(i, j, matrix, visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] matrix, boolean[][] visited) {
        visited[i][j] = true;

        int[] row = {1, 0, -1, 0};
        int[] col = {0, -1, 0, 1};

        for (int dir=0; dir<4; dir++) {
            int r = i+row[dir];
            int c = j+col[dir];
            if (i+row[dir] >= 0 && i+row[dir] < matrix.length && j+col[dir] >=0 && j+col[dir] < matrix[0].length) {
                if (!visited[r][c] && matrix[r][c] == '1') {
                    dfs(r, c, matrix, visited);
                }
            }
        }
    }
}
