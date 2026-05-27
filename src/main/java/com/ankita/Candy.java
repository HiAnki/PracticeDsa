package com.ankita;

public class Candy {

    public static void main(String[] args) {
        int[] input = {1,2,1,3,5,6,4};

        int ans = execute(input);

        System.out.println(ans);
    }

    private static int execute(int[] input) {
        int sum = 1;
        int i = 1;

        while (i < input.length) {

            // slope is flat
            if (input[i] == input[i - 1]) {
                sum += 1; i++; continue;
            }

            int peak = 1;
            // slope is increasing
            while (i < input.length && input[i] > input[i-1]) {
                peak++; sum += peak; i++;
            }

            // slope decreasing
            int down = 1;
            while (i < input.length && input[i] < input[i-1]) {
                sum += down; down++; i++;
            }

            if(down > peak) {
                sum += down - peak;
            }
        }
        return sum;
    }
}
