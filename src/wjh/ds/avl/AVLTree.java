package wjh.ds.avl;

import java.util.LinkedList;

/**
 * AVL树
 * 	<br />对于任意一个节点，左子树和右子树的高度差不能超过1.
 * @author JHW
 */
public class AVLTree<E extends Comparable<? super E>> {

	@SuppressWarnings("hiding")
	class Node<E> {
		E val;
		Node<E> left;
		Node<E> right;
		int height;
		
		public Node(E val) {
			this(val, null, null);
		}
		
		public Node(E val,Node<E> left,Node<E> right) {
			this.val = val;
			this.left = left;
			this.right = right;
			this.height = 0;
		}
		
		@Override
		public String toString() {
			return "[val="+this.val+", height="+height+
					", left="+left+", right="+right+"]";
		}
	}
	
	public Node<E> root;
	@SuppressWarnings("unused")
	private Object[] data;
	private int size;
	private static int CAPACITY = 16;
	
	public AVLTree() {
		this(CAPACITY);
	}
	
	public AVLTree(int size) {
		root = null;
		data = new Object[size];
	}
	/**
	 * @return return the AVL tree size
	 */
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private int height(Node<E> node) {
		return node == null ? -1 : node.height;
	}
	
	public void add(E val) {
		root = add(root,val);
	}

	private Node<E> add(Node<E> root, E val) {
		if (root == null) {
			size++;
			return new Node<E>(val, null, null);
		}
		
		int compareResult = val.compareTo(root.val);
		if (compareResult<0) {
			root.left = add(root.left, val);
			if (height(root.left) - height(root.right) == 2) {
				if (val.compareTo(root.left.val) < 0) {
					root = rotateWithLeftChild(root);
				} else {
					root = doubleWithRightChild(root);
				}
			}
		} else if (compareResult >0) {
			root.right = add(root.right, val);
			if (height(root.right) - height(root.left) == 2) {
				if (val.compareTo(root.right.val) < 0) {
					root = rotateWithLeftChild(root);
				} else {
					root = doubleWithRightChild(root);
				}
			}
		} else {
			
		}
		
		root.height = Math.max(height(root.left), height(root.right))+1;
		return root;
	}
	
	/**
	 * Search max value
	 * @return max value
	 */
	public E findMax() {
		return findMax(root);
	}
	
	private E findMax(Node<E> root) {
		if (root == null) {
			return null;
		}else if(root.right == null){
			return root.val;
		}
		return findMax(root.right);
	}
	
	/**
	 * rotate binary tree node with left child.
	 * <br />For AVL tree, this is a single rotation for case one.
	 * Update heights, then return new root.
	 */
	private Node<E> rotateWithLeftChild(Node<E> node) {
		Node<E> temp = node.left;
		node.left = temp.right;
		temp.right = node;
		node.height = Math.max(height(node.left), height(node.right))+1;
		temp.height = Math.max(height(temp.left), node.height)+1;
		
		return temp;
	}
	
	private Node<E> doubleWithRightChild(Node<E> node) {
		node.left = rotateWithLeftChild(node.left);
		return rotateWithLeftChild(node);
	}
	
	/**
	 * level print层序遍历
	 */
	public void levelPrint() {
		if (root == null) {
			return ;
		}
		LinkedList<Node<E>> list = new LinkedList<>();
		list.add(root);
		while (!list.isEmpty()) {
			Node<E> temp = list.poll();
			System.out.println(temp.val);
			if (temp.left != null) {
				list.add(temp.left);
			}
			if (temp.right != null) {
				list.add(temp.right);
			}
		}
	}
	
	@Override
	public String toString() {
		return "the root value = "+root.val+"."+root.toString();
	}
}
