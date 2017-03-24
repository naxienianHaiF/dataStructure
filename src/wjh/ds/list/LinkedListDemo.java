package wjh.ds.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 
 */
public class LinkedListDemo {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<6;i++){
			list.add(i);
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println();
		for(Integer in:list)
			System.out.print(in+" ");
	}
}
