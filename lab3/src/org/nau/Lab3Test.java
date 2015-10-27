package org.nau;

import java.util.function.Function;

/**
 * Містить метод для тестування класів для лаби №3. Варіант 18.
 */
public class Lab3Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Student student1 = new Student("Borshchahivska", "Svitlana", 100, false, false);
        Student student2 = new Student("Pikalyuk", "Martha", 70, true, true);
        Student student3 = new Student("Jozeau", "Tom", 80, true, true);
        Student student4 = new Student("Petruniuk", "Petro", 200, true, true);
        Student student5 = new Student("Oleksiychuk", "Bohdan", 150, true, true);
        Student student6 = new Student("Mykhats", "Roman", 90, false, true);
        Student student7 = new Student("Russel", "Michael", 30, true, false);
        //вставка нових елементів в дерево
        tree.add(student1);
        tree.add(student2);//має 2 дочірніх вузли
        tree.add(student3);//цей елемент матиме і батьківський, і дочірній елементи
        tree.add(student4);//має тільки один дочірній вузол
        tree.add(student5);//не має дочірніх вузлів
        tree.add(student6);
        tree.add(student7);
        //вивести дерево на екран після додавання в нього нових елементів
        System.out.println("tree after adding elements:\n" + tree);
        //знайти та видалити вузли дерева за визначеним критерієм пошуку;
        //Критерій пошуку - Студенти 5-го та 6-го курсів, які беруть участь у конференціях та мають сертифікати
        final Function<Student, Boolean> functionDelete = (student) -> {
            if (student.isConferenceParticipation() && student.isDoesHaveCertificates()) {
                return true;
            } else {
                return false;
            }
            //return student.isConferenceParticipation() && student.isDoesHaveCertificates();
        };
        tree.deleteElements(functionDelete);
        //вивести вміст дерева в табличному вигляді
        System.out.println("tree after deleting elements:\n" + tree);
    }
}
