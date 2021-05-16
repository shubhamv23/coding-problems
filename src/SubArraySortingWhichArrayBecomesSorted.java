public class SubArraySortingWhichArrayBecomesSorted {

	public static void main(String[] args) {
		int arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		printUnsorted(arr);
	}

	private static void printUnsorted(int[] arr) {

		int length = arr.length;
		int start = getStart(arr);
		int end = getEnd(arr);

		if (start == length - 1) {
			System.out.println("The complete array is sorted");
			return;
		}

		int max = arr[start];
		int min = arr[end];

		for (int i = start + 1; i <= end; i++) {
			max = Math.max(arr[i], max);
			min = Math.min(arr[i], min);
		}

		for (int i = 0; i < start; i++) {
			if (arr[i] > min) {
				start = i;
				break;
			}
		}

		for (int i = length - 1; i >= end + 1; i--) {
			if (arr[i] < max) {
				end = i;
				break;
			}

		}
		System.out.println(start + " " + end);
	}

	private static int getEnd(int[] arr) {
		int i = 0;
		for (i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1])
				return i;
		}
		return i;
	}

	private static int getStart(int[] arr) {
		int i = 0;
		for (i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return i;
			}
		}
		return i;
	}
}
