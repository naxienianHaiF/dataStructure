package wjh.sort;

public class BubbleSort {

	public static <T extends Comparable<? super T>> void sort(T[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		
		int len = arr.length;
		for (int i = 0; i < len-1; i++) {
			for (int j=i+1;j<len;j++) {
				if (arr[i].compareTo(arr[j]) > 0) {
					T temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
