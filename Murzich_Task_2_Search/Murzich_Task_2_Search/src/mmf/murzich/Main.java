package mmf.murzich;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Массив содержит 2^20 элементов.
        int[] array = new int[1048576];
        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * 7777777);
        }
        int numberToSearch = (int)(Math.random() * 7777777);
        System.out.println("Number to search: " + numberToSearch);
        int index;
        double startTime;
        double finishTime;
        double requiredTime;

        //Реализация последовательного поиска
        startTime = System.nanoTime();
        index = Searches.linearSearch(array, numberToSearch);
        finishTime = System.nanoTime();
        requiredTime = finishTime - startTime;
        System.out.println("Linear Search: " + requiredTime / 1000000 + " ms");
        //Arrays.sort(array);

        //Реализация бинарного поиска
        startTime = System.nanoTime();
        index = Searches.binarySearch(array, numberToSearch);
        finishTime = System.nanoTime();
        requiredTime = finishTime - startTime;
        System.out.println("Binary Search: " + requiredTime / 1000000 + " ms");

        //Реализация интерполяционного поиска
        startTime = System.nanoTime();
        index = Searches.interpolationSearch(array, numberToSearch);
        finishTime = System.nanoTime();
        requiredTime = finishTime - startTime;
        System.out.println("Interpolation Search: " + requiredTime / 1000000 + " ms");
    }
}


