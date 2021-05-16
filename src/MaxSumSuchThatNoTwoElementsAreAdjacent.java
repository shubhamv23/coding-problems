/*

Loop for all elements in arr[] and maintain two sums incl and excl
where incl = Max sum including the previous element and excl = Max sum excluding the previous element.
Max sum excluding the current element will be max(incl, excl) and max sum including the current element will be excl + current element
(Note that only excl is considered because elements cannot be adjacent).
At the end of the loop return max of incl and excl.

*/

public class MaxSumSuchThatNoTwoElementsAreAdjacent {

	public static void main(String[] args) {
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		System.out.println(findMaxSum(arr, arr.length));
	}

	public static int findMaxSum(int arr[], int n) {
		int incl = arr[0];
		int excl = 0;
		int exclNew = 0;
		for (int i = 1; i < n; i++) {
			System.out.println(incl + " " + excl + " " + exclNew);
			exclNew = Math.max(incl, excl);
			incl = excl + arr[i];
			excl = exclNew;
		}
		System.out.println(incl + " " + excl + " " + exclNew);

		return Math.max(incl, excl);
	}
}
