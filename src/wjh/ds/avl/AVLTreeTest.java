package wjh.ds.avl;

public class AVLTreeTest {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();
		int[] arr = {9,12,10};
		test1(tree,arr);
	}
	
	private static void test1(AVLTree<Integer> tree,int[] arr) {
		for (Integer i: arr) {
			tree.add(i);
			tree.levelPrint();
			print(tree);
		}
	}
	
	private static void print(AVLTree<Integer> tree) {
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
	}
}
