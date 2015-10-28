package org.nau;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Comparator;

/**
 * Тестування лаби №5. Варіант 18.
 */
public class Lab5Test {
    @Test
    public void test1() {
        Student student1 = new Student("Glik", "Denis", 2211864, true);
        Student student2 = new Student("Uzdenov", "Shamil", 2449387, false);
        Student student3 = new Student("Mekhtiev", "Nadar", 33532896, true);
        Student student4 = new Student("Minyuk", "Svitlana", 58704501, true);
        Student student5 = new Student("Ivanova", "Pavla", 67877544, false);
        Student student6 = new Student("Mulin", "Pavel", 152269033, true);
        Student student7 = new Student("Blair", "Brian", 157516796, false);
        Student student8 = new Student("Biblyak", "Vlad", 160012244, true);
        Student student9 = new Student("Hammouda", "Seif", 170220546, true);
        Student student10 = new Student("Mishina", "Lilia", 204100829, true);
        Student student11 = new Student("Allan", "Julia", 214248567, false);
        Student student12 = new Student("Henni", "Mohamed", 219113185, true);
        Student student13 = new Student("Bonev", "Fatkhi", 231145021, true);
        Student student14 = new Student("Badoev", "Hasan", 251613735, false);
        Student student15 = new Student("Griniova", "Ira", 285834419, true);
        Student student16 = new Student("Emaan", "Stayesh", 328464208, false);
        Student student17 = new Student("Kadushko", "Natalya", 153268730, true);
        Student student18 = new Student("Semko", "Yana", 200536644, true);
        Student student19 = new Student("Schukina", "Diana", 219801143, false);
        Student student20 = new Student("Volkov", "Vladislav", 234487071, false);
        Student student21 = new Student("Zadorozhnyuk", " Karina", 239932671, true);
        Student[] students = new Student[]{student1, student2, student3, student4, student5, student6, student7,
                student8, student9, student10, student11, student12, student13, student14, student15, student16,
                student17, student18, student19, student20, student21};
        System.out.println("Students before sorting: ");
        for (Student student : students) {
            System.out.println("Student: " + student);
        }
        //sorting
        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getVatin() == o2.getVatin() ? 0 : o1.getVatin() > o2.getVatin() ? -1 : 1;
            }
        };
        BubbleSort.bubbleSort(students, studentComparator);
        System.out.println("\nStudents after sorting: ");
        for (Student student : students) {
            System.out.println("Student: " + student);
        }
        //Знайти студента з неіснуючим ідентифікаційним кодом
        assertEquals(-1, StudentSearch.interpolationSearch(students, 17));
        //Знайти студента з існуючим ідентифікаційним кодом
        assertTrue("Student Natalya was not found!", StudentSearch.interpolationSearch(students, 153268730) != -1);
        //спробувати видалити студента Vladislav Volkov.
        StudentSearch.deleteParttimeStudent(students, 234487071);
        System.out.println("\nAfter Delete Volkov: ");
        //студент видалиться, бо він підпадає під критерій через те, що він вчиться на заочному.
        for (Student student : students) {
            if (student.getFirstName().equals("Vladislav") && student.getLastName().equals("Volkov")) {
                assertTrue("The student was not deleted.", student.isDeleted());
            }
            System.out.println("Student: " + student);
        }
        //спробувати видалити студента Mohamed Henni.
        StudentSearch.deleteParttimeStudent(students, 219113185);
        System.out.println("\nAfter Mohamed Henni: ");
        //студент не видалиться, бо він не підпадає під критерій через те, що він вчиться на денній формі навчання.
        for (Student student : students) {
            if (student.getFirstName().equals("Mohamed") && student.getLastName().equals("Henni")) {
                assertFalse("The student was not deleted.", student.isDeleted());
            }
            System.out.println("Student: " + student);
        }
    }
}
