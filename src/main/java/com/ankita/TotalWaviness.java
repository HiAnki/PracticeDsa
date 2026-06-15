package com.ankita;

public class TotalWaviness {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 48;

        int ans = execute(num1, num2);

        System.out.println(ans);
    }

    private static int execute(int num1, int num2) {
        int result = 0;

        for (int i = num1; i<= num2; i++) {
            result += getWaviness(i);
        }

        return result;
    }

    private static int getWaviness(int i) {
        String str = i + "";
        if (str.length() < 3) {
            return 0;
        }

        int result = 0;

        for (int j = 1; j < str.length() - 1; j++) {
            int current = getIntValue(str.charAt(j));
            int prev = getIntValue(str.charAt(j-1));
            int next = getIntValue(str.charAt(j+1));

            if ((current < prev && current < next) || (current > prev && current > next)) {
                result++;
            }
        }
        return result;
    }

    private static int getIntValue(char c) {
        return c - '0';
    }
}
