package com.ankita;

public class MaxIncreasingPath {

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};

        int[][] store = new int[matrix.length][matrix[0].length];
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int ans = 0;
//        ans = dfs(matrix, store, ans, 0, 0);

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
               ans = Math.max(ans, dfs(matrix, store, ans, i, j));
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                System.out.print(store[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(ans);
    }

    private static int dfs(int[][] matrix, int[][] store, int ans, int i, int j) {
        if (store[i][j] != 0) {
            return store[i][j];
        }

        int[] rowArr = {0, 0, -1, 1};
        int[] colArr = {-1, 1, 0, 0};

        int currentMax = 1;

        for (int k=0; k<4; k++) {
            int row = rowArr[k] + i;
            int col = colArr[k] + j;

            if (row >=0 && row < matrix.length && col >=0 && col < matrix[row].length && matrix[i][j] < matrix[row][col]) {
                currentMax = Math.max(currentMax, 1 + dfs(matrix, store, ans, row, col));
            }
        }

        store[i][j] = currentMax;
        return currentMax;
    }
}
