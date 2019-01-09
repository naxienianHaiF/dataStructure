package wjh.ds.queue;

import java.util.Random;

public class MaxHeapTest {

	public static void main(String[] args) {
		int n = 1000;
		MaxHeap<Integer> heap = new MaxHeap<>(Integer.class,n);
		Random random = new Random();
		for (int i=0;i<n;i++) {
			heap.add(random.nextInt(3*n));
		}
		
		int[] arr = new int[n];
		for (int i=0; i<n ;i++) {
			arr[i] = heap.extractMax();
			System.out.println(arr[i]);
		}
		
		for (int i=1;i<n;i++) {
			if (arr[i-1]<arr[i]) {
				throw new IllegalArgumentException("...");
			}
		}
		System.out.println("max heap success...");
	}
}
