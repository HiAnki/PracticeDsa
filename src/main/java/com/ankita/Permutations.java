package com.ankita;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
    }

    private static void recursion(List<List<Integer>> result, int[] nums, int start) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.col - b.col);
    }
}
