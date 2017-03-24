package wjh.ds.list;

public class MyLinkedList {
	//constructors
	public MyLinkedList(){
		
	}
	/**
	 * 
	 * @param i ����ֵ
	 * @param value �����������
	 */
	public MyLinkedList(int i,int value){
		
	}
	
	class Node{
		//�洢�ڽڵ��е�Ԫ��
		private int data;
		//��������������һ�����
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
	 * ��������
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
	 * �������
	 */
	public void clear(){
		length=0;
	}
	/**
	 * @return ����Ϊ�շ���true�����򷵻�false
	 */
	public boolean isEmpty(){
		return length==0;
	}
}
