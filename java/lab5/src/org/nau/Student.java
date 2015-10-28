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

    public Student(String lastName, String firstName, int vatin, boolean isFullTime) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.vatin = vatin;
        this.isFullTime = isFullTime;
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
                isFullTime + "'.";
    }
}
