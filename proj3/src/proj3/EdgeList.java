package proj3;

/**
 * Extends AbstractList of generic type as new LinkedAbstractList 
 * that does not allow null or duplicate elements 
 * @author aehandlo
 *
 */
public class EdgeList {
	private Edge front;
	private int size;
	private Edge back;
	
	
	/**
	 * Constructor for LinkedAbstractList creates a new 
	 * LinkedAbstractList that does not allow for null or
	 * duplicate elements
	 * @param capacity of list
	 */
	public EdgeList() {
		front = null;
		this.size = 0;
	}
	
	/**
	 * Returns E at given index
	 * @param idx is index of element to be returned
	 * @return E the element to be returned at specified
	 * index.
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
		
		//return element at zero
		if (idx == 0) {
			return current;
		}
		
		//return element greater than zero
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
	 * Adds item to the rear of the list
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
			back = front;
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
	 * Returns the size of the AbstractLinkedList
	 * @return size is the size of the AbstractLinkedList
	 */
	public int size() {
		return size;
	}
}
