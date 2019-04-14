package wjh.ds.unionfind;

import java.util.Random;

/**
 * 
 * @author JHW
 *
 */
public class UnionFindTest {

	public static void main(String[] args) {
		int size = 100000;
		int m = 100000;
		
		UnionFind find1 = new UnionFind1(size);
		UnionFind find2 = new UnionFind2(size);
		
		System.out.println("UnionFind1: "+test(find1, m));
		System.out.println("UnionFind2: "+test(find2, m));
	}
	
	private static double test(UnionFind find, int m) {
		int size = find.size();
		Random random = new Random();
		
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			find.union(a, b);
		}
		
		for (int i = 0; i < m; i++) {
			int a = random.nextInt(size);
			int b = random.nextInt(size);
			find.isConnected(a, b);
		}
		
		long endtime = System.currentTimeMillis();
		return (endtime - starttime)/1000.0;
	}
}
