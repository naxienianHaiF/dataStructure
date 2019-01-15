package wjh.sort;

public class InsertionSort<E extends Comparable<? super E>> {
	
	public void sort(Object[] arr) {
		
		int j;
		for (int i=1; i<arr.length; i++) {
			E temp = (E)arr[i];
			for(j=i; j>0 && temp.compareTo((E)arr[j-1]) <0; j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = temp;
		}
	}
	
}
