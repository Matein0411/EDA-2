public class MatrixOfCost {
    private double[][] costMatrix;
    private int numVertices;

    public MatrixOfCost(int numVertices) {
        this.numVertices = numVertices;
        this.costMatrix = new double[numVertices][numVertices];
        initializeMatrix();
    }

    private void initializeMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    costMatrix[i][j] = 0; // Cost from a vertex to itself is 0
                } else {
                    costMatrix[i][j] = Double.POSITIVE_INFINITY; // Initialize with infinity
                }
            }
        }
    }

    public void addEdge(int source, int destination, double cost) {
        costMatrix[source][destination] = cost;
    }

    public void removeEdge(int source, int destination) {
        costMatrix[source][destination] = Double.POSITIVE_INFINITY;
    }

    public double getCost(int source, int destination) {
        return costMatrix[source][destination];
    }

    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (costMatrix[i][j] == Double.POSITIVE_INFINITY) {
                    System.out.print("INF ");
                } else {
                    System.out.print(costMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}