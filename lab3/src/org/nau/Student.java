package org.nau;

/**
 * Студент.
 */
public class Student {
    /** Прізвище. */
    private String lastname;

    /** Ім’я. */
    private String firstname;

    /** Номер студентського квитка. */
    private int studentCard;

    /** Показує чи студент брав участь в конференціях. */
    private boolean conferenceParticipation;

    /** Показує чи в студента є якісь сертифікати. */
    private boolean doesHaveCertificates;

    /**
     * Конструктор.
     * @param lastname                прізвище
     * @param firstname               ім’я
     * @param studentCard             номер студентського квитка
     * @param conferenceParticipation показує чи студент брав участь в конференціях
     * @param doesHaveCertificates    показує чи в студента є якісь сертифікати
     */
    public Student(String lastname, String firstname, int studentCard, boolean conferenceParticipation,
                   boolean doesHaveCertificates) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.studentCard = studentCard;
        this.conferenceParticipation = conferenceParticipation;
        this.doesHaveCertificates = doesHaveCertificates;
    }

    /**
     * Повертає прізвище студента.
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Повертає ім’я студента.
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Повертає номер студентського квитка.
     * @return
     */
    public int getStudentCard() {
        return studentCard;
    }

    /**
     * Показує чи студент брав участь в конференціях.
     * @return
     */
    public boolean isConferenceParticipation() {
        return conferenceParticipation;
    }

    /**
     * Показує чи в студента є якісь сертифікати.
     * @return
     */
    public boolean isDoesHaveCertificates() {
        return doesHaveCertificates;
    }

    /**
     * Виводить рядок з даними про студента.
     * @return
     */
    public String toString() {
        return "Student: lastname='" + lastname + "', firstname='" + firstname + "', studentCard='" + studentCard +
                "', conferenceParticipation=" + conferenceParticipation + ", doesHaveCertificates=" +
                doesHaveCertificates + ".\n";
    }
}