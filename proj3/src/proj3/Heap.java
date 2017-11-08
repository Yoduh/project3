package proj3;

/**
 * Array based implementation of Heap-Sort.  
 * Array can hold up to 5000 edges.
 * 
 * @author aehandlo
 *
 */
public class Heap {
	/** Array of edges that make up the heap */
	private Edge[] heap;
	/** Size of heap */
	private int size;

	/**
	 * Constructor method
	 */
	public Heap() {
		heap = new Edge[5000];
		size = 0;
	}
	
	/**
	 * Creates and inserts new edge into heap
	 * @param vertex1 First vertex incident to edge
	 * @param vertex2 Second vertex incident to edge
	 * @param weight Weight of edge
	 */
	public void insert(int vertex1, int vertex2, double weight) {
		Edge e = new Edge(vertex1, vertex2, weight, null);
		heap[size] = e;
		size++;
		upHeap(size - 1);
	}

	/**
	 * Recursively swap newly inserted edge higher up the heap until it is sorted
	 * @param i Current index position in heap
	 */
	private void upHeap(int i) {
		if(i > 0) {
			if(heap[(i - 1) / 2].getWeight() > heap[i].getWeight()) {
				swap((i - 1) / 2, i);
				upHeap((i - 1) / 2);
			}
		}
	}
	
	/**
	 * Remove root of heap and return it
	 * @return Root of heap
	 */
	public Edge deleteMin() {
		Edge x = heap[0];
		size--;
		swap(0, size);
		downHeap(0);
		return x;
	}

	/**
	 * Recursively swap new root down the heap until it is sorted
	 * @param m Current index position of heap
	 */
	private void downHeap(int m) {
		// i is m's smallest child, if one exists
		int i = 0;
		if(2 * m + 2 < size) {	// both children exist
			if(heap[2 * m + 2].getWeight() < heap[2 * m + 1].getWeight()) {
				i = 2 * m + 2;
			} else {
				i = 2 * m + 1;
			}
		} else if(2 * m + 1 < size) { // only the left child exists
			i = 2 * m + 1;
		}
		// at this stage, if i = 0, then the node has no children
		if(i > 0 && heap[m].getWeight() > heap[i].getWeight()) {
			swap(m, i);
			downHeap(i);
		}
	}

	/**
	 * Swap two given nodes of the heap
	 * @param a First node of the heap to swap
	 * @param b Second node of the heap to swap
	 */
	private void swap(int a, int b) {
		Edge temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	/**
	 * Return a given index value of the heap. This is going to be printed
	 * @param i Index value of the heap to print
	 * @return Edge to be printed
	 */
	public Edge printEdge(int i) {
		return heap[i];
	}
	
	/**
	 * Get size of heap
	 * @return Size of heap
	 */
	public int size() {
		return size;
	}

}
