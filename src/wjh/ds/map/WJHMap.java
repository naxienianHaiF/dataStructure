package wjh.ds.map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class WJHMap {

	public static void main(String[] args) {
		HashMap<Integer, String> map=new HashMap<>();
		map.put(1, "wjh");
		map.put(2, "xcf");
		map.put(3, "zl");
		
		Set<Integer> set = map.keySet();
		for (Integer integer : set) {
			System.out.println(map.get(integer));
		}
		
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.print("key="+entry.getKey());
			System.out.println(",value="+entry.getValue());
		}
	}
}
