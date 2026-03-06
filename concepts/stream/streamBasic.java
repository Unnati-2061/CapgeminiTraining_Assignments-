package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamBasic {
	public static void main(String[] args) {
		List<Integer> list = List.of(23, 23, 25, 34, 65, 4, 46, 78, 54, 23, 56, 7, 65, 43);
		Stream<Integer> stream = list.stream();
		
		boolean allMatch = stream.allMatch(x -> x>=40);
		System.out.println("isAllGreaterThan40: " + allMatch);
		
		boolean anyMatch = list.stream().anyMatch(x -> x>=75);
		System.out.println("isAnyAbove75: " + anyMatch);
		System.out.println("streamCount: " + list.stream().count());
		
		System.out.println("DISTINCT elements:");
		list.stream()
			.distinct()
			.forEach(System.out::println);

		list.stream()
			.filter(x -> x>=40)
			.forEach(System.out::println);
		
		Stream<Integer> filter = list.stream()
								 	 .filter(x -> x>=40);
		
		// will give any integer as there are multiple threads running
		Optional<Integer> any = filter.findAny();

		System.out.println("Passed");
		list.stream()
			.filter(x -> x>=40)
			.map(x -> x/10.0)
			.forEach(System.out::println);
			
		Integer[] arr = {234, 43, 45, 6, 65, 45, 67, 654, 34, 576, 5654};
		Stream<Integer> arrStream = Arrays.stream(arr);
	}
}
