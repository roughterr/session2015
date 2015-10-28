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
        int low = 0;
        int high = sortedArray.length - 1;
        int mid;
        while (sortedArray[low].getVatin() <= vatin && sortedArray[high].getVatin() >= vatin) {
            if (sortedArray[high].getVatin() - sortedArray[low].getVatin() == 0)
                return (low + high) / 2;
            mid = low + ((vatin - sortedArray[low].getVatin()) * (high - low)) / (sortedArray[high].getVatin() - sortedArray[low].getVatin());
            if (sortedArray[mid].getVatin() < vatin)
                low = mid + 1;
            else if (sortedArray[mid].getVatin() > vatin)
                high = mid - 1;
            else
                return mid;
        }
        if (sortedArray[low].getVatin() == vatin)
            return low;
        else
            return -1;
    }

    /**
     * Даний мето видаляє студента заочної форми навчання за його ідентифікаційним кодом.
     * @param studentArray масив студентів
     * @param vatin        ідентифікаційний код
     * @return масив без видаленого студента
     */
    public static Student[] deleteParttimeStudent(Student[] studentArray, int vatin) {
        //Знайти студента
        int index = interpolationSearch(studentArray, vatin);
        System.out.println("Search completed.");
        if (index != -1 && studentArray[index].isFullTime()) {
            Student[] newArr = new Student[studentArray.length - 1];
            int newArrIndex = 0;
            for (int i = 0; i < studentArray.length; i++) {
                if (index != i) {
                    newArr[newArrIndex] = studentArray[i];
                    newArrIndex++;
                }
            }
            return newArr;
        }
        return studentArray;
    }
}
