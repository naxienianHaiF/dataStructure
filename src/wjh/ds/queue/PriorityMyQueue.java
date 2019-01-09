package wjh.ds.queue;

public class PriorityMyQueue<E extends Comparable<? super E>> implements MyQueue<E>{

	private MaxHeap<E> heap;
	
	public PriorityMyQueue(Class<?> type, int size){
		heap = new MaxHeap<>(type, size);
	}
	
	@Override
	public void add(E e) {
		heap.add(e);
	}
	
	@Override
	public E poll() {
		return heap.extractMax();
	}
	
	@Override
	public E element() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("queue is empty");
		}
		return heap.findMax();
	}
	
	@Override
	public E peek() {
		return heap.findMax();
	}
	
	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public int size() {
		return heap.size();
	}
}
