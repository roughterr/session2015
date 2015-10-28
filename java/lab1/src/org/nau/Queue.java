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
     * Індекс найновішого елементу в черзі.
     */
    private int headIndex;

    /**
     * Конструктор.
     */
    public Queue() {
        array = new int[RESERVE_CELLS];
        headIndex = -1; //на початку у нас в черзі немає елементів
    }

    /**
     * Перевіряє наповненість структури даних (чи дорівнює довжина масиву кількості елементів у структурі даних) та
     * викликається в операції вставки для запобігання додавання елемента в цілком заповнену структуру даних.
     *
     * @return true - масив заповнено, false - в масиві ще є вільні комірки
     */
    public boolean isFull() {
        return (headIndex + 1) == array.length;
    }

    /**
     * Перевіряє порожність структури даних (чи дорівнює нулю кількість елементів у структурі даних) та викликається в
     * операції видалення для запобігання отриманню елемента з порожньої структури даних.
     *
     * @return true - черга є порожньою і з неї не можна нічого видалити, false - в черзі елементи, які можна видаляти.
     */
    public boolean isEmpty() {
        return headIndex == -1;
    }

    /**
     * Вставка нового елементу у структура даних.
     *
     * @return true -  операція була виконана успішно
     */
    public boolean add(int val) {
        if (isFull()) {
            return false;
        } else {
            headIndex++;
            array[headIndex] = val;
            return true;
        }
    }

    @Override
    public String toString() {
        return "array='" + Arrays.toString(array) + "', headIndex='" + headIndex + "'.";
    }

    /**
     * Видаляє найстаріший елемент з черги.
     *
     * @return значення елемента, що видаляється
     * @throws Exception виключення може бути викинуто якщо в черзі немає елементів
     */
    public int deleteOldestElement() throws Exception {
        if (isEmpty()) {
            System.out.println("there was an attempt to remove an element from an empty queue.");
            return 0;
            // throw new Exception("there was an attempt to remove an element from an empty queue.");
        }
        //найстаріший елемент має індекс 0 в масиві
        final int val2return = array[0];
        //зміщення усіх елементів назад.
        int[] newArr = new int[array.length];
        for (int i = 1; i <= headIndex; i++) {
            newArr[i - 1] = array[i];
        }
        headIndex--;
        array = newArr;//заміна старого масиву на новий
        return val2return;
    }
}
