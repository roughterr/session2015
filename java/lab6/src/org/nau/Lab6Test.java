package org.nau;

/**
 * Тестування лаби №6. Варіант 18.
 */
public class Lab6Test {
    public static final int N = 100;

    public static final int TEST_TIMES = 5;

    public static void main(String[] args) {
        testSortingTimeOneArray(N);
        testSortingTimeOneArray(N * N);
        testSortingTimeOneArray(N * N * N);
    }

    /**
     * @param sizeOfArray кількість елементів в масиві, який буде створюватися
     */
    private static void testSortingTimeOneArray(int sizeOfArray) {
        System.out.println("Starting method testSortingTimeOneArray with the next size of the array: " + sizeOfArray);
        double sumTimeUnsortedArray = 0.0;
        double sumTimeSortedArray = 0.0;
        for (int i = 0; i < TEST_TIMES; i++) {
            //generate a new array
            //System.out.println("Creating an array with the next number of elements: sizeOfArray='" + sizeOfArray + ".");
            int[] array = new int[sizeOfArray];
            //fill an array with random numbers
            fillArrayWithRandomNumbers(array);
            //sort
            BucketSort.SortingResult sortingResultArray1 = BucketSort.sortCountingTime(array);
            //System.out.println("Time needed for sorting array (nanoseconds): " + sortingResultArray1.getSortingTime());
            sumTimeUnsortedArray += sortingResultArray1.getSortingTime();
            //System.out.println("array after sorting: " + Arrays.toString(sortingResultArray1.getSortedArray()));
            //повторне сортування масиву
            BucketSort.SortingResult sortingResultSortedArray1 = BucketSort.sortCountingTime(array);
            //System.out.println("Time needed for sorting a sorted array (nanoseconds): " + sortingResultSortedArray1.getSortingTime());
            sumTimeSortedArray += sortingResultSortedArray1.getSortingTime();
        }
        double averageTimeSortingUnsortedArray = sumTimeUnsortedArray / TEST_TIMES;
        double averageTimeSortingSortedArray = sumTimeSortedArray / TEST_TIMES;
        System.out.println("averageTimeSortingUnsortedArray='" + averageTimeSortingUnsortedArray + "'.");
        System.out.println("averageTimeSortingSortedArray='" + averageTimeSortingSortedArray + "'.");
    }

    private static void fillArrayWithRandomNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            final double randomNumberDouble = java.lang.Math.random() * 1000;
            array[i] = (int) randomNumberDouble;
        }
    }
}
