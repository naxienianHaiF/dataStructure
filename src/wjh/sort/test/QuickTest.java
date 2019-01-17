package wjh.sort.test;

import org.junit.Test;

import wjh.sort.QuickSort;

public class QuickTest {

	@Test
	public void test () {
		QuickSort<Integer> sort = new QuickSort<>();
		Integer[] arr = {12,6,4,4,3,5,13};
		sort.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
