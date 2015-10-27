package org.nau;

import java.util.Arrays;

import org.junit.Test;

/**
 * Тестування лаби №4.
 */
public class Lab4Test {
    @Test
    public void test1() {
        Student student1 = new Student("Pomidor", "Ivan", false, 12);
        Student student2 = new Student("Dugin", "Ivan", false, 3);
        Student student3 = new Student("Prytula", "Dima", false, 4);
        Student student4 = new Student("Shah", "Vladyslav", false, 2);
        Student student5 = new Student("Koval", "Oleksandr", false, 6);
        Student student6 = new Student("Borshchyk", "Oleg", false, 8);
        Student[] students = new Student[]{student1, student2, student3, student4, student5, student6};
        //вивести вміст одновимірного масиву перед сортуванням
        System.out.println("Before the sorting:");
        for (Student student : students) {
            System.out.println("student: " + student);
        }
        //сортувати одновимірний масив
        BubbleSort.bubbleSort(students, BubbleSort.studentComparator);
        //вивести вміст одновимірного масиву після сортування
        System.out.println("\nAfter the sorting:");
        for (Student student : students) {
            System.out.println("student: " + student);
        }
    }
}
