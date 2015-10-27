package org.nau;

import java.util.Comparator;

/**
 * Містить метод з алгоритмом бульбашкового сортування.
 * Сортування має здійснюватися за зростанням бала навчання.
 */
public class BubbleSort {
    /**
     * Сортує елементи в масиві, використовуючи алгоритм бульбашкового сортування.
     * @param arr масив з об’єктами
     * @return
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        boolean isThereSomethingToSort = true;
        while (isThereSomethingToSort) {
            isThereSomethingToSort = false;
            for (int i = 1; i < arr.length; i++) {
                final T prevObj = arr[i - 1];
                final T thisObj = arr[i];
                final int resultOfComparison = comparator.compare(prevObj, thisObj);
                if (resultOfComparison == 0 || resultOfComparison > 0) {

                } else {
                    arr[i - 1] = thisObj;
                    arr[i] = prevObj;
                    isThereSomethingToSort = true;
                }
            }
        }
    }

    /**
     * Містить порівняння двох студентів за їх балами.
     */
    public final static Comparator<Student> studentComparator = new Comparator<Student>() {
        public int compare(Student student1, Student student2) {
            return student1.getMark() == student2.getMark() ? 0 : student1.getMark() > student2.getMark() ? -1 : 1;
        }
    };
}
