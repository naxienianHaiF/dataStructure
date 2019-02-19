package wjh.lintcode;

/**
 * https://www.lintcode.com/problem/minimum-path-sum/description
 * @author JHW
 *	 给定一个只含非负整数的m*n网格，找到一条从左上角到右下角的
 *	可以使数字和最小的路径。
 */
public class Solution110 {
	
	public static void main(String[] args) {
//		int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		int[][] grid = new int[][] {{1,2},{1,1}};
		Solution110 solution = new Solution110();
		System.out.println(solution.minPathSum(grid));
	}

    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
    	if (grid == null) {
    		return 0;
    	}
    	
    	int row = grid.length;
    	int column = grid[0].length;
    	System.out.println("row = "+ row +" ,column = "+ column);
    	//dp[i][j]表示 到(i,j)的最短路径
    	int[][] dp = new int[row][column];
    	dp[0][0] = grid[0][0];
    	
    	for (int i=1;i<row;i++) {
    		dp[i][0] = dp[i-1][0]+grid[i][0];
    	}
    	
    	for (int j=1;j<column;j++) {
    		dp[0][j] = dp[0][j-1] + grid[0][j];
    	}
    	
    	for (int i=1;i<row;i++) {
    		for (int j=1;j<column;j++) {
    			dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
    		}
    	}
    	
    	
    	for (int i=0;i<row;i++) {
    		for (int j=0;j<column;j++) {
    			System.out.print(dp[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println(">>>>>>>>");
    	return dp[row-1][column-1];
    }
}
