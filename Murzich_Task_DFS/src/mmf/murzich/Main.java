package mmf.murzich;

public class Main {

    public static void main(String[] args) {

        int[][] A = {
                { 0, 1, 0, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 } };
        System.out.println("На олимпиаду прибыло " + A.length + " человек.");
        Components acquaintances = new Components(A);
        System.out.println(acquaintances.maxComponents());
    }
}