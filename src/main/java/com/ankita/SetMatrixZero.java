package com.ankita;

import java.util.Arrays;
import java.util.HashSet;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matirx = {{1,1,1}, {1,0,1}, {1,1,1}};

        execute(matirx);

        for (int i = 0; i < matirx.length; i++) {
            for (int j = 0; j < matirx[i].length; j++) {
                System.out.print(matirx[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void execute(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (Integer r: row) {
            Arrays.fill(matrix[r],0);
        }

        for (Integer c: col) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][c] = 0;
            }
        }
    }
}
