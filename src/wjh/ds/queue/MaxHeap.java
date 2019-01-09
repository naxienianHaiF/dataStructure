package wjh.ds.queue;

import java.lang.reflect.Array;

/**
 * 最大堆
 * 
 * @author JHW
 *
 */
public class MaxHeap<E extends Comparable<? super E>> {

	private E[] data;
	private int size;

	@SuppressWarnings("unchecked")
	public MaxHeap(Class<?> type, int size) {
		data = (E[]) Array.newInstance(type, size);
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public MaxHeap(Class<?> type, E[] arr) {
		if (arr == null) {
			throw new IllegalAccessError("array can not be null...");
		}
		size = arr.length;
		data = (E[]) Array.newInstance(type, size);
		for (int i = 0; i < size; i++) {
			data[i] = arr[i];
		}
	}

	/**
	 * 向堆中添加元素
	 * 
	 * @param val
	 */
	public void add(E val) {
		data[size++] = val;
		siftup(size - 1, val);
	}

	private void siftup(int index, E val) {
		while (index > 0 && data[index].compareTo(data[parent(index)]) > 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}

	public E findMax() {
		if (size == 0) {
			return null;
		}
		return data[0];
	}

	/**
	 * 取出堆中最大的元素
	 * 
	 * @return
	 */
	public E extractMax() {
		E ret = findMax();
		swap(0, size - 1);
		data[--size] = null;
		siftdown(0);
		return ret;
	}

	private void siftdown(int k) {
		while (k < size) {
			int j = leftChild(k);
			// 如果存在右孩子，且右孩子的值大于左孩子的值
			if (j + 1 < size && data[j + 1].compareTo(data[j]) > 0) {
				j++;
			}
			if (j > size - 1) {
				break;
			}
			if (data[k].compareTo(data[j]) >= 0) {
				break;
			}
			swap(k, j);
			k = j;
		}
	}

	private int parent(int index) {
		if (index == 0) {
			throw new IllegalArgumentException("index 0 doesn't have parent.");
		}
		return (index - 1) / 2;
	}

	/**
	 * @param index
	 * @return 返回完全二叉树的数组表示中， 一个索引所表示的元素的左孩子节点的索引
	 */
	private int leftChild(int index) {
		if (index < 0 || index > data.length) {
			throw new IllegalArgumentException("越界访问。。。" + index);
		}
		return 2 * index + 1;
	}

	/**
	 * @param index
	 * @return 返回完全二叉树的数组表示中， 一个索引所表示的元素的右孩子节点的索引
	 */
	@SuppressWarnings("unused")
	private int rightChild(int index) {
		if (index < 0 || index > data.length) {
			throw new IllegalArgumentException("越界访问。。。" + index);
		}
		return 2 * index + 2;
	}

	private void swap(int k, int j) {
		if (k < 0 || k > size || j < 0 || j > size) {
			throw new IllegalArgumentException("越界访问");
		}
		E temp = data[k];
		data[k] = data[j];
		data[j] = temp;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

	/**
	 * 取出最大元素后，放入一个新的元素
	 * 
	 * @param val
	 */
	public E replace(E val) {
		E result = findMax();
		data[0] = val;
		siftdown(0);
		return result;
	}

	/**
	 * 把数组整理成最大堆 <br />
	 * 从最后一个非叶子节点开始下沉，时间复杂度是O(n) <br />
	 * 这个方法比便利添加要快
	 * 
	 * @param arr
	 */
	public void heapify(E[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = parent(size - 1); i >= 0; i--) {
			siftdown(i);
		}
	}
}
