package strings;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import stringques.StringAlgo;

class StringAlgoTest {
	@BeforeAll
	public static void beforeAll() {
		// connect to database here
		// make a chat connection here
		// create websocket here
		
		System.out.println("Before all the tests db connection");
	}
	
	@AfterAll
	public static void afterAll() {
		// close the connection of database here
		System.out.println("After all the tests close db connection");
	}
	
	@BeforeEach
	public void beforeEachTestCase() {
		System.out.println("Before each test clear cache, insert data, remove data, add collection");
	}
	
	@AfterEach
	public void afterEachTestCase() {
		System.out.println("After each test clear cache, insert data, remove data, add collection");
	}

	@Test
	@DisplayName("Check if the input string of length > 2 is correctly shifting first 2 characters at the end of the string")
	void shiftCharsToLastTestCase1() {
		StringAlgo algo = new StringAlgo();
		String input = "Hello";
		String expected = "lloHe";
		String recieved = algo.shiftCharsToLast(input, 2);
		
		assertEquals(expected, recieved);
	}
	
	@Test
	@DisplayName("Check if the input string of length = 2 is correctly shifting first 2 characters at the end of the string")
	void shiftCharsToLastTestCase2() {
		StringAlgo algo = new StringAlgo();
		String input = "ab";
		String expected = "ab";
		String recieved = algo.shiftCharsToLast(input, 2);
		
		assertEquals(expected, recieved);
	}

	@Test
	@DisplayName("Check whether we're getting `StringIndexOutOfBoundsException` if we give an input string of length < 2")
	void shiftCharsToLastTestCase3() {
		StringAlgo algo = new StringAlgo();
		String input = "a";

	    assertThrows(StringIndexOutOfBoundsException.class,
	    			 () -> algo.shiftCharsToLast(input, 2));

	}
	
	@Test
	@DisplayName("Check whether we're getting `NullPointerException` if we give a null input string")
	void shiftCharsToLastTestCase4() {
		StringAlgo algo = new StringAlgo();
		String input = null;

	    Exception exception = assertThrows(NullPointerException.class,
	    								   () -> algo.shiftCharsToLast(input, 2));

	    String expected = "Input string cannot be null";
	    String recieved = exception.getMessage();
	    
	    assertTrue(recieved.contains(expected));
	}
	
	@Test
	@Timeout(value = 1,
			 unit = TimeUnit.SECONDS)
	@DisplayName("Check whether the algo is working in 1-second timelimit")
	void fromDBTest() {
		StringAlgo obj = new StringAlgo();
		String expected = "From DB value recieved";
		String actual = obj.getFromDB();
		assertEquals(expected, actual);
	}
}
