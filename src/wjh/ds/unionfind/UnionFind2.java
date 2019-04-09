package wjh.ds.unionfind;

/**
 * 
 * @author JHW
 * @version 2.0.0
 */
public class UnionFind2 implements UnionFind {

	private int[] parent;
	
	public UnionFind2(int size) {
		parent = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}
	
	@Override
	public int size() {
		return parent == null ? 0 : parent.length;
	}

	@Override
	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot) {
			return ;
		}
		
		parent[pRoot] = qRoot;
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	/**
	 * 	查询元素所属的集合（根节点）
	 * @param p 元素p
	 */
	private int find(int p) {
		if (p < 0 || p > parent.length) {
			throw new IllegalArgumentException("array index is out of bound.");
		}
		while (p != parent[p]) {
			p = parent[p];
		}
		return p;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < parent.length; i++) {
			if (i == parent.length - 1) {
				sb.append(parent[i]).append("]");
			} else {
				sb.append(parent[i]).append(",");
			}
		}
		return sb.toString();
	}
}
