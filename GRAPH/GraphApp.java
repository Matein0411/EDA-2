// GraphApp.java
// Demo of MST, BFS, and DFS
// To run this program: C>java GraphApp
////////////////////////////////////////////////////////////////

public class GraphApp {
    public static void main(String[] args) {
        Graph theGraph = new Graph();
        theGraph.addVertex('1');    // 0 (starting point for mst, bfs, dfs)
        theGraph.addVertex('2');    // 1
        theGraph.addVertex('3');    // 2
        theGraph.addVertex('4');    // 3
        theGraph.addVertex('5');    // 4
        theGraph.addVertex('6');    // 5

        theGraph.addEdge(0, 1);     // Edge between vertex 1 and 2
        theGraph.addEdge(0, 2);     // Edge between vertex 1 and 3
        theGraph.addEdge(0, 3);     // Edge between vertex 1 and 4
        theGraph.addEdge(1, 4);     // Edge between vertex 2 and 5
        theGraph.addEdge(2, 1);     // Edge between vertex 3 and 2
        theGraph.addEdge(2, 3);     // Edge between vertex 3 and 4
        theGraph.addEdge(2, 4);     // Edge between vertex 3 and 5
        theGraph.addEdge(2, 5);     // Edge between vertex 3 and 6
        theGraph.addEdge(3, 5);     // Edge between vertex 4 and 6
        theGraph.addEdge(4, 5);     // Edge between vertex 5 and 6

        // Uncomment the following lines to see the Minimum Spanning Tree (MST)
        // System.out.print("Minimum Spanning Tree: ");
        // theGraph.mst();             // Minimum Spanning Tree
        // System.out.println();

        System.out.print("BFS Visits: ");
        theGraph.bfs(0);             // Breadth-First Search
        System.out.println();

        System.out.print("DFS Visits: ");
        theGraph.dfs(0);             // Depth-First Search
        System.out.println();

        System.out.print("Path from 1 to 6: ");
        theGraph.findPath(0, 5);    // Find path from vertex 1 to vertex 6

        theGraph.printAdjacencyMatrix(); // Print the adjacency matrix of the graph

    }  // end main()
}  // end class GraphApp
////////////////////////////////////////////////////////////////
