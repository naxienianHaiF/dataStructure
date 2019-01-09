package wjh.ds.binaryTree;


/*
 * 空子树的高度定义为-1
 */


public class Test {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		tree.add(41);
		tree.add(22);
		tree.add(33);
		tree.add(55);
		tree.add(18);
		tree.add(10);
		tree.add(8);
		tree.add(20);
		
//		System.out.println(tree.contains(18));
//		System.out.println(tree.findMin());
//		System.out.println(">>>>>");
//		tree.firstPrint();
//		System.out.println(">>>>>");
//		tree.secondPrint();
//		System.out.println(">>>>>");
//		tree.lastPrint();
		System.out.println(">>>>>");
		tree.levelPrint();
		System.out.println(">>>>>");
		tree.remove(18);
		tree.levelPrint();
	}
}
