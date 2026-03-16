package unittesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PositionsOfWord {
	public List<Integer> getWordPositions(String sentence, String word) {
		if (sentence == null) new ArrayList<>();

		List<Integer> pos = new ArrayList<>();
		Scanner sc = new Scanner(sentence);
		
		int index = 0;
		while(sc.hasNext()) {
			String s = sc.next().toLowerCase();
			word = word.toLowerCase();

			if (s.contains(word))
				pos.add(index);

			index += s.length()+1;
		}
		
		sc.close();

		return pos;
	}
}
