package wjh.ds.map;

/*
 * ���ַ���Ԫ���Ⱥ��˳�򲻱仯�� 
 * ��ѯʱ�������²������Ԫ�ط���ĩλ(����֣�Ϊʲô���ǰѲ�ѯ������Ԫ�ط�����λ)
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
