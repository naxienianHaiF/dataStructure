package wjh.ds.unionfind;

/**
 * 并查集
 * @author JHW
 * @version 0.0.1
 */
public interface UnionFind {

	int size();
	/**
	 *  合并元素p和元素q所属的集合，元素p的集合合并到元素q的集合中
	 */
	void union(int p, int q);
	/**
	 * 	查看元素p和q是否属于同一个集合
	 */
	boolean isConnected(int p, int q);
}
