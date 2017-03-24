package wjh.ds.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTableDemo {

	public static void main(String[] args) {
		Map<String, String> map=new Hashtable<String, String>();
		map.put("wjh", "15201733125");
		map.put("gege", "15317937279");
//		map.put(null, null);
		
		Set<String> set=map.keySet();
		for(String s:set)
			System.out.println(s+":"+map.get(s));
	}
}
