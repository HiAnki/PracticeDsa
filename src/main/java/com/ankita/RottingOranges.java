package com.ankita;

import java.util.ArrayDeque;
import java.util.Queue;

class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

// time = m*n
// space = m*n

public class RottingOranges {

    public static void main(String[] args) {
        int[][] matrix = {{2,1,1}, {1,1,0}, {0,1,1}};

        int ans = execute(matrix);
        System.out.println(ans);
    }

    private static int execute(int[][] matrix) {

        int time = 0;

        boolean isAnyFreshOrange = false;

        Queue<Pair> queue = new ArrayDeque<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 2) {
                    queue.add(new Pair(i,j));
                } else if (matrix[i][j] == 1) {
                    isAnyFreshOrange = true;
                }
            }
        }

        if (queue.isEmpty()) {
            return isAnyFreshOrange ? -1 : 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            time++;
            while (size != 0) {
                Pair current = queue.poll();

                int row = current.row;
                int col = current.col;

                // top
                if (row > 0 && matrix[row-1][col] == 1) {
                    matrix[row-1][col] = 2;
                    queue.add(new Pair(row-1, col));
                }

                // left
                if (col > 0 && matrix[row][col-1] == 1) {
                    matrix[row][col-1] = 2;
                    queue.add(new Pair(row, col-1));
                }

                // bottom
                if (row < matrix.length - 1 && matrix[row+1][col] == 1) {
                    matrix[row+1][col] = 2;
                    queue.add(new Pair(row+1, col));
                }

                //right
                if (col < matrix[0].length - 1 && matrix[row][col+1] == 1) {
                    matrix[row][col+1] = 2;
                    queue.add(new Pair(row, col+1));
                }

                size--;

            }
        }

        time--;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}
