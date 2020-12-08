package mmf.murzich;

public class Euler {
    private final String[] words;

    public Euler(String[] words) {
        this.words = words;
    }

    public static void print(int[][] matrix){
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) System.out.print(ints[j]);
            System.out.println();
        }
    }

    public static int[][] createMatrix(String[] arr){
        int[][] matrix = new int[32][32];
        for (String s : arr) matrix[(int) s.charAt(0) - 1040][(int) s.charAt(s.length() - 1) - 1072] = 1;
        //print(matrix);
        return matrix;
    }

    public boolean eulerMethod(){
        int[][] matrix = createMatrix(this.words);
        int line = 0;
        int column = 0;
        int counter = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++) line += matrix[i][j];
            for (int[] ints : matrix) column += ints[i];
            if (line == column) counter++;
        }
        return counter == matrix.length;
    }
}