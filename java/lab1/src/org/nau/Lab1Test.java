package org.nau;

/**
 * Тестування першої лаби. Варіант №18.
 */
public class Lab1Test {
    public static void main(String[] args) throws Exception {
        //створити екземпляри описаних структур даних
        //створення структури даних з векторним способом розміщення елементів у пам’яті
        Queue queue = new Queue();
        //створення структури даних зі зв’язаним способом розміщення елементів у пам’яті
        DoublyLinkedList doublyLinkedList1 = new DoublyLinkedList();
        System.out.println("Empty list: " + doublyLinkedList1);
        //вставити елементи до першої структури даних (табл. 1.3, кол. 2) і вивести її вміст;
        doublyLinkedList1.addElementToTail(17);
        System.out.println("After adding 17: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(12);
        System.out.println("After adding 12: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(-15);
        System.out.println("After adding -15: " + doublyLinkedList1);
        doublyLinkedList1.addElementToTail(123);
        System.out.println("After adding 123: " + doublyLinkedList1);
        //видалити усі від’ємні елементи
        doublyLinkedList1.deleteElements(val -> val < 0);
        System.out.println("After deletion all the negative numbers: " + doublyLinkedList1);
        //решту елементів використати для обчислення елементів черги, які є сумою цифр елемента списку
        for (Node element = doublyLinkedList1.getHead(); element != null; element = element.getNextNode()) {
            String strVal = String.valueOf(element.getVal());
            int sum = 0;
            for (char c : strVal.toCharArray()) {
                int number = Integer.valueOf(String.valueOf(c));
                sum += number;
            }
            System.out.println("Adding element with value '" + sum + "' to the queue...");
            queue.add(sum);
        }
        //вивести вміст черги
        System.out.println("Final state of the queue: " + queue);
    }

    /**
     * Тестування черги з цілими беззнаковими елементами. В main-метод не включено, бо таке тестування не передбачено
     * в завданні.
     *
     * @throws Exception
     */
    @Deprecated
    public void testAddingElementsToQueue() throws Exception {
        Queue queue = new Queue();
        System.out.println("Empty queue: " + queue);
        queue.add(45);
        System.out.println("Queue after adding 45: " + queue);
        queue.add(31);
        System.out.println("Queue after adding 31: " + queue);
        for (int i = 0; i < 10; i++) {
            int numberToInsert = i * 4;
            queue.add(numberToInsert);
            System.out.println("Queue after adding '" + numberToInsert + "': " + queue);
        }
        //видалення одного елемента з черги
        queue.deleteOldestElement();
        System.out.println("After deletion of one element from the queue: " + queue);
    }
}
