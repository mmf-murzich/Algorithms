package mmf.murzich;

public class Searches {

    public static int linearSearch(int[] array, int numberToSearch) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == numberToSearch)
                return i;
        return -1;
    }

    public static int binarySearch(int[] array, int numberToSearch) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            if (array[middleIndex] == numberToSearch)
                return middleIndex;
            else if (array[middleIndex] < numberToSearch)
                startIndex = middleIndex + 1;
            else
                endIndex = middleIndex - 1;
        }
        return -1;
    }

    public static int interpolationSearch(int[] array, int numberToSearch) {
        int startIndex = 0;
        int endIndex = array.length - 1;

        while ((startIndex <= endIndex) && (numberToSearch >= array[startIndex]) &&
                (numberToSearch <= array[endIndex])) {
            // формула интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = startIndex + (((endIndex-startIndex) / (array[endIndex]-array[startIndex])) * (numberToSearch - array[startIndex]));
            if (array[pos] == numberToSearch)
                return pos;
            else if (array[pos] < numberToSearch)
                startIndex = pos + 1;
            else
                endIndex = pos - 1;
        }
        return -1;
    }
}
