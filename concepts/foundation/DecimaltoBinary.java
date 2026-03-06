package com.foundation;
import java.util.Stack;
import java.util.Scanner;

public class DecimalToBinary {
	public static Stack<Integer> st;

	public static void main(String[] args) {
		st = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a number to get its binary: ");
		int num = sc.nextInt();

		convertToBinary(num);
		
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
		
		sc.close();
	}
	
	public static void convertToBinary(int num) {
		int n = num;
		while (n != 0) {
			int rem = n%2;
			n /= 2;
			st.push(rem);
		}
	}
}
