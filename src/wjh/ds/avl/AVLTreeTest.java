package wjh.ds.avl;

public class AVLTreeTest {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();
		int[] arr = {41,22,55,66,20,32,24};
//		test1(tree,arr);
		test2(tree, arr,20);
	}
	
	private static void test1(AVLTree<Integer> tree,int[] arr) {
		for (Integer i: arr) {
			tree.add(i);
			print(tree);
		}
	}
	
	private static void test2(AVLTree<Integer> tree, int[] arr,int k) {
		for (Integer i: arr) {
			tree.add(i);
		}
		tree.levelPrint();
		System.out.println("======================");
		tree.remove(k);
		print(tree);
		
	}
	
	private static void print(AVLTree<Integer> tree) {
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
	}
}
