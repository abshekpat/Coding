package graph;

import java.util.LinkedList;

public class CreateGraph {

	static class Graph {
		int V;
		LinkedList<Integer> adjListArray[];

		@SuppressWarnings("unchecked")
		Graph(int V)
		{
			this.V = V;
			adjListArray = new LinkedList[V];
			for(int i=0; i<V; i++)
				adjListArray[i] = new LinkedList<>();
		}

	}
	static void addEdge(Graph graph, int src, int des) {
		// TODO Auto-generated method stub
		graph.adjListArray[src].add(des);
		graph.adjListArray[des].add(src);

	}
    static void printGraph(Graph graph) {
		// TODO Auto-generated method stub
		for(int v=0; v<graph.V; v++)
		{
			System.out.println("Adjacency list of vertex "+ v);
			System.out.print("head");
			for(Integer i : graph.adjListArray[v])
			{
				System.out.print("-->"+i);
			}
			System.out.println("\n");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
        Graph graph = new Graph(V);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        printGraph(graph);

	}





}
