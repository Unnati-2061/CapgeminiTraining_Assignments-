package collections.arraylist;

import java.util.ArrayList;

public class FoodBucketCrud {
	public static ArrayList<String> foodBucket;

	public static void main(String[] args) {
		foodBucket = new ArrayList<>();

		addFood();
		printFood();

		foodBucket.remove("Kadhai Paneer");
		printFood();
		
		foodBucket.clear();
		printFood();
		
		System.out.println("Is Bucket empty: " +
							(foodBucket.isEmpty() ? "true" : "false"));
		
		addFood();
		System.out.print("Contains Kadhai Paneer: ");
		boolean isPresent = foodBucket.contains("Kadhai Paneer");
		System.out.println(isPresent ? "true" : "false");
	}
	
	private static void addFood() {
		foodBucket.add("Pastry");
		foodBucket.add("Malai Kofta");
		foodBucket.add("Kadhai Paneer");
		foodBucket.add("Pani-Puri");
		foodBucket.add("Matar-Khasta");
	}
	
	private static void printFood() {
		if (foodBucket.isEmpty()) {
			System.out.println("favourite_foods: {}\n");
			return;
		}

		System.out.println("favourite_foods: {");
		for(int i=0; i<foodBucket.size(); i++) {
			System.out.print("  " + foodBucket.get(i));
			System.out.print(i == foodBucket.size()-1 ? "\n" : ",\n");
		}
		System.out.println("}\n");
	}
}
