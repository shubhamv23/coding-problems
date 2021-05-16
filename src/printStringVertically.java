import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class printStringVertically {
	public static void main(String[] args) {
		System.out.println(printVertically("TO BE OR NOT TO BE"));
		System.out.println(printVertically("CONTEST IS COMING"));
	}

	public static List<String> printVertically(String s) {
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
		return list;
	}

}
