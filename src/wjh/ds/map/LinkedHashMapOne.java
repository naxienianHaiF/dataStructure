package wjh.ds.map;

/*
 * 保持放入元素先后的顺序不变化： 
 * 查询时，把最新查出来的元素放在末位(很奇怪，为什么不是把查询出来的元素放在首位)
 */
import java.util.LinkedHashMap;

public class LinkedHashMapOne {

	public static void main(String[] args) {
		LinkedHashMap<String, String> lhm=new LinkedHashMap<>();
		lhm.put("first", "xcf");
		lhm.put("second","zl");
		lhm.put("last", "zjq");
		lhm.put("second", "wx");
		
		for (String key : lhm.keySet()) {
			System.out.println(key);
		}
		for(String value:lhm.values())
			System.out.println(value);
		System.out.println(lhm.get("second"));
		System.out.println(lhm.hashCode());
	}
}
