package wjh.ds.list;

import java.util.ArrayList;
import java.util.List;

/*
 * remove
 */
public class RemoveList {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<=6;i++)
			list.add(i);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		System.out.println();
		list.remove(0);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		System.out.println();
		list.remove(1);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		System.out.println();
	}
}
