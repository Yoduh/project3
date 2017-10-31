package proj3;

public class UpTree {
	
	private int[] forest;

	public UpTree() {
		forest = new int[1000];
	}
	
	public void makeSet(int v) {
		forest[v] = -1;
	}
	
	public int find(int v) {
		if(forest[v] < 0) {
			return v;
		} else {
			return find(forest[v]);
		}
	}
	
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
