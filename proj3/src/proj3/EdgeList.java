package proj3;

/**
 * A sorted linked list implementation that uses Edge objects 
 * custom to CSC 316 project 3.
 * @author aehandlo
 *
 */
public class EdgeList {
	private Edge front;
	private int size;
	
	
	/**
	 * Constructor creates a new list
	 * @param capacity of list
	 */
	public EdgeList() {
		front = null;
		this.size = 0;
	}
	
	/**
	 * Returns Edge at given index
	 * @param idx is index of the Edge to be returned
	 * @return the Edge to be returned at specified index.
	 * 
	 */
	public Edge get(int idx) {
		//create double pointers
		Edge current = front;
		Edge previous = null;
		
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}
		
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		//return Edge at zero
		if (idx == 0) {
			return current;
		}
		
		//return Edge greater than zero
		if (front != null) {
			while (current != null && idx > 0) {
				previous = current;
				current = current.next;
				idx--;
			}
			return previous.next;
		}
		
		return null;
	}
	
	/**
	 * Adds Edge to the list and sorts
	 * @param e Edge object being added to the list
	 * @throws NullPointerException if the object to add is null
	 * @throws IllegalArgumentException if a duplicate object in the list is detected
	 */
	public void add(Edge e) {		
		
		if (e == null) {
			throw new NullPointerException();
		}
		
		// first check for duplicates
		for (Edge p = front; p != null; p = p.next) {
	         if (p.equals(e)) {
	        	 throw new IllegalArgumentException();
	         }
		}
		
		// insert in empty list
		if (size == 0) {
			front = e;
		} 
		// special case: adding to front
		else if(front.getVertex1() > e.getVertex1() || (front.getVertex1() == e.getVertex1() && front.getVertex2() > e.getVertex2())) {
			e.next = front;
			front = e;
		}
		// insert elsewhere in non-empty list
		else {
			Edge current = front;
			Edge prev = front;
			while(true) {
				prev = current;
				current = current.next;
				if(current == null) {	// insert at rear of list
					e.next = current;
					prev.next = e;
					break;
				}
				if(current.getVertex1() > e.getVertex1() || 
					(current.getVertex1() == e.getVertex1() && current.getVertex2() > e.getVertex2())) {
					e.next = current;
					prev.next = e;
					break;
				}
			}
		}
		size++;
	}
	
	
	/**
	 * Returns size of the list
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}
}
