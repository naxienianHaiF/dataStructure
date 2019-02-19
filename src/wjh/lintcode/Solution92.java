package wjh.lintcode;

public class Solution92 {
	
	public static void main(String[] args) {
		Solution92 solution = new Solution92();
		int[] A= {3,4,8,5};
		int m=10;
		System.out.println(solution.backPack(m, A));
	}

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null) {
            return 0;
        }
        int len = A.length;
        //dp[i][j]表示前i个物品放入到容量为j的背包中的最大值
        int[][] dp = new int[len+1][m+1];
        
        for (int i=1;i<=len;i++) {
            for (int j=1;j<=m;j++) {
                if (A[i-1]<=j) {
                    //当第i个物品小于当前背包容量时候，第i个物品不放入背包的最大容量为dp[i-1][j]，
                    //第i个物品放入背包的最大容量为dp[i-1][j-A[i-1]]+A[i-1]
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-A[i-1]]+A[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }    
        }
        
        for (int i=0;i<=len;i++) {
        	for (int j=0;j<=m;j++) {
        		System.out.print(dp[i][j] + " ");
        	}
        	System.out.println();
        }
        return dp[len][m];
    }
}
