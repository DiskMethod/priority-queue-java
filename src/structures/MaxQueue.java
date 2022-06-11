package structures;

import comparators.IntegerComparator;

import java.util.Comparator;
import java.util.Iterator;

public class MaxQueue<V> implements PriorityQueue<Integer, V> {
	
	private StudentArrayHeap<Integer, V> queue;
	private Comparator<Integer> comparator;
	
	public MaxQueue() {
		comparator = new IntegerComparator();
		queue = new StudentArrayHeap<Integer, V>(comparator);
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) throws NullPointerException {
		if(priority == null || value == null) {
			throw new NullPointerException();
		}
		queue.add(priority, value);
		return this;
	}

	@Override
	public V dequeue() throws IllegalStateException {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		V elem = queue.remove();
		return elem;
	}

	@Override
	public V peek() throws IllegalStateException {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		V elem = queue.peek();
		return elem;
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		return queue.asList().iterator();
	}
	
	@Override
	public Comparator<Integer> getComparator() {
		return comparator;
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		return false;
	}
}
