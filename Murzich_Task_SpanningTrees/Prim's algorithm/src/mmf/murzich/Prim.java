package mmf.murzich;

import java.util.Arrays;

public class Prim {

    public int primAlgorithm(int[][] G, int V) {
        int INF = 7777777;
        int numOfEdges;
        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);
        numOfEdges = 0;
        selected[0] = true;
        System.out.println(" Edge : Weight ");
        int result = 0;
        while (numOfEdges < V - 1) {
            int min = INF;
            int row = 0;
            int col = 0;
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                row = i;
                                col = j;
                            }
                        }
                    }
                }
            }
            System.out.println(row + " - " + col + " :  " + G[row][col]);
            selected[col] = true;
            numOfEdges++;
            result += G[row][col];
        }
        return result;
    }
}