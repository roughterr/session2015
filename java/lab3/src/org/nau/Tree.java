package org.nau;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Клас, що представляє дерево.
 */
public class Tree {
    /** Посилання на корінь дерева. */
    private Node root;

    /**
     * Видаляє елементи за певним критерієм.
     * @param function критерій для видалення елементів
     */
    public void deleteElements(Function<Student, Boolean> function) {
        if (root == null)
            return;
        Node zeroNode = new Node(null);
        zeroNode.setLeft(root);
        //наступний рядок для наглядності
        zeroNode.setRight(null);
        deleteElementsOfNode(function, zeroNode);
        root = zeroNode.getLeft();
    }

    private void deleteElementsOfNode(Function<Student, Boolean> function, final Node node) {
        if (node == null)
            return;
        //почистити ліве піддерево
        {
            final Node leftNode = node.getLeft();
            if (leftNode != null) {
                //якщо перший елемент в лівому піддереві має бути видалений
                if (function.apply(leftNode.getData())) {
                    deleteElement(leftNode, (nodeToReplace) -> {
                        node.setLeft(nodeToReplace);
                    });
                    deleteElementsOfNode(function, node);
                } else {
                    deleteElementsOfNode(function, leftNode);
                }
            }
        }
        //почистити праве піддерево
        {
            final Node rightNode = node.getRight();
            if (rightNode != null) {
                //якщо перший елемент в лівому піддереві має бути видалений
                if (function.apply(rightNode.getData())) {
                    deleteElement(rightNode, (nodeToReplace) -> {
                        node.setRight(nodeToReplace);
                    });
                    deleteElementsOfNode(function, node);
                } else {
                    deleteElementsOfNode(function, rightNode);
                }
            }
        }
    }

    /**
     * Виведення всього дерева. Використовується алгоритм "обхід в ширину".
     * @return
     */
    public String toString() {
        if (root == null) {
            return "Empty tree.";
        }
        return showElementTree(root, 0);
    }

    /**
     * Виводить рядок з відображенням елементу дерева і всіх його дочірніх елементів.
     * @param currentNode
     * @param level
     * @return
     */
    private String showElementTree(Node currentNode, int level) {
        StringBuffer sb = new StringBuffer();
        if (currentNode == null)
            return "";
        for (int i = 0; i < level; i++) {
            sb.append("    ");
        }
        sb.append(currentNode.getData().toString());
        final int newLevel = level + 1;
        sb.append(showElementTree(currentNode.getLeft(), newLevel));
        sb.append(showElementTree(currentNode.getRight(), newLevel));
        return sb.toString();
    }

    /**
     * Додає новий елемент в дерево.
     * @param student студент
     * @return якщо вставка пройшла успішно, буде повернуто значення true
     */
    public boolean add(Student student) {
        //упаковка елемента в обгортку
        final Node node = new Node(student);
        if (root == null) {
            root = node;
            return true;
        } else {
            return add(node, root);
        }
    }

    /**
     * Додає новий елемент в дерево. Алгоритм наступний:
     * <ul>
     * <li>новый элемент (узел) всегда становится листом дерева</li>
     * <li>поиск позиции начинается с вершины дерева, постепенно смещаясь вниз</li>
     * <li>если значение нового узла меньше текущего, то переходим в левую ветку текущего узла</li>
     * <li>если левый узел у текущего отсутствует, то новый узел становится его левым узлом</li>
     * <li>если значения нового узла больше текущего, то переходим в правую ветку текущего узла</li>
     * <li>если правый узел у текущего отсутствует, то новый узел становится его правым узлом</li>
     * </ul>
     * @param newElem  елемент, який має бути додано в дерево
     * @param currElem елемент дерева, піделементом якого новий елемент буде
     * @return якщо вставка пройшла успішно, буде повернуто значення true
     */
    public boolean add(Node newElem, Node currElem) {
        if (newElem.getData().getStudentCard() == currElem.getData().getStudentCard()) {
            return false;
        }
        //если значение нового узла меньше текущего, то переходим в левую ветку текущего узла
        if (newElem.getData().getStudentCard() < currElem.getData().getStudentCard()) {
            //System.out.println("The value of the new element is less than the value of the current element.");
            final Node leftNode = currElem.getLeft();
            if (leftNode == null) {
                currElem.setLeft(newElem);
            } else {
                return add(newElem, leftNode);
            }
        } //если значения нового узла больше текущего, то переходим в правую ветку текущего узла
        else {
            final Node rightNode = currElem.getRight();
            //если правый узел у текущего отсутствует, то новый узел становится его правым узлом
            if (rightNode == null) {
                currElem.setRight(newElem);
            } else {
                return add(newElem, rightNode);
            }
        }
        return true;
    }

    /**
     * Видаляє елемент з дерева. Алгоритм наступний:
     * <ol>
     * <li>Найти удаляемый узел</li>
     * <li>Оценить имеет ли найденный узел левое и правое поддерево:
     * <ul>
     * <li>не имеет (ссылка обнуляется)</li>
     * <li>имеет либо левое, либо правое поддерево (ссылка переопределяется в соответствующее поддерево)</li>
     * <li>имеет оба поддерева (осуществляется поиск узла, стоящего на самом низшем уровне (лист) для замены
     * удаляемого)</li>
     * </ul>
     * </li>
     * </ol>
     * Существует два варианта поиска узла для замены:
     * <ul>
     * <li>самый крайний правый узел в левом поддереве</li>
     * <li>самый крайний левый узел в правом поддереве</li>
     * <ul/>
     * @param nodeToBeDeleted   елемент, який має бути видалений
     * @param functionToReplace фукція для заміщення елемента, який має бути видалений, іншим елементом
     */
    private void deleteElement(Node nodeToBeDeleted, Consumer<Node> functionToReplace) {
        //System.out.println("Deleting the next student: " + nodeToBeDeleted.getData());
        if (nodeToBeDeleted.getLeft() == null && nodeToBeDeleted.getRight() == null) {
            functionToReplace.accept(null);
        } else if (nodeToBeDeleted.getLeft() == null ^ nodeToBeDeleted.getRight() == null) {
            functionToReplace.accept(nodeToBeDeleted.getLeft() == null ? nodeToBeDeleted.getRight() :
                    nodeToBeDeleted.getLeft());
        } else {
            final Node rightSubtree = nodeToBeDeleted.getRight();
            //пошук найлівішого елементу в правому піддереві
            Node theMostLeft = rightSubtree;
            while (theMostLeft.getLeft() != null) {
                theMostLeft = theMostLeft.getLeft();
            }
            functionToReplace.accept(theMostLeft);
            //приєднати лівий
            theMostLeft.setLeft(nodeToBeDeleted.getLeft());
            //Щоб не було циклічної залежності
            if (nodeToBeDeleted.getRight() != theMostLeft)
                theMostLeft.setRight(nodeToBeDeleted.getRight());
        }
    }
}
