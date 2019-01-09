package wjh.ds.queue;

public interface MyQueue<E extends Comparable<? super E>> {

    void add(E e);
    
    E poll();
    
    E element();
    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    E peek();
    
    boolean isEmpty();
}
