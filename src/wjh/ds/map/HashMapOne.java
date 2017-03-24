package wjh.ds.map;

/*
 * HashMap是一个最常用的Map，它根据键的hashCode值存储数据，根据键可以直接获取它的值，具有
 * 很快的访问速度。HashMap最多只允许一条记录的键为NULL，允许多条记录的值为NULL。
 * HashMap不支持线程同步，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致性。
 * 如果需要同步，可以用Collections的synchronizedMap方法使HashMap具有同步的能力。
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapOne {

	public static void main(String[] args) {
		HashMap<Integer, String> map=new HashMap<>();
		
		map.put(1, "wjh");
		map.put(2, "xcf");
		map.put(3, "zjq");
		
		System.out.println(map);
		System.out.println(map.containsKey(3));
		System.out.println(map.entrySet());
		System.out.println("===========================");
		Set<Integer> set1=map.keySet();
		for(Integer inte:set1)
			System.out.println(map.get(inte));
		System.out.println("===========================");
		
		//采用Iterator遍历HashMap
		Iterator<Integer> it=map.keySet().iterator();
		while(it.hasNext()){
			Integer i=it.next();
			System.out.println("key:"+i);
			System.out.println("value:"+map.get(i));
		}
		System.out.println("遍历方式二=========");
		//遍历HashMap的另一种方法
		Set<Entry<Integer,String>> set=map.entrySet();
		for(Entry<Integer, String> entry:set){
			System.out.print(entry.getKey()+",");
			System.out.println(entry.getValue());
		}
		
		String s=map.get(1);
		System.out.println(s);
		
	}
}
