package unittesting;

import java.util.HashSet;
import java.util.Set;

public class SumSquareDigitsRepeat {
	public int stepsToGetBackWithSumDigitSquares(int n) {
		/*
		 * Write a program to find the sum of square of digits of a number until you find
		 * the same number back. If same number is never reachable print -1 else print
		 * the number of times square should be done and sum to be calculated.
		 * 
		 * 16: => 37 => 58 => 89 => 145 => 42 => 20 => 4 => 16
		 * 		Answer : 8
		 * 14: => 17 => 50 => 25 => 29 => 85 => 89 => 145 => 42 => 20 => 4 => 16 => 37 => 48 => 89
		 * 		Never Reachable, Answer: -1
		 * 
		 * Read an integer > 0 and calculate steps and print steps.
		 * 
		 * Write the code and write parameterized test case for this (@ParameterizeTest)
		 */
		
		if (n <= 0) return -1;

        int current = n;
        int steps = 0;
        Set<Integer> visited = new HashSet<>();

        while (true) {
        	current = getSumOfSquareOfDigits(current);
        	steps++;

        	if (current == n) return steps;

        	if (visited.contains(current))
        		return -1;

        	visited.add(current);
        }
	}
	
	private int getSumOfSquareOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += (digit * digit);
            num /= 10;
        }

        return sum;
    }
}
