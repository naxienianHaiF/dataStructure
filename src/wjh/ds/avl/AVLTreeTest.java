package wjh.ds.avl;

public class AVLTreeTest {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();
		tree.add(6);
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
		tree.add(5);
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
		tree.add(4);
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
		tree.add(3);
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
		tree.add(2);
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		System.out.println(">>>>>>");
		tree.add(1);
		tree.levelPrint();
		System.out.println(tree.toString());
		System.out.println("size = "+tree.size());
		
	}
}
