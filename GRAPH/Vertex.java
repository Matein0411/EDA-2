// Vertex.java
// Clase para representar un vértice en el grafo
////////////////////////////////////////////////////////////////

/**
 * The Vertex class represents a vertex in a graph.
 * Each vertex has a label and a flag indicating whether it has been visited.
 */
public class Vertex {
    public char label;       // label (e.g., 'A')
    public boolean wasVisited;

    // Constructor
    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}  // end class Vertex
////////////////////////////////////////////////////////////////
