package org.nau;

import java.util.function.Function;

/**
 * Хеш-таблиця.
 *
 * @param <K> тип ключа
 * @param <V> тип значення
 */
public class NAUHashtable<K, V> {
    /**
     * Тут зберігатимуться елементи хеш-тиблиці. Створення представлення для запису, а не рознесено на окремі два масиви
     * через те, що в Джава не можна створити масив типу дженерік.
     */
    //private HashtableEntry<K, V>[] table;

    private Rhombus[] table;

    /**
     * Розмір хеш-таблиці за замовчуванням.
     */
    public static final int DEFAULT_SIZE = 10;

    /**
     * Конструктор.
     */
    public NAUHashtable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Конструктор, в якому можна задати розмір хеш-таблиці.
     *
     * @param size
     */
    public NAUHashtable(int size) {
        //table = new HashtableEntry[DEFAULT_SIZE];
        table = new Rhombus[DEFAULT_SIZE];
    }

    /**
     * Розраховує індекс елементу якщо відомий хеш-код ключа елементу.
     *
     * @param hashcode хеш-код ключа елементу
     * @return
     */
    public int calcIndexByHashcode(int hashcode) {
        //Индекс вычисляется путем применения операции получения
        //остатка от деления ключа на размерность хэш-таблицы.
        //        Например, m=13, key = 24.
        //h(key) = key % m = 11.
        return Math.abs(hashcode) % table.length;
    }

    /**
     * Вставляє елемент в хеш-таблицю.
     *
     * @return true - вставка пройшла успішно. false - не вдалось додати елемент
     */
    public boolean put(Rhombus rhombus) {
        final int calculatedIndex = calcIndexByHashcode((int) rhombus.calculatePerimeter());
        if (table[calculatedIndex] == null) {
            table[calculatedIndex] = rhombus;
            return true;
        }
//        int index = calculatedIndex;
//        int k = 1;
//        //кількість ітерацій має бути не більшою, ніж кількість елементів в масиві
//        for (int i = 0; i < table.length * 2; i++) {
//            if (table[index] != null) {
//                table[index] = rhombus;
//                return true;
//            }
//            k++;
//            index = (index + k * k) % table.length;
//        }
//        return false;
        int index = findFreeRoom(calculatedIndex);
        if (index == -1) {
            return false;
        } else {
            table[index] = rhombus;
            return true;
        }
    }

    private int findFreeRoom(int index) {
        int k = 1;
        //кількість ітерацій має бути не більшою, ніж кількість елементів в масиві
        for (int i = 0; i < table.length * 2; i++) {
            if (table[index] == null) {
                return index;
            }
            k++;
            index = (index + k * k) % table.length;
        }
        return -1;
    }

    /**
     * Здійснює пошук елементу в хеш-таблиці.
     *
     * @param rhombus елемент
     * @return індекс елементу. Якщо елемента не знайдено, то повернення значення -1
     */
    public int findExistingElement(Rhombus rhombus) {
        int index = calcIndexByHashcode((int) rhombus.calculatePerimeter());
        int k = 0;
        //кількість ітерацій має бути не більшою, ніж кількість елементів в масиві
        for (int i = 0; i < table.length * 2; i++) {
            if (table[index] != null && table[index].equals(rhombus)) {
                return index;
            }
            k++;
            index = (index + k * k) % table.length;
        }
        return -1;
    }

    /**
     * Знаходить вільну комірку для нового елементу.
     *
     * @param perimeter периметр як ключ
     * @return індекс вільної комірки. Якщо вільної комірки не знайдено, то повернення значення -1
     */
    private int findAvailableRoomForEntry(int perimeter) {
        int index = calcIndexByHashcode(perimeter);
        int k = 0;
        //кількість ітерацій має бути не більшою, ніж кількість елементів в масиві
        for (int i = 0; i < table.length; i++) {
            //якщо вільну комірку знайдено
            if (table[index] == null) {
                return index;
            }
            k++;
            index = (index + k * k) % table.length;
        }
        return -1;
    }

    /**
     * Отримує значення елементу хеш-таблиці.
     *
     * @param perimeter ключ
     * @return значення
     */
    public Rhombus get(int perimeter) {
        int index = calcIndexByHashcode(perimeter);
        int k = 1;
        if (table[index] != null) {
            return table[index];
        }
        for (int i = 0; i < table.length; i++) {
            //якщо вільну комірку знайдено
            if (table[index] != null) {
                return table[index];
            }
            k++;
            index = (index + k * k) % table.length;
        }
        return null;
    }

    /**
     * Виводить інформацію про хеш-таблицю.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append("The cell #" + i + " is empty.\n");
            } else {
                sb.append("The cell #" + i + " has the next value: " + table[i] + "\n");
            }
        }
        return sb.toString();
    }

    /**
     * Видаляє усі елементи, які для яких виконується певна умова.
     *
     * @param function фукція, яка приймає на вхід ключ і значення елементу хеш-таблиці, а виводить логічне значення.
     */
    public void remove(Function<Rhombus, Boolean> function) {
        //for (HashtableEntry<K, V> entry : table) {
        for (int i = 0; i < table.length; i++) {
            final Rhombus rhombus = table[i];
            if (rhombus != null) {
                if (function.apply(rhombus)) {
                    System.out.println("Deleting an element with the next value: " + rhombus);
                    table[i] = null;
                }
            }
        }
    }

    /**
     * Показує чи вказане значення є в хеш-таблиці.
     *
     * @param value значення запису хеш-таблиці
     * @return true - запис з вказаним значенням існує, false - не існує
     */
    public boolean containsValue(Rhombus value) {
        for (Rhombus rhombus : table) {
            if (value != null && rhombus != null && value.equals(rhombus)) {
                return true;
            }
        }
        return false;
    }
}
