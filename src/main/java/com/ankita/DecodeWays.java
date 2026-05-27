package com.ankita;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "11106";
        int[] store = new int[s.length()];
        Arrays.fill(store, -1);
        System.out.println(dp(store, s,0));
    }

    private static int recursion(String s) {
        if (s.isEmpty()) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int firstCharPath = recursion(s.substring(1));

        int firstTwoCharPath = 0;
        char first = s.charAt(0);
        char second = s.charAt(1);

        if (first == '1' || (first == '2' && second <= '6')) {
            firstTwoCharPath = recursion(s.substring(2));
        }

        return firstCharPath + firstTwoCharPath;
    }

    private static int dp(int[] store, String s, int startIdx) {
        if (s.isEmpty()) {
            return 1;
        }

        if (store[startIdx] != -1) {
            return store[startIdx];
        }

        if (s.charAt(0) == '0') {
            store[startIdx] = 0;
            return 0;
        }

        if (s.length() == 1) {
            store[startIdx] = 1;
            return 1;
        }

        int firstCharPath = dp(store, s.substring(1), startIdx+1);

        int firstTwoCharPath = 0;
        char first = s.charAt(0);
        char second = s.charAt(1);

        if (first == '1' || (first == '2' && second <= '6')) {
            firstTwoCharPath = dp(store, s.substring(2), startIdx+2);
        }

        store[startIdx] = firstCharPath + firstTwoCharPath;

        return store[startIdx];

    }
}
