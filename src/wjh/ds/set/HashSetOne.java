package wjh.ds.set;
/*
 * HashSet����OrderedҲ����Sorted,�洢��������ʱ�ǰ��չ�ϣ������ʵ�ֵ�,
 * HashSet���Ƿ����һ��������ͨ��equals()��hashCode()Эͬ�ж� 
 * ����֤˳��  
 * һ���������ظ�Ԫ�ص� collection����ȷ�еؽ���set���������� e1.equals(e2)��Ԫ�ض� e1�� e2��
 * ����������һ�� null Ԫ�ء���������������ʾ�ģ��˽ӿ�ģ������ѧ�ϵ� set ����
 */
import java.util.HashSet;

public class HashSetOne {

	public static void main(String[] args) {
		//HashSet�ײ���ʹ��HashMapʵ�ֵ� 
		HashSet<String> hs=new HashSet<>();
		hs.add("wjh");
		hs.add("naxienian1992");
		String s1=new String("xcf");
		String s2="xcf";
		System.out.println(s1==s2);
		hs.add(s1);
		hs.add(s2);
		System.out.println("====����HashSet====");
		//����֤˳���
		for(String s:hs)
			System.out.println(s);
	}
}
