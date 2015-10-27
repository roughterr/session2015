package org.nau;

import java.util.Arrays;

/**
 * Черга з цілими беззнаковими елементами.
 */
public class Queue {
    /**
     * Кількість резервних комірок в масиві.
     */
    private static final int RESERVE_CELLS = 5;

    /**
     * У цьому масиві міститимуться усі елементи черги.
     */
    private int[] array;

    /**
     * Індекс останнього доданого елементу.
     */
    private int youngestElementIndex;

    /**
     * Індекс найстарішого доданого елементу.
     */
    private int oldestElementIndex;

    /**
     * Конструктор.
     */
    public Queue() {
        array = new int[RESERVE_CELLS];
        youngestElementIndex = -1;
        oldestElementIndex = -1;
    }

    /**
     * Перевіряє наповненість структури даних (чи дорівнює довжина масиву кількості елементів у структурі даних) та
     * викликається в операції вставки для запобігання додавання елемента в цілком заповнену структуру даних.
     *
     * @return true - масив заповнено, false - в масиві ще є вільні комірки
     */
    public boolean isFull() {
        return array.length <= (youngestElementIndex + 1);
    }

    /**
     * Перевіряє порожність структури даних (чи дорівнює нулю кількість елементів у структурі даних) та викликається в
     * операції видалення для запобігання отриманню елемента з порожньої структури даних.
     *
     * @return true - черга є порожньою і з неї не можна нічого видалити, false - в черзі елементи, які можна видаляти.
     */
    public boolean isEmpty() {
        return oldestElementIndex == -1 || oldestElementIndex > youngestElementIndex;
    }

    /**
     * Збільшує розмір масиву якщо уже заповнений.
     */
    private void rebuildArray() {
        System.out.println("Method rebuildArray() called.");
        //порахувати поточну кількість заповнених комірок.
        final int capturedCells = youngestElementIndex - oldestElementIndex + 1;
        System.out.println("capturedCells='" + capturedCells + "'.");
        //визначення довжини нового масиву
        final int newArrayLength = capturedCells + RESERVE_CELLS;
        //створення нового масиву
        int[] newArray = new int[newArrayLength];
        //Індекс нового масиву.
        int newArrayIndex = 0;
        //перекидування елементів зі старого масиву в новий
        //i - це індекс, який застососується до старого масиву.
        for (int i = oldestElementIndex; i <= youngestElementIndex; i++) {
            newArray[newArrayIndex] = array[i];
            newArrayIndex++;
        }
        //встановлення змінних класу
        array = newArray;
        oldestElementIndex = capturedCells > 0 ? 0 : -1;
        youngestElementIndex = capturedCells - 1;
    }

    /**
     * Вставка нового елементу у структура даних.
     *
     * @return true -  операція була виконана успішно
     */
    public boolean add(int val) {
        if (isEmpty())
            oldestElementIndex++;
        if (isFull())
            rebuildArray();
        //збільшення індексу останнього елемента на одиницю
        youngestElementIndex++;
        array[youngestElementIndex] = val;
        return true;
    }

    @Override
    public String toString() {
        return "array='" + Arrays.toString(array) + "', youngestElementIndex='" + youngestElementIndex +
                "', oldestElementIndex='" + oldestElementIndex + "'.";
    }

    /**
     * Видаляє найстаріший елемент з черги.
     *
     * @return значення елемента, що видаляється
     * @throws Exception виключення може бути викинуто якщо в черзі немає елементів
     */
    public int deleteOldestElement() throws Exception {
        if (isEmpty())
            throw new Exception("there was an attempt to remove an element from an empty queue.");
        //витягування значення елемента, який має бути видалений
        final int valueOfDeletedElement = array[oldestElementIndex];
        System.out.println("The value of the element that is going to be deleted is '" + valueOfDeletedElement + "'.");
        //індекс настарішого елемента збільшується на одиницю
        oldestElementIndex++;
        return valueOfDeletedElement;
    }
}
