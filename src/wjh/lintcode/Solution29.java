package wjh.lintcode;

/**
 * https://www.lintcode.com/problem/interleaving-string/description
 * 
 * @author JHW
 *
 */
public class Solution29 {

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		Solution29 solution = new Solution29();
		System.out.println(">>>>>>");
		System.out.println(solution.isInterleave(s1, s2, s3));
		System.out.println("=======");
		System.out.println(solution.two(s1, s2, s3));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		int len1 = s1.length() + 1;
		int len2 = s2.length() + 1;
		boolean[][] dp = new boolean[len2][len1];
		dp[0][0] = true;

		//s1 表示列
		for (int i = 1; i < len1; i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]) {
				dp[0][i] = true;
			}
		}
		//s2表示行
		for (int j = 1; j < len2; j++) {
			if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[j - 1][0]) {
				dp[j][0] = true;
			}
		}

		for (int i = 1; i < len1; i++) {
			for (int j = 1; j < len2; j++) {
				if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[j][i-1])
						|| (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[j-1][i])) {
					dp[j][i] = true;
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		return dp[s2.length()][s1.length()];
	}

	public boolean two(String s1, String s2, String s3) {

		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;

		for (int i = 1; i <= s1.length(); i++) {
			if (s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0])
				dp[i][0] = true;
		}

		for (int j = 1; j <= s2.length(); j++) {
			if (s3.charAt(j - 1) == s2.charAt(j - 1) && dp[0][j - 1])
				dp[0][j] = true;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (((s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]))
						|| ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && dp[i][j - 1]))
					dp[i][j] = true;
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		return dp[s1.length()][s2.length()];
	}
}
