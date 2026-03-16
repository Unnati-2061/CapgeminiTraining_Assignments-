package lambdaexp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

class Employee {
	private int eid;
	private String ename;
	
	public Employee(int empID, String empName) {
		eid = empID;
		ename = empName;
	}
	
	public int getEmpID() { return eid; }
	public String getEmpName() { return ename; }
	
	public String getEmpIDJson() {
		return "emp_id: " + eid;
	}
	
	public String getEmpNameJson() {
		return "emp_name: " + ename;
	}
	
	public String toJson() {
		return "employee: {\n"
			 + "  " + getEmpIDJson() + ",\n"
			 + "  " + getEmpNameJson()
			 + "\n}";
	}
}

public class LambdaExpressionBasic {
	public static void main(String[] args) {
		Function<String, String> getFirst2Uppercase = new Function<>() {
			@Override
			public String apply(String s) {
				return s.substring(0,2)
						.toUpperCase();
			}
		};
		
		System.out.println(getFirst2Uppercase.apply("Devansh Seth"));
		
		
		// class<Supplier> imported from java.util.function.Supplier
		Supplier<Integer> supplier = new Supplier<>() {
			@Override
			public Integer get() {
				return new Random().nextInt(400);
			}
		};
		
		Random random = new Random();
		supplier = () -> random.nextInt(400);
		for(int i=1; i<=10; i++)
			System.out.println(supplier.get());
		
		// it'll call random.nextInt() when someone calls supplier.get()
		supplier = random::nextInt();
		
		Predicate<String> pred = new Predicate<>() {
			@Override
			public boolean test(String s) {
				return s.length()>=10;
			}
		};
		
		// or in shorter way
		pred = (str) -> str.length() >= 10;
		
		Integer[] arr = {
			34, 46, 23, 57, 66, 34, 456, 798, 10, 555
		};
		
		List<Integer> intList = new ArrayList<>();
		
		intList.addAll(Arrays.asList(arr));
		intList.removeIf((num) -> num>100);
		
		System.out.println("Elements greater than 100:");
		intList.forEach(
			(num) -> System.out.println(num)
		);
	}
}
