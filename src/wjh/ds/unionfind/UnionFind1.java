package wjh.ds.unionfind;

import java.util.Arrays;

/**
 * @author JHW
 * @version 1.0.0
 */
public class UnionFind1 implements UnionFind {

	private int[] id;
	
	public UnionFind1(int size) {
		id = new int[size];
		for (int i=0;i<size;i++) {
			id[i] = i;
		}
	}
	
	@Override
	public int size() {
		return id == null ? 0 :id.length;
	}

	@Override
	public void union(int p, int q) {
		int pId = find(p);
		int qId = find(q);
		
		if (pId == qId) {
			return;
		}
		
		for (int i=0;i<id.length;i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
	}

	@Override
	public boolean isConnected(int p, int q) {
		return find(p) == find(q);
	}
	
	private int find(int p) {
		if (p<0 || p>=id.length) {
			throw new IllegalArgumentException("array index is out of bound.");
		}
		return id[p];
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < id.length; i++) {
			if (i == id.length - 1) {
				sb.append(id[i]).append("]");
			} else {
				sb.append(id[i]).append(",");
			}
		}
		return sb.toString();
	}
}
