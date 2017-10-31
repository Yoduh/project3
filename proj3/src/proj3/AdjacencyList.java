package proj3;

public class AdjacencyList {
	
	private EdgeList[] vertices;
	private int size;

	public AdjacencyList() {
		vertices = new EdgeList[1000];
		size = 0;
	}
	
	public void insertVertex(int v) {
		if(vertices[v] == null) {
			vertices[v] = new EdgeList();
			size++;
		}
	}
	
	public void insertEdge(int v, Edge e) {
		vertices[v].add(e);
	}
	
	public EdgeList getEdge(int v) {
		return vertices[v];
	}
	
	public int size() {
		return size;
	}

	public void newEdge(int vertex1, int vertex2, double weight) {
		insertVertex(vertex1);
		insertVertex(vertex2);
		Edge e = new Edge(vertex1, vertex2, weight, null);
		insertEdge(vertex1, e);
		e = new Edge(vertex1, vertex2, weight, null);
		insertEdge(vertex2, e);
	}

}
