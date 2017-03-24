package wjh.ds.map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		Map<String, String> map=new TreeMap<String, String>(new ComparatorDemo());
		map.put("WJH", "WJH");
		map.put("xcf", "xcf");
		map.put("class", "3(6)");
		
		Set<String> set=map.keySet();
		for(String s:set)
			System.out.println(s+"="+map.get(s));
	}
}
