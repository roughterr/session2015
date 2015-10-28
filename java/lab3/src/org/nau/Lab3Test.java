package org.nau;

import java.util.function.Function;

/**
 * Містить метод для тестування класів для лаби №3. Варіант 18.
 */
public class Lab3Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Student student1 = new Student("Borshchahivska", "Svitlana", 12, 1, false, false);
        Student student2 = new Student("Pikalyuk", "Martha", 15, 2, true, true);
        Student student3 = new Student("Jozeau", "Tom", 16, 3, true, true);
        Student student4 = new Student("Petruniuk", "Petro", 18, 4, true, true);
        Student student5 = new Student("Oleksiychuk", "Bohdan", 17, 150, true, true);
        Student student6 = new Student("Mykhats", "Roman", 1, 4, false, true);
        Student student7 = new Student("Russel", "Michael", 0, 2, true, false);
        Student student8 = new Student("Yonus", "Usman", 4, 2, true, false);
        //вставка нових елементів в дерево
        tree.add(student1);
        tree.add(student2);//має 2 дочірніх вузли
        tree.add(student3);//цей елемент матиме і батьківський, і дочірній елементи
        tree.add(student4);//має тільки один дочірній вузол
        tree.add(student5);//не має дочірніх вузлів
        tree.add(student6);
        tree.add(student7);
        tree.add(student8);
        //вивести дерево на екран після додавання в нього нових елементів
        System.out.println("tree after adding elements:\n" + tree);
        //знайти та видалити вузли дерева за визначеним критерієм пошуку;
        //Критерій пошуку - Студенти 5-го та 6-го курсів, які беруть участь у конференціях та мають сертифікати
        final Function<Student, Boolean> functionDelete = (student) -> {
            if (student.isConferenceParticipation() && student.isDoesHaveCertificates()
                    && (student.getCourse() == 5 || student.getCourse() == 6)) {
                return true;
            } else {
                return false;
            }
            //return student.isConferenceParticipation() && student.isDoesHaveCertificates();
        };
        tree.deleteElements(functionDelete);
        //вивести вміст дерева в табличному вигляді
        System.out.println("tree after deleting elements:\n" + tree);
        //видалити студента номер 12
        tree.deleteElements(student -> {
            return student.getStudentCard() == 12;
        });
        System.out.println("after deleting student #12:\n" + tree);
        //видалити студента номер 1
        tree.deleteElements(student -> {
            return student.getStudentCard() == 1;
        });
        System.out.println("after deleting student #1:\n" + tree);
    }
}
