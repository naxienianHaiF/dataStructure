package wjh.ds.binaryTree;

import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<? super E>> {

	private class Node{
		E value;
		Node left;
		Node right;
		
		public Node(E val) {
			value = val;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int size ;
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	/**
	 * get tree numbers
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * add value to BinarySearchTree
	 * @param val value
	 */
	public void add(E val) {
		root = add(root,val);
	}

	private Node add(Node root, E val) {
		if (root == null) {
			size++;
			return new Node(val);
		}
		int result = val.compareTo(root.value);
		if (result < 0) {
			root.left = add(root.left, val);
		}else if (result > 0) {
			root.right = add(root.right, val);
		}else {
			return root;
		}
		
		return root;
	}
	
	public boolean contains(E val) {
		return contains(root,val);
	}

	private boolean contains(Node root, E val) {
		if (root == null) {
			return false;
		}
		if (val.compareTo(root.value) > 0) {
			return contains(root.right, val);
		}else if (val.compareTo(root.value) < 0) {
			return contains(root.left, val);
		}else {
			return true;
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void makeEmpty() {
		root = null;
		size=0;
	}
	/**
	 * Search min value
	 * @return min value
	 */
	public E findMin() {
		return findMin(root)== null ? null : findMin(root).value;
	}
	private Node findMin(Node root) {
		if (root == null) {
			return null;
		}else if (root.left == null) {
			return root;
		}
		return findMin(root.left);
	}
	/**
	 * Search max value
	 * @return max value
	 */
	public E findMax() {
		return findMax(root);
	}
	private E findMax(Node root) {
		if (root == null) {
			return null;
		}else if(root.right == null){
			return root.value;
		}
		return findMax(root.right);
	}
	
	/**
	 * first print
	 */
	public void firstPrint() {
		first(root);
	}
	private void first(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.value);
		first(root.left);
		first(root.right);
	}
	/**
	 * second print (can use order)
	 */
	public void secondPrint() {
		second(root);
	}
	private void second(Node root) {
		if (root == null) {
			return;
		}
		second(root.left);
		System.out.println(root.value);
		second(root.right);
	}
	
	public void lastPrint() {
		lastPrint(root);
	}
	private void lastPrint(Node root) {
		if (root == null) {
			return;
		}
		lastPrint(root.left);
		lastPrint(root.right);
		System.out.println(root.value);
	}
	/**
	 * level print 
	 */
	public void levelPrint() {
		levelPrint(root);
	}
	private void levelPrint(Node root) {
		if (root == null) {
			return;
		}
		LinkedList<Node> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()) {
			Node ret = list.poll();
			if (ret == null) {
				continue;
			}
			System.out.println(ret.value);
			list.add(ret.left);
			list.add(ret.right);
		}
	}
	
	public E removeMin() {
		E result = findMin();
		root = removeMin(root, result);
		return result;
	}
	private Node removeMin(Node root, E val) {
		if (root.left == null) {
			Node rightNode = root.right;
			root.right = null;
			size--;
			return rightNode;
		}
		root.left = removeMin(root.left, val);
		return root;
	}
	
	public E removeMax() {
		E result = findMax();
		root = removeMax(root, result);
		return result;
	}
	private Node removeMax(Node root, E val) {
		if (root.right == null) {
			Node leftNode = root.left;
			root.left = null;
			size--;
			return leftNode;
		}
		root.right = removeMin(root.right, val);
		return root;
	}
	
	/**
	 * remove from binary search tree
	 * @param val the item to remove
	 */
	public void remove(E val) {
		root = remove(root,val);
	}
	/**
	 * remove from binary search tree
	 * @param val the item to remove 
	 */
	public void remove2(E val) {
		root = remove2(root,val);
	}
	private Node remove(Node root, E val) {
		if (root == null) {
			return root;
		}
		
		int reuslt = val.compareTo(root.value);
		if (reuslt>0) {
			root.right = remove(root.right, val);
		} else if (reuslt <0) {
			root.left = remove(root.left, val);
		} else if (root.left != null && root.right != null) {
			Node minNode = findMin(root.right);
			minNode.right = removeMin(root.right, minNode.value);
			minNode.left = root.left;
			root.left = root.right = null;
			return minNode;
		} else {
			if (root.left == null) {
				Node rightNode = root.right;
				root.right = null;
				size--;
				return rightNode;
			}
			if (root.right == null) {
				Node leftNode = root.left;
				root.left = null;
				size--;
				return leftNode;
			}
		}
		return root;
	}
	
	private Node remove2(Node root, E val) {
		if (root == null) {
			return root;
		}
		
		int reuslt = val.compareTo(root.value);
		if (reuslt>0) {
			root.right = remove2(root.right, val);
		} else if (reuslt <0) {
			root.left = remove2(root.left, val);
		} else if (root.left != null && root.right != null) {
			root.value = findMin(root.right).value;
			root.right = remove2(root.right, root.value);
		} else {
			root = (root.left != null) ?
					root.left : root.right;
			size--;
		}
		return root;
	}
	
	/**
	 * binary search tree rank<br />
	 *  查找二叉树中第k大（中文读起来有点拗口）的数据 ，也可以用中序遍历
	 */
	public E rank(int k) {
		return rank(root,k);
	}
	
	private E rank(Node root, int k) {
		if (k < 1 || root == null) {
			return null;
		}
		
		int leftCount = getCount(root.left);
		if (leftCount < k) {
			if (leftCount+1 == k) {
				return root.value;
			} else {
				if (getCount(root.right) < k-(leftCount+1)) {
					return null;
				}
				return rank(root.right, k-(leftCount+1));
			}
		} else {
			return rank(root.left, k);
		}
	}
	
	private int getCount(Node node) {
		if (node == null) {
			return 0;
		}
		
		return getCount(node.left)+getCount(node.right)+1;
	}
}
