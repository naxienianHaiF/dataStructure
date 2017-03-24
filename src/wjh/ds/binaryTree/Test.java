package wjh.ds.binaryTree;

import wjh.ds.binaryTree.BinarySearchTree.BinaryNode;

/*
 * �������ĸ߶ȶ���Ϊ-1
 */


public class Test {

	public static void main(String[] args) throws Exception {
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(10);
		bst.insert(20);
		bst.insert(5);
		bst.insert(40);
		bst.insert(3);
		bst.insert(8);
		bst.insert(9);
		bst.insert(7);
		bst.insert(12);
		bst.insert(17);
		
		bst.rootFirst();
		bst.rootFirst();
		
		System.out.println(Test.isBalance(bst.getRoot()));
		
//		System.out.println("height:"+bst.getHeight());
//		System.out.println(isBalance(bst.getRoot()));
//		bst.remove(12);
//		bst.RootFirst();
//		bst.RootSecont();
//		bst.preOrderUnRecur();
//		bst.inOrderUnRecur();
//		System.out.println();
//		System.out.println("min:"+bst.findMin());
//		System.out.println("30:"+bst.contains(30));
//		bst.makeEmpty();
//		System.out.println(bst.isEmpty());
	}
	/**
	 * �ж϶������Ƿ�Ϊƽ�������
	 * @param bn ����ڵ�
	 * @return   ���Ϊƽ����������򷵻�true�����򷵻�false
	 */
	public static boolean isBalance(BinaryNode bn){
		boolean[] res=new boolean[1];
		res[0]=true;
		getheight(bn,1,res);
		return res[0];
	}
	private static int getheight(BinaryNode bn,int level,boolean[] res){
		if(bn==null)
			return level;
		int lH=getheight(bn.left, level+1, res);
		if(!res[0])
			return level;
		int rH=getheight(bn.right, level+1, res);
		if(!res[0])
			return level;
		if(Math.abs(lH-rH)>1)
			res[0]=false;
		return 0;
	}
}
