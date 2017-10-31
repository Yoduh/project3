package proj3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Project3 {
	
	Heap heap = new Heap();
	AdjacencyList aList = new AdjacencyList();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Project3 obj = new Project3();
		obj.execute();
	}
	
	/**
	 * Opens input and output reader and writer, populates node arrays,
	 * calls for tree to be built, answers relationship queires, 
	 * then prints level-order traversal
	 * @throws FileNotFoundException if files not found
	 * @throws IOException if problem with input/output
	 */
	
	public void execute() throws FileNotFoundException, IOException {
		// prepare input and output streams
		// for redirection
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out, "UTF-8"));
		
		// for files
		/*
		if(!inputReader.ready()) {
			System.out.println("Enter an input filename (e.g. \"filename.txt\"): ");
			File inputFileName = new File(inputReader.readLine());
			System.out.println("Enter an output filename (e.g. \"filename.txt\"): ");
			File outputFileName = new File(inputReader.readLine());
			inputReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), "UTF-8"));
			outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8"));
		}*/
		// DELETE THIS NEPHEW
		inputReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/proj3/input.txt"), "UTF-8"));
		// DELETE THIS NEPHEW
		outputWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/proj3/output.txt"), "UTF-8"));
		
		String line = inputReader.readLine();
		Scanner scan = new Scanner(line);
		int vertex1;
		int vertex2;
		double weight;
		while(!line.equals("-1")) {
			vertex1 = scan.nextInt();
			vertex2 = scan.nextInt();
			weight = scan.nextDouble();
			if(vertex2 < vertex1) {
				int temp = vertex1;
				vertex1 = vertex2;
				vertex2 = temp;
			}
			aList.newEdge(vertex1, vertex2, weight);
			heap.insert(vertex1, vertex2, weight);
			line = inputReader.readLine();
			scan = new Scanner(line);
		}
		outputHeap(); // print heap now before using deleteMin to find the Minimum Spanning Tree messes up the heap
		EdgeList mstEdges = MST();
		outputRest(mstEdges); // print rest of the data
		
		scan.close();
		inputReader.close();
		outputWriter.close();
	}

	private void outputHeap() {
		// print Heap
		for(int i = 0; i < heap.size(); i++) {
			System.out.printf("%4d %4d\n", heap.printEdge(i).getVertex1(), heap.printEdge(i).getVertex2());
		}
	}

	private void outputRest(EdgeList mstEdges) {
		// print MST
		for(int i = 0; i < mstEdges.size(); i++) {
			System.out.printf("%4d %4d\n", mstEdges.get(i).getVertex1(), mstEdges.get(i).getVertex2());
		}
		
		// print Adjacency List
		for(int i = 0; i < aList.size(); i++) {
			if(aList.getEdge(i).get(0).getVertex1() != i) {
				System.out.printf("%4d", aList.getEdge(i).get(0).getVertex1());
			} else {
				System.out.printf("%4d", aList.getEdge(i).get(0).getVertex2());
			}
			for(int j = 1; j < aList.getEdge(i).size(); j++) {
				if(aList.getEdge(i).get(j).getVertex1() != i) {
					System.out.printf(" %4d", aList.getEdge(i).get(j).getVertex1());
				} else {
					System.out.printf(" %4d", aList.getEdge(i).get(j).getVertex2());
				}
			}
			System.out.println();
		}
	}

	private EdgeList MST() {
		UpTree tree = new UpTree();
		EdgeList edges = new EdgeList(); // the set of edges in the MST
		int components = aList.size(); // initially, each vertex is in a component by itself
		for(int i = 0; i < aList.size(); i++) {
			tree.makeSet(i);
		}
		
		while(components > 1) { // process edges in order of increasing weight
			Edge e = heap.deleteMin();
			int U = tree.find(e.getVertex1());
			int V = tree.find(e.getVertex2());
			if(U != V) {
				tree.union(U, V);
				edges.add(e);
				components--;
			}
		}
		
		return edges;
	}

}
