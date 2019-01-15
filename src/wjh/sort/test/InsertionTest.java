package wjh.sort.test;

import org.junit.Test;

import wjh.sort.InsertionSort;

public class InsertionTest {

	@Test
	public void insertSort() {
		InsertionSort<Integer> sort = new InsertionSort<>();
		Integer[] arr= {3,2,14,6,5,8};
		sort.sort(arr);
		for (Integer i:arr) {
			System.out.println(i);
		}
	}
}
