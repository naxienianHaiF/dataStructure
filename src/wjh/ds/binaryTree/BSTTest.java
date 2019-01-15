package wjh.ds.binaryTree;

public class BSTTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(12);
		tree.add(8);
		tree.add(10);
		tree.add(5);
		tree.add(16);
		tree.add(13);
		
		System.out.println(tree.rank(1));
		System.out.println(tree.rank(2));
		System.out.println(tree.rank(3));
		System.out.println(tree.rank(4));
		System.out.println(tree.rank(5));
		System.out.println(tree.rank(6));
	}
}
