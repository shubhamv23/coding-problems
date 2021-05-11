package vertical_representation_of_words;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Driver {
	public static void main(String[] args) {
		System.out.println(getVerticalRepresentationOfWords("HOW ARE YOU").equals("HAY, ORO, WEU"));
		System.out.println(getVerticalRepresentationOfWords("CONTEST IS COMING").equals("CIC, OSO, N M, T I, E N, S G, T"));
	}

	public static String getVerticalRepresentationOfWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		String[] words = s.split(" ");
		List<String> list = new ArrayList<>();
		int maxLength = 0;
		for (String word : words) {
			maxLength = Math.max(maxLength, word.length());
		}

		IntStream.range(0, maxLength).forEach(i -> {
			StringBuilder sb = new StringBuilder();
			for (String word : words) {
				int len = word.length();
				if (i < len) {
					sb.append(word.charAt(i));
				} else {
					sb.append(" ");
				}
			}
			list.add(sb.toString().stripTrailing());
		});
		return String.join(", ", list);
	}
}

