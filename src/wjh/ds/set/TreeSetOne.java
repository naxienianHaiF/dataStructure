package wjh.ds.set;
/*
 * 默认使用元素的自然顺序对元素进行排序，也可以自定义排序规则
 */
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetOne {

	public static void main(String[] args) {
		method();
		Set<String> set=new TreeSet<>();
		set.add("HAIF");
		set.add("WJH");
		set.add("XCF");
		set.add(new String("XCF"));
		set.add("STT");
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		TreeSet<Integer> s=new TreeSet<>();
		s.add(1);
		s.add(13);
		s.add(6);
		s.add(3);
		for (Integer integer : s) {
			System.out.println(integer);
		}
		//pollFirst()   Retrieves and removes the last (highest)
		//              element, or returns null if this set is empty
		System.out.println(s.pollFirst());
	}
	/**
	 * 自定义排序规则
	 */
	public static void method(){
		Set<Integer> set=new TreeSet<Integer>(new ComparatorSet());
		set.add(3);
		set.add(1);
		set.add(5);
		
		System.out.println("==================");
		Iterator<Integer> iterator=set.iterator();
		while(iterator.hasNext())
			System.out.print(iterator.next()+" ");
		System.out.println();
		System.out.println("==================");
	}
}
