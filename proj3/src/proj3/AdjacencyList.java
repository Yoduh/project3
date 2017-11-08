package proj3;

/**
 * Implementation of Adjacency List data structure. 
 * Adjacency List keeps track of all "neighbors" between vertices. 
 * This adjacency list utilizes a 1000 size array where each index of 
 * the array contains a sorted linked list of Edges which I have 
 * implemented as an "EdgeList".
 * @author aehandlo
 *
 */
public class AdjacencyList {
	/** Sorted linked list of edges */
	private EdgeList[] vertices;
	/** Size of adjacency list */
	private int size;

	/**
	 * Constructor method
	 */
	public AdjacencyList() {
		vertices = new EdgeList[1000];
		size = 0;
	}
	
	/**
	 * Adds new vertex to adjacency list
	 * @param v Vertex to add
	 */
	public void insertVertex(int v) {
		if(vertices[v] == null) {
			vertices[v] = new EdgeList();
			size++;
		}
	}
	
	/**
	 * Adds new edge to the linked list of a given vertex
	 * @param v Vertex that edge is incident to
	 * @param e Edge being added
	 */
	public void insertEdge(int v, Edge e) {
		vertices[v].add(e);
	}
	
	/**
	 * Get edges from given vertex
	 * @param v Vertex that edges are being requested for
	 * @return Sorted linked list of edges for given vertex
	 */
	public EdgeList getEdge(int v) {
		return vertices[v];
	}
	
	/**
	 * Get size of adjacency list
	 * @return Size of adjacency list
	 */
	public int size() {
		return size;
	}

	/**
	 * Add new weighted edge to adjacency list between two given vertices 
	 * @param vertex1 First vertex incident to edge
	 * @param vertex2 Second vertex incident to edge
	 * @param weight Weight of edge
	 */
	public void newEdge(int vertex1, int vertex2, double weight) {
		insertVertex(vertex1);
		insertVertex(vertex2);
		Edge e = new Edge(vertex1, vertex2, weight, null);
		insertEdge(vertex1, e);
		e = new Edge(vertex1, vertex2, weight, null);
		insertEdge(vertex2, e);
	}

}
