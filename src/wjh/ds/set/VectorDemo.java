package wjh.ds.set;
//Vestor是同步的
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		Vector<Integer> vector=new Vector<Integer>();
		for(int i=0;i<30;i++)
			vector.add(i);
		
		for(Integer i:vector)
			System.out.print(i+" ");
		System.out.println();
	}
}
