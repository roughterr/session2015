package org.nau;

/**
 * Містить метод для видалення тих елементів із хеш-таблиці, в яких площа менша заданої.
 */
public class DeletionElements {
    /**
     * Видаляє елементи із хеш-таблиці
     * @param area мінімальна площа ромба
     * @param hashtable
     */
    public static <K> void deleteElementsWithSmallerArea(double area, NAUHashtable<K, Rhombus> hashtable) {
        hashtable.remove(entry -> entry.getValue().calcuateArea() < area);
    }
}
