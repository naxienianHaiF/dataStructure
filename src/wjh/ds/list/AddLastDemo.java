package wjh.ds.list;

import java.util.LinkedList;

public class AddLastDemo {

	public static void main(String[] args) {
		LinkedList<Integer> list=new LinkedList<Integer>();
		LinkedList<Integer> list1=new LinkedList<Integer>();
		for(int i=0;i<5;i++){
			list.addFirst(i);
			list1.addLast(i);
		}
		System.out.print("addFirst ");
		for(Integer i:list){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.print("addLast  ");
		for(Integer i:list1){
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("wjh".charAt(0));
	}
}
