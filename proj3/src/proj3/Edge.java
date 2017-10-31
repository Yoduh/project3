package proj3;

public class Edge {
	
	private int vertex1;
	private int vertex2;
	private double weight;
	protected Edge next;

	public Edge(int vertex1, int vertex2, double weight, Edge next) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
		this.next = next;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getVertex1() {
		return vertex1;
	}
	
	public int getVertex2() {
		return vertex2;
	}
	
	public void setVertex1(int v) {
		vertex1 = v;
	}
	
	public void setVertex2(int v) {
		vertex2 = v;
	}

}
