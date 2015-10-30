package org.nau;

import java.util.Arrays;

/**
 * Даний клас містить метод з алгоритмом карманного сортування.
 */
public class BucketSort {
    /**
     * Вираховує максимальний елемент в масиві.
     *
     * @param array
     * @return
     */
    public static int calcMaxValue(int[] array) {
        int maxValue = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] > maxValue)
                maxValue = array[i];
        return maxValue;
    }

    /**
     * Сортує масив, використовуючи алгоритм карманного сортування (bucket sort).
     *
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        final int maxValue = calcMaxValue(array);
        return sort(array, maxValue);
    }

    /**
     * Сортує масив, використовуючи алгоритм карманного сортування (bucket sort).
     *
     * @param array
     * @param maxValue
     * @return
     */
    private static int[] sort(int[] array, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int[] sortedSequence = new int[array.length];
        for (int i = 0; i < array.length; i++)
            bucket[array[i]]++;
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++)
            for (int j = 0; j < bucket[i]; j++)
                sortedSequence[outPos++] = i;
        return sortedSequence;
    }

    /**
     * Сортує масив, використову і вираховує скільки часу пішло на сортування.
     *
     * @param array масив, який потрібно посортувати
     * @return результат сортування
     */
    public static SortingResult sortCountingTime(int[] array) {
        if (array.length == 100)
            System.out.println("Before sorting: " + Arrays.toString(array));
        final long startTimeUnorderedArray1 = java.lang.System.nanoTime();
        int[] sortedArray = BucketSort.sort(array);
        final long finishTimeUnorderedArray1 = java.lang.System.nanoTime();
        if (array.length == 100)
            System.out.println("After sorting: " + Arrays.toString(sortedArray));
        final long sortingTime = finishTimeUnorderedArray1 - startTimeUnorderedArray1;
        return new SortingResult() {
            @Override
            public int[] getSortedArray() {
                return sortedArray;
            }

            @Override
            public double getSortingTime() {
                return sortingTime;
            }
        };
    }

    /**
     * Даний інтерфейс представляє контейнер для об'єктів, які залишаються після сортування масиву, з засікання часу,
     * потраченого на сортування.
     */
    public interface SortingResult {
        /**
         * Повертає відсортований масив.
         *
         * @return
         */
        int[] getSortedArray();

        /**
         * Повертає кількість часу, яке пішло на сортування.
         *
         * @return кількість наносекунд
         */
        double getSortingTime();
    }
}
