package wjh.ds.set;

import java.util.LinkedHashSet;

/*
 * LinkedHashSet��Ordered,����˫����ʵ�ֵ�  
 * �й̶�˳��,Ҳ���ǲ���˳��
 * LinkedHashSet�ײ���ʹ��LinkedHashMapʵ�ֵ�
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
