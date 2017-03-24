package wjh.ds.set;

import java.util.LinkedHashSet;

/*
 * LinkedHashSet是Ordered,采用双链表实现的  
 * 有固定顺序,也就是插入顺序
 * LinkedHashSet底层是使用LinkedHashMap实现的
 */
public class LinkedhashSetOne {

	public static void main(String[] args) {
		LinkedHashSet<String> lhs=new LinkedHashSet<>();
		lhs.add("wjh");
		lhs.add("zjq");
		lhs.add("xcf");
		for(String s:lhs)
			System.out.println(s);
	}
}
