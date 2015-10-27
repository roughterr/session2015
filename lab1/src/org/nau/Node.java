package org.nau;

/**
 * Представляє один елемент двоспрямованого списку.
 */
public class Node {
    /**
     * Конструктор без параметрів.
     */
    public Node() {
    }

    /**
     * Конструктор з передачею значення.
     *
     * @param val
     */
    public Node(int val) {
        this.val = val;
    }

    /**
     * посилання на попередній елемент.
     */
    private Node previousNode;

    /**
     * посилання на наступний елемент.
     */
    private Node nextNode;

    /**
     * значення цього елементу.
     */
    private int val;

    /**
     * Виводить попередній елемент.
     *
     * @return
     */
    public Node getPreviousNode() {
        return previousNode;
    }

    /**
     * Встановлює попередній елемент.
     *
     * @param previousNode
     */
    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    /**
     * Виводить наступний елемент.
     *
     * @return
     */
    public Node getNextNode() {
        return nextNode;
    }

    /**
     * Встановлює наступний елемент.
     *
     * @param nextNode
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Повертає значення даної ноди.
     *
     * @return
     */
    public int getVal() {
        return val;
    }

    /**
     * Встановлює значення даної ноди.
     *
     * @param val
     */
    public void setVal(int val) {
        this.val = val;
    }
}
