package org.nau;

/**
 * Студент. Варіант 18.
 * Поля класу: Прізвище, ім’я, ідентифікаційний код, умова навчання (денна/заочна).
 */
public class Student {
    /** Прізвище. */
    private String lastName;

    /** Ім’я. */
    private String firstName;

    /** Ідентифікаційний код. */
    private int vatin;

    /** Змінна, яка вказує чи студент вчиться на денній формі навчання чи заочній. */
    private boolean isFullTime;

    /** Показує чи студент має бути присутній в системі (значення true означає, що він був видалений). */
    private boolean deleted;

    /**
     * Конструктор.
     * @param lastName прізвище
     * @param firstName ім’я
     * @param vatin ідентифікаційний код
     * @param isFullTime вказує чи студент вчиться на денній формі навчання чи заочній
     */
    public Student(String lastName, String firstName, int vatin, boolean isFullTime) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.vatin = vatin;
        this.isFullTime = isFullTime;
        this.deleted = false;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getVatin() {
        return vatin;
    }

    /**
     * @return true - студент вчиться на денній формі навчання, false - студент вчиться на заочній формі навчання.
     */
    public boolean isFullTime() {
        return isFullTime;
    }

    public String toString() {
        return "vatin='" + vatin + "', lastName='" + lastName + "', firstName='" + firstName + "', isFullTime='" +
                isFullTime + "', deleted='" + deleted + "'.";
    }

    /**
     * Показує чи студент не був часом видалений.
     * @return true - студента було видалено
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * Видаляє студента із системи.
     */
    public void deleteStudent() {
        System.out.println("Calling deleteStudent");
        this.deleted = true;
    }

    /**
     * Повертає студента із видаленого стану в нормальний.
     */
    public void undeleteStudent() {
        this.deleted = deleted;
    }
}
