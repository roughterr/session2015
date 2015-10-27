package org.nau;

/**
 * Даний клас представляє елемент хеш-таблиці.
 * @param <K> тип ключа
 * @param <V> тип значення
 */
public class HashtableEntry<K, V> {
    /**
     * Ключ елемента хеш-таблиці.
     */
    private final K key;
    /**
     * Значення елемента хеш-таблиці.
     */
    private final V value;

    /**
     * Конструктор.
     * @param key   ключ елемента хеш-таблиці
     * @param value значення елемента хеш-таблиці
     */
    public HashtableEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Повертає ключ елемента хеш-таблиці.
     * @return
     */
    public K getKey() {
        return key;
    }

    /**
     * Повертає значення елемента хеш-таблиці.
     * @return
     */
    public V getValue() {
        return value;
    }

    public String toString() {
        return "key='" + key + "', value='" + value + "'.";
    }
}
