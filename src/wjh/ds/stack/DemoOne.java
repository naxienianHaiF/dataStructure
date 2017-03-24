package wjh.ds.stack;
/*
 * stack栈
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
		//pop  移除栈顶对象，并作为函数的值 返回该对象
		System.out.println("size:"+stack.size());
		for(int i=0;i<3;i++)   //这里不能用stack.size()，因为它会持续变小
			System.out.println(stack.pop());
		System.out.println("stack is empty? "+stack.isEmpty());
	}
}
