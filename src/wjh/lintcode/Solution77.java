package wjh.lintcode;

/**
 * https://www.lintcode.com/problem/longest-common-subsequence/description
 * @author JHW
 *
 */
public class Solution77 {

	public int longestCommonSubsequence(String A, String B) {
		if (A == null || B == null) {
			return 0;
		}
		
		int a = A.length();
		int b = B.length();
		
		int[][] dp = new int[a+1][b+1];
		for (int i=1;i<=a;i++) {
			for (int j=1;j<=b;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
			}
		}
		
		return dp[a][b];
	}
}
