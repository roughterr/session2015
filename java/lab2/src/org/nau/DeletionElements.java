package org.nau;

import java.util.function.Function;

/**
 * Містить метод для видалення тих елементів із хеш-таблиці, в яких площа менша заданої.
 */
public class DeletionElements {
    /**
     * Видаляє елементи із хеш-таблиці
     * @param area мінімальна площа ромба
     * @param hashtable
     */
    public static void deleteElementsWithSmallerArea(final double area, NAUHashtable hashtable) {
        //hashtable.remove(entry -> entry.calculateArea() < area);
        Function<Rhombus, Boolean> functionRemove = new Function<Rhombus, Boolean>() {
            public Boolean apply(final Rhombus rhombus) {
                return rhombus.calculateArea() < area;
            }
        };
        hashtable.remove(functionRemove);
    }
}
