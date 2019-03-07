package wjh.lintcode;

import java.util.ArrayList;
import java.util.List;

public class AllDemo {

	private static List<StringBuffer> list = new ArrayList<>();

	public static void main(String[] args) {
		print(4);
		list.forEach(e -> System.out.println(e));
		System.out.println("size = " + list.size());
	}

	public static void print(int n) {
		print(n, new StringBuffer());
	}

	private static void print(int n, StringBuffer buffer) {
		if (n == 0) {
			list.add(buffer);
			return;
		}
		StringBuffer buffer2 = new StringBuffer(buffer);
		print(n - 1, buffer.append("a"));
		print(n - 1, buffer2.append("b"));
	}
}
