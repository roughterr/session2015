package org.nau;

import java.util.function.Function;

/**
 * Хеш-таблиця.
 * @param <K> тип ключа
 * @param <V> тип значення
 */
public class NAUHashtable<K, V> {
    /**
     * Тут зберігатимуться елементи хеш-тиблиці. Створення представлення для запису, а не рознесено на окремі два масиви
     * через те, що в Джава не можна створити масив типу дженерік.
     */
    private HashtableEntry<K, V>[] table;

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
     * @param size
     */
    public NAUHashtable(int size) {
        table = new HashtableEntry[DEFAULT_SIZE];
    }

    /**
     * Розраховує індекс елементу якщо відомий хеш-код ключа елементу.
     * @param hashcode хеш-код ключа елементу
     * @return
     */
    public int calcIndexByHashcode(int hashcode) {
        //0x7FFFFFFF is the biggest number
        int calculatedIndex = (hashcode & Integer.MAX_VALUE) % table.length;
        return calculatedIndex;
    }

    /**
     * Вставляє елемент в хеш-таблицю.
     * @param key
     * @param value
     * @return true - вставка пройшла успішно. false - не вдалось додати елемент
     */
    public boolean put(K key, V value) {
        final int indexOfExisting = findExistingElement(key);
        final int indexToPush;
        if (indexOfExisting == -1) {
            //Знайти найближчу вільну комірку.
            final int indexOfEmpty = findAvailableRoomForEntry(key);
            if (indexOfEmpty == -1)
                return false;
            indexToPush = indexOfEmpty;
        } else {
            indexToPush = indexOfExisting;
        }
        System.out.println("Pushed to the room #" + indexToPush);
        table[indexToPush] = new HashtableEntry<>(key, value);
        return true;
    }

    /**
     * Інкапсулює хешкод з можливістю згенерувати інший хеш-код для того самого ключа,
     * з метою реалізації квадратичного зонування (Quadratic Probing).
     */
    private static class HashCodeToProbe {
        private final int hashcode;
        private final int h;

        public HashCodeToProbe(int hashcode) {
            this.hashcode = hashcode;
            this.h = 1;
        }

        private HashCodeToProbe(int hashcode, int h) {
            this.hashcode = hashcode;
            this.h = h;
        }

        public HashCodeToProbe next() {
            final int newH = h + 1;
            return new HashCodeToProbe(hashcode + (newH * newH), newH);
        }

        public int getHashcode() {
            return hashcode;
        }

        public int getH() {
            return h;
        }
    }

    /**
     * Здійснює пошук елементу в хеш-таблиці.
     * @param key ключ елементу
     * @return індекс елементу. Якщо елемента не знайдено, то повернення значення -1
     */
    public int findExistingElement(K key) {
        for (HashCodeToProbe hashCodeToProbe = new HashCodeToProbe(key.hashCode());
             hashCodeToProbe.getH() < table.length;
             hashCodeToProbe = hashCodeToProbe.next()) {
            final int index = calcIndexByHashcode(hashCodeToProbe.getHashcode());
            HashtableEntry<K, V> element = table[index];
            if (element != null) {
                final boolean resultOfComparison = key.equals(element.getKey());
                if (resultOfComparison) {
                    return index;
                }
            }
        }
        return -1;
    }

    /**
     * Знаходить вільну комірку для нового елементу.
     * @param key ключ елементу
     * @return індекс вільної комірки. Якщо вільної комірки не знайдено, то повернення значення -1
     */
    private int findAvailableRoomForEntry(K key) {
        for (HashCodeToProbe hashCodeToProbe = new HashCodeToProbe(key.hashCode());
             hashCodeToProbe.getH() < table.length;
             hashCodeToProbe = hashCodeToProbe.next()) {
            final int index = calcIndexByHashcode(hashCodeToProbe.getHashcode());
            HashtableEntry<K, V> element = table[index];
            if (element == null)
                return index;
        }
        return -1;
    }

    /**
     * Отримує значення елементу хеш-таблиці.
     * @param key ключ
     * @return значення
     */
    public V get(K key) {
        int index = findExistingElement(key);
        return index == -1 ? null : table[index].getValue();
    }

    /**
     * Виводить інформацію про хеш-таблицю.
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                sb.append("The cell #" + i + " is empty.\n");
            } else {
                sb.append("The cell #" + i + " has key '" + table[i].getKey() + "' and value '" + table[i].getValue() + "'.\n");
            }
        }
        return sb.toString();
    }

    /**
     * Видаляє усі елементи, які для яких виконується певна умова.
     * @param function фукція, яка приймає на вхід ключ і значення елементу хеш-таблиці, а виводить логічне значення.
     */
    public void remove(Function<HashtableEntry<K, V>, Boolean> function) {
        //for (HashtableEntry<K, V> entry : table) {
        for (int i = 0; i < table.length; i++) {
            final HashtableEntry<K, V> entry = table[i];
            if (entry != null) {
                if (function.apply(entry)) {
                    System.out.println("Deleting an element with the next value: " + entry);
                    table[i] = null;
                }
            }
        }
    }

    /**
     * Показує чи вказане значення є в хеш-таблиці.
     * @param value значення запису хеш-таблиці
     * @return true - запис з вказаним значенням існує, false - не існує
     */
    public boolean containsValue(V value) {
        for (HashtableEntry<K, V> entry : table) {
            if (value != null && entry != null && entry.getValue() != null && value.equals(entry.getValue())) {
                return true;
            }
            //return entry == null ? false : value == null && entry.getValue() == null ? true :
            //        value == null || entry.getValue() == null ? false : value.equals(entry.getValue());
        }
        return false;
    }
}
