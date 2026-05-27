package com.ankita;

import java.util.HashSet;
import java.util.Stack;

public class ValidParenthisis {
    public static void main(String[] args) {
        String str = "([)]";
        boolean ans = execute(str);
        System.out.println(ans);
    }

    private static boolean execute(String str) {
        if (str.length() <= 1) {
            return false;
        }


        Stack<Character> stack = new Stack<>();

        for (char ch: str.toCharArray()) {
            if(isOpenBracket(ch)) {
                stack.add(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
}
