package wjh.ds.list;

import java.util.ArrayList;
import java.util.List;

public class ListDuoTai {

	public static void main(String[] args) {
		List<A> list=new ArrayList<A>();
		list.add(new B());
		list.add(new C());
		for(A a:list)
			a.a("list");
	}
}

interface A{
	public void a(String str);
}

class B implements A{

	@Override
	public void a(String str) {
		System.out.println("B:"+str);
	}
}

class C implements  A{

	@Override
	public void a(String str) {
		System.out.println("C:"+str);
	}
	
}