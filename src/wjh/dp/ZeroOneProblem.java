package wjh.dp;

/**
 * https://www.cnblogs.com/lfeng1205/p/5981198.html
 * @author JHW
 *
 */
public class ZeroOneProblem {

	public static void main(String[] args) {
		int m = 10;
		int w[] = { 3, 4, 5 };
//        int n = 3;
		int n = w.length;
		int p[] = { 3, 4, 5 };
		int c[][] = BackPack_Solution(m, n, w, p);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(c[i][j] + "\t");
				if (j == m) {
					System.out.println();
				}
			}
		}
	}

	/**
	 * @param m ��ʾ�������������
	 * @param n ��ʾ��Ʒ����
	 * @param w ��ʾ��Ʒ��������
	 * @param p ��ʾ��Ʒ��ֵ����
	 */
	public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
		// c[i][v]��ʾǰi����Ʒǡ����һ������Ϊm�ı������Ի�õ�����ֵ
		int c[][] = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// ����ƷΪi������Ϊjʱ�������i��������(w[i-1])С������jʱ��c[i][j]Ϊ�����������֮һ��
				// (1)��Ʒi�����뱳���У�����c[i][j]Ϊc[i-1][j]��ֵ
				// (2)��Ʒi���뱳���У��򱳰�ʣ������Ϊj-w[i-1],����c[i][j]Ϊc[i-1][j-w[i-1]]��ֵ���ϵ�ǰ��Ʒ
				if (w[i - 1] < j) {
					c[i][j] = Math.max(c[i - 1][j], c[i - 1][j - w[i - 1]] + p[i - 1]);
				} else {
					c[i][j] = c[i - 1][j];
				}
			}
		}

		return c;
	}
}
