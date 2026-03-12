package com.foundation;

import java.util.*;

public class ReversePolishExpression {

    public static int precedence(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/' || c == '%')
            return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    public static void reversepolish(String input) {
        Stack<Character> s = new Stack<>();
        String ans = "";

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if ((c >= '0' && c <= '9') ||
            	(c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z')) ans += c;
            else if (c == '(') s.push(c);
            else if (c == '+' || c == '-' || c == '*'
                    || c == '/' || c == '^' || c == '%') {
                while (!s.isEmpty() &&
                	   precedence(c) <= precedence(s.peek()))
                    ans += s.pop();
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(')
                    ans += s.pop();
                s.pop();
            }
        }

        while (!s.isEmpty())
            ans += s.pop();

        System.out.println("Result: " + ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the input Expression");
        String input = sc.nextLine();
        reversepolish(input);
        sc.close();
    }
}
