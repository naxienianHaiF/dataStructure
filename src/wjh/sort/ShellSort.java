package wjh.sort;

public class ShellSort<E extends Comparable<? super E>> {

	public void sort(Object[] arr) {
		
		int j,len = arr.length;
		for (int gap = len/2; gap>0; gap /= 2) {
			for (int i=gap;i<len;i++) {
				E temp = (E) arr[i];
				for (j=i;j>=gap && temp.compareTo((E) arr[j-gap]) <0;j-=gap) 
					arr[j] = arr[j-gap];
				arr[j] =temp;
			}
		}
	}
}
