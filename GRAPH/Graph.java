// Graph.java
// Class to implement the graph and its algorithms
////////////////////////////////////////////////////////////////

public class Graph {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][];      // adjacency matrix
    private int nVerts;          // current number of vertices
    private StackX theStack;     // for DFS
    private Queue theQueue;      // for BFS

    // Constructor
    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency
            for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
                adjMat[j][k] = 0;
        theStack = new StackX();
        theQueue = new Queue();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1; // ensuring it's an undirected graph
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public void mst() { // minimum spanning tree (depth first)
        vertexList[0].wasVisited = true; // mark it
        theStack.push(0);                // push it

        while (!theStack.isEmpty()) {    // until the stack is empty
            int currentVertex = theStack.peek();
            // get the next unvisited neighbor
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1)                  // if no more neighbors
                theStack.pop();           // pop it
            else {                        // found a neighbor
                vertexList[v].wasVisited = true; // mark it
                theStack.push(v);                // push it
                // display the edge
                displayVertex(currentVertex);     // from currentV
                displayVertex(v);                 // to v
                System.out.print(" ");
            }
        }  // end while

        // the stack is empty, so we're done
        for (int j = 0; j < nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }  // end mst()

    public void bfs(int start) { // breadth-first search
        vertexList[start].wasVisited = true; // mark it
        displayVertex(start);                // display it
        theQueue.insert(start);              // insert in the queue
        int v2;
    
        while (!theQueue.isEmpty()) {        // until the queue is empty
            int v1 = theQueue.remove();       // remove vertex at head
            // until it has no unvisited neighbors
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;  // mark it
                displayVertex(v2);                 // display it
                theQueue.insert(v2);               // insert it
            }
        }  // end while
    
        // the queue is empty, so we're done
        for (int j = 0; j < nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
    }  // end bfs()

   public void dfs(int start) { // depth-first search
    vertexList[start].wasVisited = true;  // mark it
    displayVertex(start);                 // display it
    theStack.push(start);                 // push it

    while (!theStack.isEmpty()) {         // until the stack is empty
        // get an unvisited vertex adjacent to the top of the stack
        int v = getAdjUnvisitedVertex(theStack.peek());
        if (v == -1) {                     // if no such vertex,
            theStack.pop();
        } else {                           // if it exists,
            vertexList[v].wasVisited = true; // mark it
            displayVertex(v);                 // display it
            theStack.push(v);                 // push it
        }
    }  // end while

    // the stack is empty, so we're done
    for (int j = 0; j < nVerts; j++) // reset flags
        vertexList[j].wasVisited = false;
}  // end dfs()

    public void findPath(int x, int y) {
        if (path(x, y)) {
            theStack.display(); // display the path
            System.out.println();
        } else {
            System.out.println("No path.");
        }
    }

    private boolean path(int start, int end) {
        theStack.push(start); // push the start vertex
        vertexList[start].wasVisited = true; // mark it as visited
        boolean found = false;

        // If we've reached the end, we're done
        if (start == end) {
            found = true;
        } else {
            // Recursively visit adjacent vertices
            for (int i = 0; i < nVerts && !found; i++) {
                if (adjMat[start][i] == 1 && !vertexList[i].wasVisited) {
                    found = path(i, end); // Visit the adjacent vertex
                }
            }
        }

        if (!found) { // If no path was found, pop from the stack
            theStack.pop();
        }

        return found; // Return true if a path was found
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) // for all vertices
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited)
                return j; // return the index of the vertex
        return -1; // if none found
    }
    
    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < nVerts; i++) { // Change numVertices to nVerts
            for (int j = 0; j < nVerts; j++) { // Change numVertices to nVerts
                System.out.print(adjMat[i][j] + " "); // Access adjMat instead of adjacencyMatrix
            }
            System.out.println();
        }
    }
    
}  // end class Graph
////////////////////////////////////////////////////////////////
