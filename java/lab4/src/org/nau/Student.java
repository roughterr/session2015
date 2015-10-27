package org.nau;

/**
 * Студент.
 */
public class Student {
    /** Прізвище. */
    private String lastName;

    /** Ім’я. */
    private String firstName;

    /** Чи ходить студент на факультатив. */
    private boolean optionalLessons;

    /** Бал. */
    private int mark;

    /**
     * Конструктор
     * @param lastName        прізвище
     * @param firstName       ім’я
     * @param optionalLessons чи ходить студент на факультатив
     * @param mark            бал
     */
    public Student(String lastName, String firstName, boolean optionalLessons, int mark) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.optionalLessons = optionalLessons;
        this.mark = mark;
    }

    /**
     * Повертає прізвище студента.
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Повертає ім’я студента.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /** Повертає значення змінної, яка показує чи ходить студент на факультатив. */
    public boolean isOptionalLessons() {
        return optionalLessons;
    }

    /**
     * Повертає бал.
     * @return
     */
    public int getMark() {
        return mark;
    }

    public String toString() {
        return "mark='" + mark + "', firstName='" + firstName + "', optionalLessons='" + optionalLessons +
                "', lastName='" + lastName + "'.";
    }
}
