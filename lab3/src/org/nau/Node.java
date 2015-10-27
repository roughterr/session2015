package org.nau;

/**
 * Представляє вузол дерева.
 */
public class Node {
    /** Значення вузла дерева. */
    private Student data;

    /** Left child. */
    private Node left;

    /** Right child. */
    private Node right;

    /**
     * Конструктор.
     * @param data
     */
    public Node(Student data) {
        this.data = data;
    }

    public Student getData() {
        return data;
    }

    public void setData(Student data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
