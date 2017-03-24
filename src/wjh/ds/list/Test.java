package wjh.ds.list;

public class Test {
	public static void main(String[] args) {
		MyLinkedList ll=new MyLinkedList();
		ll.add(12);
		ll.add(13);
		ll.add(3);
		ll.add(5);
		System.out.println(ll.remove());
		System.out.println("长度"+ll.getSize());
		ll.play();
		ll.clear();
		System.out.println();
		System.out.println("清空链表");
		ll.play();
		System.out.println(ll.isEmpty());
	}
}
