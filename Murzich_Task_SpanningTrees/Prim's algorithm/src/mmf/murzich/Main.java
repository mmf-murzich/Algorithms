package mmf.murzich;

public class Main {

    public static void main(String[] args) {
        Prim graph = new Prim();
        // number of vertices in graph
        int V = 5;
        // adjacency matrix for graph representation
        int[][] G = {
                { 0, 9, 75, 0, 0 },
                { 9, 0, 95, 19, 42 },
                { 75, 95, 0, 51, 66 },
                { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };
        System.out.println("Minimum spanning tree mass: " + graph.primAlgorithm(G, V));
    }
}