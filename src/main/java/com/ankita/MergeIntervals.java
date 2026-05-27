package com.ankita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = execute(intervals);

        for (int[] interval: result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    private static int[][] execute(int[][] intervals) {
        // sort intervals
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                result.add(current);
                current = next;
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
