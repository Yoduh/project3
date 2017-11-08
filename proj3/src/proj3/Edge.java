package proj3;

/**
 * Edge object represents a relationship between two vertices
 * @author aehandlo
 *
 */
public class Edge {
	/** First vertex that an edge is incident to */
	private int vertex1;
	/** Second vertex that an edge is incident to */
	private int vertex2;
	/** Weight of the edge */
	private double weight;
	/** Pointer to next edge in a linked list */
	protected Edge next;

	/**
	 * Constructor method
	 * @param vertex1 First incident vertex
	 * @param vertex2 Second incident vertex
	 * @param weight Weight of edge
	 * @param next Pointer to next edge in linked list
	 */
	public Edge(int vertex1, int vertex2, double weight, Edge next) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		this.next = next;
	}
	
	/**
	 * Gets weight of edge
	 * @return Weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Gets value of first vertex
	 * @return First vertex value
	 */
	public int getVertex1() {
		return vertex1;
	}
	
	/**
	 * Gets value of second vertex
	 * @return Second vertex value
	 */
	public int getVertex2() {
		return vertex2;
	}
	
	/**
	 * Sets value of first vertex
	 * @param v Value of first vertex
	 */
	public void setVertex1(int v) {
		vertex1 = v;
	}
	
	/**
	 * Sets value of second vertex
	 * @param v Value of second vertex
	 */
	public void setVertex2(int v) {
		vertex2 = v;
	}

}
