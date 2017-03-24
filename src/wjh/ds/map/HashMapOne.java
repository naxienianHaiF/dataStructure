package wjh.ds.map;

/*
 * HashMap��һ����õ�Map�������ݼ���hashCodeֵ�洢���ݣ����ݼ�����ֱ�ӻ�ȡ����ֵ������
 * �ܿ�ķ����ٶȡ�HashMap���ֻ����һ����¼�ļ�ΪNULL�����������¼��ֵΪNULL��
 * HashMap��֧���߳�ͬ��������һʱ�̿����ж���߳�ͬʱдHashMap�����ܻᵼ�����ݵĲ�һ���ԡ�
 * �����Ҫͬ����������Collections��synchronizedMap����ʹHashMap����ͬ����������
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
		
		//����Iterator����HashMap
		Iterator<Integer> it=map.keySet().iterator();
		while(it.hasNext()){
			Integer i=it.next();
			System.out.println("key:"+i);
			System.out.println("value:"+map.get(i));
		}
		System.out.println("������ʽ��=========");
		//����HashMap����һ�ַ���
		Set<Entry<Integer,String>> set=map.entrySet();
		for(Entry<Integer, String> entry:set){
			System.out.print(entry.getKey()+",");
			System.out.println(entry.getValue());
		}
		
		String s=map.get(1);
		System.out.println(s);
		
	}
}
