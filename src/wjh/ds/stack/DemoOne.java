package wjh.ds.stack;
/*
 * stackջ
 */
import java.util.Stack;

public class DemoOne {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		stack.push(12);
		stack.push(23);
		stack.push(17);
		System.out.println("peek:"+stack.peek());
//		System.out.println(stack.search(12));
//		System.out.println(stack.search(13));
		//pop  �Ƴ�ջ�����󣬲���Ϊ������ֵ ���ظö���
		System.out.println("size:"+stack.size());
		for(int i=0;i<3;i++)   //���ﲻ����stack.size()����Ϊ���������С
			System.out.println(stack.pop());
		System.out.println("stack is empty? "+stack.isEmpty());
	}
}
