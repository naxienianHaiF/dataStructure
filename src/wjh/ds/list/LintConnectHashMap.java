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
		System.out.println("请输入学生的信息,y表示继续，n表示退出");
		
		while("y".equals(sc.next())){
			HashMap<String, Object> map=new HashMap<>();
			System.out.println("请输入学号");
			map.put("studentno", sc.next());
			System.out.println("请输入姓名");
			map.put("name", sc.next());
			System.out.println("请输入年龄");
			map.put("age", sc.nextInt());
			list.add(map);
			System.out.println("请继续输入学生的信息,y表示继续，n表示退出");
		}
		
		System.out.println("输入的学生信息为:");
		System.out.println("学生数量为:" + list.size());

		Iterator<HashMap<String, Object>> it = list.iterator();
		int i = 1;
		while (it.hasNext()) {
			HashMap<String, Object> stuMap = it.next();
			System.out.print("第" + i + "个学生的信息为");
			System.out.println(
					"学号:" + stuMap.get("studentno") + " ,姓名:" + stuMap.get("name") + " ,年龄:" + stuMap.get("age"));
		}
		sc.close();
	}
}
