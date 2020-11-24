package mmf.murzich;

// Граф задан матрицей смежности A.
// Проверить, является ли он двудольным.

public class Main {

    public static void main(String[] args) {
        int[][] A = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 } };

        if (Bipartite.isBipartite(A))
            System.out.println("Верно. Граф является двудольным");
        else
            System.out.println("Неверно. Граф не является двудольным");
    }
}
