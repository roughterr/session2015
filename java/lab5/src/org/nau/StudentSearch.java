package org.nau;

/**
 * Утилітарний клас, який містить метод для пошуку студента за його ідентифікаційним кодом.
 */
public class StudentSearch {
    /**
     * Здійснює інтерполяційний пошук студента по його ідентифікаційному коду.
     * @param sortedArray відсортований масив студентів, в якому можна здійснювати пошук
     * @param vatin       ідентифікаційний код
     * @return індекс елементу. Якщо не знайдено такого елементу, то значення -1 буде повернуто
     */
    public static int interpolationSearch(Student[] sortedArray, int vatin) {
        int lowIndex = 0;
        int highIndex = sortedArray.length - 1;
        int midIndex;
        while (sortedArray[highIndex].getVatin() != sortedArray[lowIndex].getVatin() &&
                vatin >= sortedArray[lowIndex].getVatin() && vatin <= sortedArray[highIndex].getVatin()) {
            midIndex = lowIndex + (vatin - sortedArray[lowIndex].getVatin()) * ((highIndex - lowIndex) / (sortedArray[highIndex].getVatin() - sortedArray[lowIndex].getVatin()));
            if (sortedArray[midIndex].getVatin() < vatin)
                lowIndex = midIndex + 1;
            else if (vatin < sortedArray[midIndex].getVatin())
                highIndex = midIndex - 1;
            else
                return midIndex;
        }
        if (vatin == sortedArray[lowIndex].getVatin())
            return lowIndex;
        else
            return -1;
    }

    /**
     * Даний мето видаляє студента заочної форми навчання за його ідентифікаційним кодом.
     * @param studentArray масив студентів
     * @param vatin        ідентифікаційний код
     */
    public static void deleteParttimeStudent(Student[] studentArray, int vatin) {
        //Знайти студента
        int index = interpolationSearch(studentArray, vatin);
        if (index != -1 && !studentArray[index].isFullTime()) {
            studentArray[index].deleteStudent();
        }
    }
}
