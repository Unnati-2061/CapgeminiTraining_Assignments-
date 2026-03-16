package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SumSquareDigitsRepeatTest {
	private static SumSquareDigitsRepeat calculator;
	
	@BeforeAll
	static void setUpBeforeClass() {
		calculator = new SumSquareDigitsRepeat();
	}

	@ParameterizedTest
	@CsvSource({
		"1, 1",
		"16, 8",
		"14, -1",
		"4, 8",
		"2, -1",
		"10, -1",
		"37, 8"
	})
	void test(int input, int expected) {
		int actual = calculator.stepsToGetBackWithSumDigitSquares(input);
		assertEquals(expected, actual, "Failed at input: " + input);
	}
}
