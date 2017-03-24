package wjh.ds.binaryTree;

public class WJHTest {

	public static void main(String[] args){
		first();
	}
	
	private static void first(){
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(10);
		bst.insert(9);
		bst.insert(6);
		bst.insert(5);
		bst.insert(7);
		bst.insert(14);
		bst.insert(12);
		bst.insert(15);
		
		bst.rootFirst();
		bst.rootLast();
		bst.rootFirst();
	}
}
