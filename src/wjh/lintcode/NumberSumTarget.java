package wjh.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberSumTarget {

	public static void main(String[] args) {
		int[] arr = new int[] {2,7,5,4,3,1,8,6};
		System.out.println(hasNumber(arr, 9));
		hasIndex(arr, 9);
	}
	
	public static boolean hasNumber(int[] arr, int target) {
		if (arr== null || arr.length <2) {
			return false;
		}
		
		Set<Integer> set = new HashSet<>();
		for (int i=0;i<arr.length;i++) {
			if (set.contains(target-arr[i])) {
				return true;
			} else {
				set.add(arr[i]);
			}
		}
		return false;
	}
	
	public static void hasIndex(int[] arr, int target) {
		if (arr== null || arr.length <2) {
			return;
		}
		
		int len = arr.length;
		//key是arr的值，value是arr的index
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0;i<len;i++) {
			map.put(arr[i], i);
		}
		
		List<ArrayList<Integer>> list = new ArrayList<>();
		
		for (int i=0;i<len;i++) {
			if (map.containsKey(target-arr[i])) {
				ArrayList<Integer> l = new ArrayList<>();
				l.add(map.get(arr[i]));
				l.add(map.get(target-arr[i]));
				list.add(l);
			} 
		}
		
		System.out.println(">>>>>>>>");
		list.forEach(e -> System.out.println(e));
	}
}
