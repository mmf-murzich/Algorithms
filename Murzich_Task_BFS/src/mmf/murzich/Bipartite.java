package mmf.murzich;

import java.util.*;

public class Bipartite {

    public static int V = 5;

    public static boolean isBipartiteUtil(int[][] A, int src, int[] colorArr) {
        colorArr[src] = 1;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()) {
            int u = q.getFirst();
            q.pop();
            if (A[u][u] == 1)
                return false;
            for (int v = 0; v < V; ++v) {
                if (A[u][v] == 1 && colorArr[v] == -1) {
                    colorArr[v] = 1 - colorArr[u];
                    q.push(v);
                }
                else if (A[u][v] == 1
                        && colorArr[v] == colorArr[u])
                    return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int[][] A) {
        int[] colorArr = new int[V];
        for (int i = 0; i < V; ++i)
            colorArr[i] = -1;
        for (int i = 0; i < V; i++)
            if (colorArr[i] == -1)
                if (!isBipartiteUtil(A, i, colorArr))
                    return false;
        return true;
    }
}