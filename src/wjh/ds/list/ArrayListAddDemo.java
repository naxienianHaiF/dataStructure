package wjh.ds.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListAddDemo {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(0);
		list.add(1);
		//list.add(3, 3); 这个不可行
		list.add(2, 2);
		list.add(3);
		list.add(9);
		list.add(4);
		list.add(5);
		
		System.out.println(list.size());
		for(Integer i:list)
			System.out.print(i+" ");
		
		Collections.sort(list);
		System.out.println();
		for(Integer i:list)
			System.out.print(i+" ");
		
		System.out.println();
		list.remove(4);
		list.remove(new Integer(3));
		for(Integer i:list)
			System.out.print(i+" ");
		System.out.println();
	}
}
