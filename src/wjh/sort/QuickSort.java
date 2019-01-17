package wjh.sort;

/**
 *  quick sort
 * @author JHW
 *
 * @param <E>
 */
public class QuickSort<E extends Comparable<? super E>> {

	public  void sort(Object[] arr) {
		if (arr != null && arr.length > 0) {
			quickSort(arr, 0, arr.length-1);
		}
	}
	
	private void quickSort(Object[] arr,int l,int r) {
		if (l>r) {
			return;
		}
		
		int low = l;
		int high = r;
		E key = (E)arr[low];
		
		while (low<high) {
			//从右往左找到第一个小于key的数
			while(low<high && ((E)arr[high]).compareTo(key) >0) {
				high--;
			}
			//从左往右找到第一个大于key的数
			while(low<high && ((E)arr[low]).compareTo(key) <=0) {
				low++;
			}
			if (low<high) {
				Object temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
			}
		}
		
		Object temp = arr[low];
		arr[low] = key;
		arr[l] = temp;
		
		quickSort(arr, l, low-1);
		quickSort(arr, low+1, r);
	}
}
