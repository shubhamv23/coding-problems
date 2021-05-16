import java.util.Arrays;

public class MinJumpToReachLast {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 0, 1, 4 };
		System.out.println(jump(arr));
	}

	public static int jump(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			int furthest = i + nums[i];
			for (int j = i + 1; j <= Math.min(nums.length - 1, furthest); j++) {
				dp[j] = Math.min(dp[i] + 1, dp[j]);
			}
		}
		return dp[dp.length - 1];
	}
}
