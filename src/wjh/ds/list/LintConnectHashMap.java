package wjh.ds.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LintConnectHashMap {

	public static void main(String[] args) {
		List<HashMap<String,Object>> list=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("������ѧ������Ϣ,y��ʾ������n��ʾ�˳�");
		
		while("y".equals(sc.next())){
			HashMap<String, Object> map=new HashMap<>();
			System.out.println("������ѧ��");
			map.put("studentno", sc.next());
			System.out.println("����������");
			map.put("name", sc.next());
			System.out.println("����������");
			map.put("age", sc.nextInt());
			list.add(map);
			System.out.println("���������ѧ������Ϣ,y��ʾ������n��ʾ�˳�");
		}
		
		System.out.println("�����ѧ����ϢΪ:");
		System.out.println("ѧ������Ϊ:" + list.size());

		Iterator<HashMap<String, Object>> it = list.iterator();
		int i = 1;
		while (it.hasNext()) {
			HashMap<String, Object> stuMap = it.next();
			System.out.print("��" + i + "��ѧ������ϢΪ");
			System.out.println(
					"ѧ��:" + stuMap.get("studentno") + " ,����:" + stuMap.get("name") + " ,����:" + stuMap.get("age"));
		}
		sc.close();
	}
}
