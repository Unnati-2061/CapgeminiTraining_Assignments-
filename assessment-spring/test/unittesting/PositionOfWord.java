package unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionsOfWordTest {
	private final PositionsOfWord detector = new PositionsOfWord();

	@ParameterizedTest
	@MethodSource("provideGetWordPositionsArgument")
	void testGetWordPositions(String sentence, String word, List<Integer> expected) {
		List<Integer> actual = detector.getWordPositions(sentence, word);
		
		assertEquals(expected, actual,
					 "Failed for word '" + word + "' in sentence: " + sentence);
	}

	private static Stream<Arguments> provideGetWordPositionsArgument() {
		return Stream.of(
			Arguments.of("Java is fun", "Java", Arrays.asList(0)),
			
			Arguments.of("Java is fun and java is cool", "Java", Arrays.asList(0, 16)),
			
			Arguments.of("Training with Capgemini", "cap", Arrays.asList(14)),
			
			Arguments.of("Hello World", "Python", new ArrayList<Integer>()),
			
			Arguments.of("Apple Pineapple Pen", "apple", Arrays.asList(0, 6))
		);
	}
}
