package wjh.ds.binaryTree;

import java.util.Stack;
/**
 * ���������
 * @author WJH
 * @version 1.0
 */
public class BinarySearchTree {
	//root�ڵ�
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
	 * �����в���ֵ
	 * @param x ���������е�ֵ
	 */
	public void insert(int x){
		root=insert(x,root);
	}
	/**
	 * �ж������Ƿ��������x
	 * @param x ���жϵ�����
	 * @return ������д���x������true�����򷵻�false
	 */
	public boolean contains(int x){
		return contains(x,root);
	}
	/**
	 * �ҳ�������Сֵ
	 * @return ��Сֵ
	 * @throws Exception �����쳣
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
	 * ����������ݹ�˼�룩
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
	 * �ж����Ƿ�Ϊ��
	 */
	public boolean isEmpty(){
		return root==null;
	}
	/**
	 * �����
	 */
	public void makeEmpty(){
		root=null;
	}
	/**
	 * �ǵݹ鷽ʽ�������������
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
	 * �ǵݹ鷽ʽ�������������
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
	 * �Ƴ�����
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
	 * �������
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
	 * �������
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
	 * �ڵ�N�ĸ��Ǵӽڵ�N��һƬ��Ҷ���·���ĳ�,�ڵ�N�����(depth)Ϊ�Ӹ���N��Ψһ·���ĳ�
	 * @return �������ĸ�
	 */
	public int getHeight(){
		//�������Ϊ0
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
	 * @return ���ظ����
	 */
	public BinaryNode getRoot(){
		return root;
	}
	
}
