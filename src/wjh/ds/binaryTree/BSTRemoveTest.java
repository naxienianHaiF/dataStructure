package wjh.ds.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSTRemoveTest {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		Random random = new Random();
		int count = 100;
		for(int i=0;i<count;i++) {
			bst.add(random.nextInt(count));
		}
		List<Integer> list = new ArrayList<>();
		while (!bst.isEmpty()) {
			list.add(bst.removeMin());
		}
		
		System.out.println(list);
		System.out.println(bst.isEmpty());
		System.out.println(bst.size());
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i-1).compareTo(list.get(i))>0) {
				throw new IllegalArgumentException("Error");
			}
		}
		System.out.println("remove mim number is right...");
	}
}
