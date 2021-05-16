import java.util.Arrays;

public class MinimumNumberOfPlatformRequired {

	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = arr.length;
		System.out.println("Minimum Number of Platforms Required = " + findPlatform(arr, dep, n));
	}

	static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int platNeeded = 1;
		int result = 1;
		int i = 1;
		int j = 0;

		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				platNeeded++;
				i++;
			} else {
				platNeeded--;
				j++;
			}
			result = Math.max(platNeeded, result);
		}

		return result;
	}
}
