package lexico_smallest_k_length_subsequence;

import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Driver {
	public static void main(String[] args) {
		System.out.println(findLexicographicallySmallestString("bbcaab", 3).equals("aab"));
		System.out.println(findLexicographicallySmallestString("aabdaabc", 3).equals("aaa"));
		System.out.println(findLexicographicallySmallestString("aabdaabcbbbbbbbbbbbbbbbbbbbbbcccccccccabababababcccccccaaabbbbbbbaaaa", 4).equals("aaaa"));
	}

	private static String findLexicographicallySmallestString(String input, int requiredLength) {
		int totalInputLength = input.length();
		Stack<Character> s = new Stack<>();
		s.add(input.charAt(0));

		IntStream.range(1, totalInputLength).forEach(currentPos -> {
			Character currentChar = input.charAt(currentPos);
			while (!s.isEmpty() &&
					currentChar < s.peek() &&
					checkIfEnoughCharRemainingForRequiredLength(s.size(), totalInputLength, requiredLength, currentPos)) {
				s.pop();
			}
			if (s.size() < requiredLength) {
				s.add(currentChar);
			}
		});

		return getStringFromStack(s);
	}

	private static boolean checkIfEnoughCharRemainingForRequiredLength(int currentIncludedLength, int totalInputLength, int requiredLength, int currentPos) {
		return currentIncludedLength + (totalInputLength - currentPos) - 1 >= requiredLength;
	}

	private static String getStringFromStack(Stack<Character> s) {
		String output = "";
		return s.stream()
				.map(c -> output + c)
				.collect(Collectors.joining());
	}

}
