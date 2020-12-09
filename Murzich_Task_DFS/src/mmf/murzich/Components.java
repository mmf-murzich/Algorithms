package mmf.murzich;

public class Components {
    private final int[][] matrix;
    private final boolean[] visited;
    private final int[] component;

    public Components(int[][] matrix)
    {
        this.matrix = matrix;
        this.visited = new boolean[matrix.length];
        this.component = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            this.visited[i] = false;
            this.component[i] = 0;
        }
    }

    public void depthFirstSearch(int v, int components) {

        visited[v] = true;
        component[v] = components;
        for (int i = 0; i < this.matrix.length; i++) {
            if (this.matrix[v][i] == 1 && !visited[i]) depthFirstSearch(i, components);
        }
    }

    public String maxComponents() {

        int component = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            if (!this.visited[i]) {
                depthFirstSearch(i, component);
                component++;
            }
        }
        if (component == 1) return "Можно перезнакомить всех.";
        else {
            int max = 0;
            int[] arr = new int[component];
            for (int i = 0; i < component; i++) arr[i] = 0;
            for (int i = 0; i < this.matrix.length; i++) arr[this.component[i]]++;
            for (int i = 0; i < component; i++) if (max < arr[i]) max = arr[i];
            return "Максимальное количество знакомых людей: " + max;
        }
    }
}