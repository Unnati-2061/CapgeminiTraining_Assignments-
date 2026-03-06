package collections.arraylist;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListCrud {
	private static ArrayList<String> fruits;
	private static Scanner sc;

	public static void main(String[] args) {
		fruits = new ArrayList<>();
		sc = new Scanner(System.in);
		
		addFruits();
		System.out.println();
		printFruits();

		changeFruit();
		System.out.println();
		printFruits();
		
		removeFruit();
		System.out.println();
		printFruits();

		sc.close();
	}
	
	private static void addFruits() {
		System.out.print("How many fruits to add: ");
		int fruitsToAdd = sc.nextInt();
		
		System.out.println("Enter " + fruitsToAdd + " fruit names:");
		for(int i=0; i<fruitsToAdd; i++) {
			String fruit = sc.next();
			fruits.add(fruit.toLowerCase());
		}
	}
	
	private static void changeFruit() {
		System.out.print("Change fruit at index(1-based): ");
		int index = sc.nextInt();
		
		if (index < 1 || index > fruits.size()) {
			System.out.println("Invalid index");
			return;
		}
		
		System.out.print("To fruit: ");
		String otherFruit = sc.next();
		
		fruits.set(index-1, otherFruit.toLowerCase());
	}
	
	private static void removeFruit() {
		System.out.print("Delete fruit at index(1-based): ");
		int index = sc.nextInt();

		if (index < 1 || index > fruits.size()) {
			System.out.println("Invalid index");
			return;
		}
		
		fruits.remove(index-1);
	}
	
	private static void printFruits() {
		if (fruits.isEmpty()) {
			System.out.println("fruits: {}\n");
			return;
		}
		
		System.out.println("fruits: {");
		for(int i=0; i<fruits.size(); i++) {
			String fruit = fruits.get(i);

			System.out.print("  " + fruit);
			System.out.print(i == fruits.size()-1 ? "\n" : ",\n");
		}
		System.out.println("}\n");
	}
}
