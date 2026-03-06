package com.foundation;
import java.util.Scanner;

public class Information {
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		System.out.print("Enter roll : ");
		int rollNo = sc.nextInt();
		
		System.out.print("Enter name : ");
		String firstName = sc.next();
		String lastName = sc.next();
		String name = firstName + " " + lastName;
		
		System.out.println("\nInformation :");
		System.out.println("roll : " + rollNo);
		System.out.println("Name : " + name);
		
		sc.close();
	}
	
	private static Scanner sc;
}
