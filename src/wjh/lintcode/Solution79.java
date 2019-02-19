package wjh.lintcode;

public class Solution79 {

	
	public static void main(String[] args) {
		Solution79 solution = new Solution79();
		String A = "ABCD";
		String B = "AD";
		System.out.println(solution.longestCommonSubstring(A, B));
	}
	
	public int longestCommonSubstring(String A, String B) {
		int a = A.length();
		int b = B.length();
		//Dp[i][j] 表示A的前i个字符与B的前j个字符中，且以
		//第i个和第j个为结尾的公共子串的长度。暴力枚举所有的结尾。
		int[][] dp = new int[a+1][b+1];
		
		for (int i=1;i<=a;i++) {
			for (int j=1;j<=b;j++) {
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				} else {
//					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					dp[i][j] = 0;
				}
			}
		}

        int max = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                max = Math.max(max, dp[i][j]);
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(">>>>>");
		return max;
	}
}
