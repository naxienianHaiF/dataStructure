package wjh.ds.binaryTree;

import java.util.Stack;
/**
 * 二叉查找树
 * @author WJH
 * @version 1.0
 */
public class BinarySearchTree {
	//root节点
	private BinaryNode root;
	
	class BinaryNode {
		int element;
		BinaryNode left;
		BinaryNode right;
		//Constructors
		BinaryNode(int theElement){
			this(theElement,null,null);
		}
		BinaryNode(int theElement,BinaryNode lt,BinaryNode rt){
			element=theElement;
			left=lt;
			right=rt;
		}
	}
	/**
	 * 向树中插入值
	 * @param x 待插入树中的值
	 */
	public void insert(int x){
		root=insert(x,root);
	}
	/**
	 * 判断树中是否存在数据x
	 * @param x 待判断的数据
	 * @return 如果树中存在x，返回true，否则返回false
	 */
	public boolean contains(int x){
		return contains(x,root);
	}
	/**
	 * 找出树中最小值
	 * @return 最小值
	 * @throws Exception 空树异常
	 */
	public int findMin() throws Exception{
		if(isEmpty())
			throw new Exception("Not exist number.");
		return findMin(root).element;
	}
	private BinaryNode findMin(BinaryNode bn){
		if(bn==null)
			return null;
		else if(bn.left==null)
			return bn;
		return findMin(bn.left);
	}
	private boolean contains(int x,BinaryNode bn){
		if(bn==null)
			return false;
		if(x<bn.element)
			return contains(x,bn.left);
		else if(x>bn.element)
			return contains(x,bn.right);
		else
			return true;
	}
	private BinaryNode insert(int x,BinaryNode t){
		if(t==null)
			return new BinaryNode(x, null, null);
		if(x>t.element)
			t.right=insert(x,t.right);
		else if(x<t.element)
			t.left=insert(x,t.left);
		else
			;
		return t;
	}
	/**
	 * 先序遍历（递归思想）
	 */
	public void rootFirst(){
		if(root==null)
			System.out.println("Empty tree");
		else
			rootFirst(root);
		System.out.println();
	}
	private void rootFirst(BinaryNode bn){
		System.out.print(bn.element+" ");
		if(bn.left!=null)
			rootFirst(bn.left);
		if(bn.right!=null)
			rootFirst(bn.right);
	}
	/**
	 * 判断树是否为空
	 */
	public boolean isEmpty(){
		return root==null;
	}
	/**
	 * 清空树
	 */
	public void makeEmpty(){
		root=null;
	}
	/**
	 * 非递归方式先序遍历二叉树
	 */
	public void preOrderUnRecur(){
		System.out.println("pre-order");
		if(root!=null){
			if(root!=null){
				Stack<BinaryNode> stack=new Stack<>();
				stack.add(root);
				while(!stack.isEmpty()){
					root=stack.pop();
					System.out.print(root.element+" ");
					if(root.right!=null)
						stack.push(root.right);
					if(root.left!=null)
						stack.push(root.left);
				}
			}
		}
		System.out.println();
	}
	/**
	 * 非递归方式中序遍历二叉树
	 */
	public void inOrderUnRecur(){
		System.out.println("in-order:");
		if(root!=null){
			Stack<BinaryNode> stack=new Stack<>();
			while(!stack.isEmpty() || root!=null){
				if(root!=null){
					stack.push(root);
					root=root.left;
				}else{
					root=stack.pop();
					System.out.print(root.element+" ");
					root=root.right;
				}
			}
		}
	}
	/**
	 * 移除数据
	 * @param x
	 */
	public void remove(int x){
		root=remove(x,root);
	}
	private BinaryNode remove(int x,BinaryNode t){
		if(t==null)
			return t;
		if(x<t.element)
			t.left=remove(x, t.left);
		else if(x>t.element)
			t.right=remove(x, t.right);
		else if(t.left!= null && t.right!=null){
			t.element=findMin(t.right).element;
			t.right=remove(t.element, t.right);
		}else
			t=(t.left!=null)? t.left : t.right;
		return t;
	}

	/**
	 * 中序遍历
	 */
	public void rootSecont(){
		rootSecont(root);
		System.out.println();
	}
	private void rootSecont(BinaryNode bn){
		if(bn==null)
			return ;
		rootSecont(bn.left);
		System.out.print(bn.element+" ");
		rootSecont(bn.right);
	}
	/**
	 * 后序遍历
	 */
	public void rootLast(){
		if(root==null)
			System.out.println("Empty tree");
		else
			rootLast(root);
		System.out.println();
	}
	private void rootLast(BinaryNode bn){
		if(bn.left!=null)
			rootLast(bn.left);
		if(bn.right!=null)    
			rootLast(bn.right);
		System.out.print(bn.element+" ");
	}
	
	/**
	 * 节点N的高是从节点N到一片树叶的最长路径的长,节点N的深度(depth)为从根到N的唯一路劲的长
	 * @return 二叉树的高
	 */
	public int getHeight(){
		//跟的深度为0
		return getHeight(root)-1;
	}
	private int getHeight(BinaryNode bn){
		if(bn==null)
			return 0;
		else{
			int left=getHeight(bn.left);
			int right=getHeight(bn.right);
			return Math.max(left, right)+1;
		}
	}
	/**
	 * 
	 * @return 返回跟结点
	 */
	public BinaryNode getRoot(){
		return root;
	}
	
}
