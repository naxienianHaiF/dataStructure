package wjh.ds.avl;

import java.util.LinkedList;

/**
 * AVL树
 * 	<br />对于任意一个节点，左子树和右子树的高度差不能超过1.
 * @author JHW
 */
public class AVLTree<E extends Comparable<? super E>> {

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
					root = rotateWithRightChild(root);
				} else {
					root = doubleWithLeftChild(root);
				}
			}
		} else if (compareResult >0) {
			root.right = add(root.right, val);
			if (height(root.right) - height(root.left) == 2) {
				if (val.compareTo(root.right.val) > 0) {
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
	
	public E findMin() {
		return findMin(root);
	}
	
	private E findMin(Node<E> root) {
		if (root == null) {
			return null;
		} else if (root.left == null) {
			return root.val;
		}
		return findMin(root.left);
	}

	/**
	 * 	对节点y进行右旋转 <br />
	 * 			y                       x     
	 * 		   / \                    /   \   
	 * 		  x  T4            右旋转                                 z    y     
	 *       / \      ------>       /  \  /  \    
	 *      z  T3                  T1  T2 T3 T4
 	 *     / \                                         
	 *    T1 T2
	 */
	private Node<E> rotateWithRightChild(Node<E> node) {
		Node<E> temp = node.left;
		node.left = temp.right;
		temp.right = node;
		
		node.height = Math.max(height(node.left), height(node.right))+1;
		temp.height = Math.max(height(temp.left), node.height)+1;
		
		return temp;
	}
	
	/**
	 *          y                           x
	 *         / \                         / \
	 *        T1  x       左旋转                                     y  z
	 *           / \    -------->        / \  \
	 *          T2  z                   T1 T2 T3
	 *               \
	 *               T3
	 *           
	 * rotate binary tree node with left child.
	 * <br />For AVL tree, this is a single rotation for case one.
	 * Update heights, then return new root.
	 */
	private Node<E> rotateWithLeftChild(Node<E> node) {
		Node<E> temp = node.right;
		node.right = temp.left;
		temp.left = node;
		  
		node.height = Math.max(height(node.left), height(node.right))+1;
		temp.height = Math.max(height(temp.left), node.height)+1;
		
		return temp;
	}
	
	/**
	 * 	双旋转RL(先进行右旋转，再进行左旋转)。
	 * @param node
	 * @return
	 */
	private Node<E> doubleWithRightChild(Node<E> node) {
		node.right = rotateWithRightChild(node.right);
		return rotateWithLeftChild(node);
	}
	
	/**
	 * 	双旋转LR(先进行左旋转，再进行右旋转)。
	 * @param node
	 * @return
	 */
	private Node<E> doubleWithLeftChild(Node<E> node) {
		node.left = rotateWithLeftChild(node.left);
		return  rotateWithRightChild(node);
	}
	
	/**
	 * remove element
	 * @param val remove element which value is val
	 */
	public void remove(E val) {
		root = remove(root, val);
	}
	
	private Node<E> remove(Node<E> root, E val) {
		if (root == null) {
			return root;
		}
		
		Node<E> temp ;
		int result = val.compareTo(root.val);
		if (result > 0) {
			root.right = remove(root.right, val);
			temp = root;
		} else if (result < 0) {
			root.left = remove(root.left, val);
			temp = root;
		} else if (root.left != null && root.right != null) {
			root.val = findMin(root.right);
			root.right = remove(root.right, root.val);
			temp = root;
		} else {
			root = (root.left != null) ?
					root.left : root.right;
			temp = root;
			size--;
		}
		if (temp== null) {
			return null;
		}
		
		//维护节点的平衡性
		temp.height = Math.max(height(temp.left), height(temp.right))+1;
		int balanceFactor = getBalanceFactor(temp);
		
		if (balanceFactor > 1 && getBalanceFactor(temp.left) >=0) {
			return rotateWithRightChild(temp);
		}
		
		if (balanceFactor < -1 && getBalanceFactor(temp.right) <=0) {
			return rotateWithLeftChild(temp);
		}
		
		if (balanceFactor > 1 && getBalanceFactor(temp.left) <0) {
			return doubleWithLeftChild(temp);
		}
		
		if (balanceFactor < -1 && getBalanceFactor(temp.right) >0) {
			return doubleWithRightChild(temp);
		}
		
		return temp;
	}

	private int getBalanceFactor(Node<E> root) {
		return root == null ? 0 : height(root.left) - height(root.right);
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
		return root.toString();
	}
}
