package proj3;

public class Heap {
	
	private Edge[] heap;
	private int size;

	public Heap() {
		heap = new Edge[5000];
		size = 0;
	}
	
	public void insert(int vertex1, int vertex2, double weight) {
		Edge e = new Edge(vertex1, vertex2, weight, null);
		heap[size] = e;
		size++;
		upHeap(size - 1);
	}

	private void upHeap(int i) {
		if(i > 0) {
			if(heap[(i - 1) / 2].getWeight() > heap[i].getWeight()) {
				swap((i - 1) / 2, i);
				upHeap((i - 1) / 2);
			}
		}
	}
	
	public Edge deleteMin() {
		Edge x = heap[0];
		size--;
		swap(0, size);
		downHeap(0);
		return x;
	}

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

	private void swap(int a, int b) {
		Edge temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	public Edge printEdge(int i) {
		return heap[i];
	}
	
	public int size() {
		return size;
	}

}
