// GraphApp.java
// Demo of MST, BFS, and DFS
// To run this program: C>java GraphApp
////////////////////////////////////////////////////////////////
public class GraphApp {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Graph theGraph = new Graph();

        theGraph.addVertex('1');    // 0
        theGraph.addVertex('2');    // 1
        theGraph.addVertex('3');    // 2
        theGraph.addVertex('4');    // 3

        theGraph.addEdge(0, 1);     // A-B
        theGraph.addEdge(1, 2);     // B-C
        theGraph.addEdge(2, 3);     // C-D
        theGraph.addEdge(3, 0);     // D-A

        // Uncomment the following lines to see the Minimum Spanning Tree (MST)
        // System.out.print("Minimum Spanning Tree: ");
        // theGraph.mst();             // Minimum Spanning Tree
        // System.out.println();

        System.out.print("BFS Visits: " + "\n");
        theGraph.bfs(0);             // Breadth-First Search
        System.out.println();

        System.out.print("DFS Visits: "+ "\n");
        theGraph.dfs(0);             // Depth-First Search
        System.out.println();

        // System.out.print("Path from A to D: " + "\n");
        // theGraph.findPath(0, 3);    // Find path from vertex A to vertex D

        // theGraph.printAdjacencyMatrix(); // Print the adjacency matrix of the graph

        System.out.println("Time taken: " + "\n" + (System.nanoTime() - startTime) + " ns");

    }  // end main()
}