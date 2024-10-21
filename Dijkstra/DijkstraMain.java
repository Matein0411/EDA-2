import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DijkstraMain {
    private Map<String, Vertex> vertexMap = new HashMap<>();
    private List<Edge> edges = new ArrayList<>();
    private DijkstraShortestPath dijkstra = new DijkstraShortestPath();
    private MatrixOfCost matrixOfCost;

    public static void main(String[] args) {
        DijkstraMain main = new DijkstraMain();
		long startTime = System.nanoTime();
        main.run();
		final long duration = System.nanoTime() - startTime;
		System.out.println("Execution time: " + duration + "ns");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int numVertices = scanner.nextInt();
        scanner.nextLine(); // consume newline
        matrixOfCost = new MatrixOfCost(numVertices);

        while (true) {
            System.out.println("1. Add Vertex");
            System.out.println("2. Remove Vertex");
            System.out.println("3. Add Edge");
            System.out.println("4. Remove Edge");
            System.out.println("5. Compute Shortest Path");
            System.out.println("6. Calculate Distance Between Two Vertices");
            System.out.println("7. Print Cost Matrix");
            System.out.println("8. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addVertex(scanner);
                    break;
                case 2:
                    removeVertex(scanner);
                    break;
                case 3:
                    addEdge(scanner);
                    break;
                case 4:
                    removeEdge(scanner);
                    break;
                case 5:
                    computeShortestPath(scanner);
                    break;
                case 6:
                    calculateDistanceBetweenVertices(scanner);
                    break;
                case 7:
                    matrixOfCost.printMatrix();
                    break;
                case 8:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addVertex(Scanner scanner) {
        System.out.print("Enter vertex name: ");
        String name = scanner.nextLine();
        Vertex vertex = new Vertex(name);
        vertexMap.put(name, vertex);
        System.out.println("Vertex added: " + vertex);
    }

    private void removeVertex(Scanner scanner) {
        System.out.print("Enter vertex name to remove: ");
        String name = scanner.nextLine();
        Vertex vertexToRemove = vertexMap.get(name);
        if (vertexToRemove != null) {
            vertexMap.remove(name);
            edges.removeIf(edge -> edge.getStartVertex().equals(vertexToRemove) || edge.getTargetVertex().equals(vertexToRemove));
            System.out.println("Vertex removed: " + vertexToRemove);
        } else {
            System.out.println("Vertex not found.");
        }
    }

    private void addEdge(Scanner scanner) {
        System.out.print("Enter source vertex name: ");
        String sourceName = scanner.nextLine();
        System.out.print("Enter destination vertex name: ");
        String destName = scanner.nextLine();
        System.out.print("Enter edge weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        Vertex sourceVertex = vertexMap.get(sourceName);
        Vertex destVertex = vertexMap.get(destName);

        if (sourceVertex != null && destVertex != null) {
            Edge edge = new Edge(weight, sourceVertex, destVertex);
            edges.add(edge);
            sourceVertex.addNeighbour(edge);
            int sourceIndex = new ArrayList<>(vertexMap.keySet()).indexOf(sourceName);
            int destIndex = new ArrayList<>(vertexMap.keySet()).indexOf(destName);
            matrixOfCost.addEdge(sourceIndex, destIndex, weight);
            System.out.println("Edge added: " + edge);
        } else {
            System.out.println("Source or destination vertex not found.");
        }
    }

    private void removeEdge(Scanner scanner) {
        System.out.print("Enter source vertex name: ");
        String sourceName = scanner.nextLine();
        System.out.print("Enter destination vertex name: ");
        String destName = scanner.nextLine();

        Vertex sourceVertex = vertexMap.get(sourceName);
        Vertex destVertex = vertexMap.get(destName);

        if (sourceVertex != null && destVertex != null) {
            Edge edgeToRemove = null;
            for (Edge edge : edges) {
                if (edge.getStartVertex().equals(sourceVertex) && edge.getTargetVertex().equals(destVertex)) {
                    edgeToRemove = edge;
                    break;
                }
            }

            if (edgeToRemove != null) {
                edges.remove(edgeToRemove);
                sourceVertex.getAdjacenciesList().remove(edgeToRemove);
                int sourceIndex = new ArrayList<>(vertexMap.keySet()).indexOf(sourceName);
                int destIndex = new ArrayList<>(vertexMap.keySet()).indexOf(destName);
                matrixOfCost.removeEdge(sourceIndex, destIndex);
                System.out.println("Edge removed: " + edgeToRemove);
            } else {
                System.out.println("Edge not found.");
            }
        } else {
            System.out.println("Source or destination vertex not found.");
        }
    }

    private void computeShortestPath(Scanner scanner) {
        System.out.print("Enter source vertex name: ");
        String sourceName = scanner.nextLine();
        Vertex sourceVertex = vertexMap.get(sourceName);

        if (sourceVertex != null) {
            dijkstra.computeShortestPaths(sourceVertex);
            System.out.print("Enter target vertex name: ");
            String targetName = scanner.nextLine();
            Vertex targetVertex = vertexMap.get(targetName);

            if (targetVertex != null) {
                List<Vertex> path = dijkstra.getShortestPathTo(targetVertex);
                double distance = targetVertex.getDistance();
                System.out.println("Shortest path: " + path);
                System.out.println("Total distance: " + distance);
            } else {
                System.out.println("Target vertex not found.");
            }
        } else {
            System.out.println("Source vertex not found.");
        }
    }

    private void calculateDistanceBetweenVertices(Scanner scanner) {
        System.out.print("Enter source vertex name: ");
        String sourceName = scanner.nextLine();
        System.out.print("Enter destination vertex name: ");
        String destName = scanner.nextLine();

        Vertex sourceVertex = vertexMap.get(sourceName);
        Vertex destVertex = vertexMap.get(destName);

        if (sourceVertex != null && destVertex != null) {
            dijkstra.computeShortestPaths(sourceVertex);
            double distance = destVertex.getDistance();
            System.out.println("Total distance from " + sourceName + " to " + destName + ": " + distance);
        } else {
            System.out.println("Source or destination vertex not found.");
        }
    }
}