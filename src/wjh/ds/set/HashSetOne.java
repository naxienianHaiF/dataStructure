package wjh.ds.set;
/*
 * HashSet不是Ordered也不是Sorted,存储对象引用时是按照哈希策略来实现的,
 * HashSet中是否存在一个对象是通过equals()和hashCode()协同判断 
 * 不保证顺序  
 * 一个不包含重复元素的 collection。更确切地讲，set不包含满足 e1.equals(e2)的元素对 e1和 e2，
 * 并且最多包含一个 null 元素。正如其名称所暗示的，此接口模仿了数学上的 set 抽象。
 */
import java.util.HashSet;

public class HashSetOne {

	public static void main(String[] args) {
		//HashSet底层是使用HashMap实现的 
		HashSet<String> hs=new HashSet<>();
		hs.add("wjh");
		hs.add("naxienian1992");
		String s1=new String("xcf");
		String s2="xcf";
		System.out.println(s1==s2);
		hs.add(s1);
		hs.add(s2);
		System.out.println("====遍历HashSet====");
		//不保证顺序的
		for(String s:hs)
			System.out.println(s);
	}
}
