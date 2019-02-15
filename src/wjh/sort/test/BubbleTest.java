package wjh.sort.test;

import org.junit.Test;

import wjh.sort.BubbleSort;


public class BubbleTest {

	@Test
	public void bubbleSort() {
//		BubbleSort sort = new BubbleSort();
		Integer[] arr= {3,2,14,5,6,5,8};
//		sort.sort(arr);
		BubbleSort.sort(arr);
		for (Integer i:arr) {
			System.out.println(i);
		}
	}
}
