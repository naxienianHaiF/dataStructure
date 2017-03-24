package wjh.ds.list;

public class MyLinkedList {
	//constructors
	public MyLinkedList(){
		
	}
	/**
	 * 
	 * @param i 索引值
	 * @param value 待插入的数据
	 */
	public MyLinkedList(int i,int value){
		
	}
	
	class Node{
		//存储在节点中的元素
		private int data;
		//在链表中引用下一个结点
		private Node next;
		public Node(){
		}
		public Node(int x,Node n){
			data=x;
			next=n;
		}
	}
	
	private Node head=null;
	private int length=0;
	
	public void add(int x){
		head=new Node(x,head);
		length++;
	}
	public int remove(){
		@SuppressWarnings("unused")
		Node oldNode=head;
		int result=head.data;
		head=head.next;
		oldNode=null;
		length--;
		return result;
	}
	public int getSize(){
		return length;
	}
	/**
	 * 遍历链表
	 */
	public void play(){
		if(isEmpty()){
			System.out.println("Empty list");
			return;
		}
		int[] d=new int[length];
		for(int i=0;i<length;i++){
			d[length-1-i]=head.data;
			head=head.next;
		}
		for(int i:d)
			System.out.print(i+" ");
	}
	/**
	 * 清空链表
	 */
	public void clear(){
		length=0;
	}
	/**
	 * @return 链表为空返回true，否则返回false
	 */
	public boolean isEmpty(){
		return length==0;
	}
}
