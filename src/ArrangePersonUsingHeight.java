import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrangePersonUsingHeight {
	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		System.out.println(Arrays.toString(reconstructQueue(people)));
	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (c1, c2) -> {
			if (c1[0] == c2[0]) {
				return c1[1] - c2[1];
			} else {
				return c2[0] - c1[0];
			}
		});

		for (int i = 0; i < people.length; i++) {
			for (int j = 0; j < people[0].length; j++) {
				System.out.print(people[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("--------------------");

		List<int[]> res = new ArrayList<>();
		for (int[] person : people) {
			System.out.println(person[1] + " " + Arrays.toString(person));
			res.add(person[1], person);
		}

		System.out.println("--------------------");
		return res.toArray(new int[1][1]);
	}
}
