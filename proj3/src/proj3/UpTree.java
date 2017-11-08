package proj3;

/**
 * Array representation of Up-tree data structure.
 * Used to make sets of vertices and create unions between those sets
 * for the purpose of finding the Minimum Spanning Tree of graphs
 * @author aehandlo
 *
 */
public class UpTree {
	/** Array of disjoint sets */
	private int[] forest;

	/**
	 * Constructor method
	 */
	public UpTree() {
		forest = new int[1000];
	}
	
	/**
	 * Creates new set for a single vertex in the array
	 * @param v Vertex to make set for
	 */
	public void makeSet(int v) {
		forest[v] = -1;
	}
	
	/**
	 * Finds root of a set for a given vertex
	 * @param v Vertex whose set root is being found
	 * @return Root of vertex's set
	 */
	public int find(int v) {
		if(forest[v] < 0) {
			return v;
		} else {
			return find(forest[v]);
		}
	}
	
	/**
	 * Create union between sets of two vertices
	 * @param v1 Vertex from set 1
	 * @param v2 Vertex from set 2
	 */
	public void union(int v1, int v2) {
		int count1 = forest[v1] * -1;
		int count2 = forest[v2] * -1;
		
		if(count1 > count2) {
			forest[v1] = forest[v1] + forest[v2];
			forest[v2] = v1;
		} else {
			forest[v2] = forest[v2] + forest[v1];
			forest[v1] = v2;
		}
	}

}
