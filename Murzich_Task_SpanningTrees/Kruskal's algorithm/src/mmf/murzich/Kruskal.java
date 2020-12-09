package mmf.murzich;

import java.util.*;

public class Kruskal {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

    static class subset {
        int parent, rank;
    };

    int vertices, edges;
    Edge[] edge;

    Kruskal(int vertices, int edges)
    {
        this.vertices = vertices;
        this.edges = edges;
        edge = new Edge[this.edges];
        for (int i = 0; i < edges; ++i) edge[i] = new Edge();
    }

    int find(subset[] subsets, int i) {
        if (subsets[i].parent != i) subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank) subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    int kruskalAlgorithm() {
        Edge[] result = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i) result[i] = new Edge();
        Arrays.sort(edge);
        subset[] subsets = new subset[vertices];
        for (i = 0; i < vertices; ++i) subsets[i] = new subset();
        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < vertices - 1) {
            new Edge();
            Edge next_edge;
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        int minimumCost = 0;
        for (i = 0; i < e; ++i) minimumCost += result[i].weight;
        return minimumCost;
    }
}