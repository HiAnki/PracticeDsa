package com.ankita;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        // Input: strs = ["eat","tea","tan","ate","nat","bat", "", "jhfkjdsh"]
        //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        // take input
        String[] input = getInput();

        List<List<String>> output = execute(input);

        printOutput(output);
    }

    private static void printOutput(List<List<String>> output) {
        for (List<String> list: output) {
            System.out.println(list);
        }
    }

    private static List<List<String>> execute(String[] input) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: input) {
            String hash = getHash(str);
            List<String> list = map.getOrDefault(hash, new ArrayList<>());
            list.add(str);
            map.put(hash, list);
        }

        return extractResult(map);
    }

    private static List<List<String>> extractResult(Map<String, List<String>> map) {
        List<List<String>> result = new ArrayList<>();
        for (List<String> list: map.values()) {
            result.add(list);
        }
        return result;
    }

    private static String getHash(String str) {

        if (str.isEmpty()) {
            return "empty";
        }

        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            int idx = curr - 'a';
            arr[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (arr[i] > 0) {
                char ch = (char) ('a' + i);
                sb.append(ch);
                sb.append(arr[i]);
                sb.append("-");
            }
        }
        return new String(sb);
    }

    private static String[] getInput() {
        Scanner sc = new Scanner(System.in);
        int inputSize = sc.nextInt();

        String[] arr = new String[inputSize];
        for (int i=0; i<inputSize; i++) {
//            arr[i] = sc.next();
//            System.out.println(arr[i]);
            arr[i] = "";
        }

        return arr;
    }
}