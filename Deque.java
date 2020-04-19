/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node first, last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        first.prev = null;

        if (oldFirst == null) {
            last = first;
        }
        else {
            oldFirst.prev = first;
        }
        oldFirst = null;
        ++size;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (oldLast == null) {
            first = last;
            last.prev = null;
        }
        else {
            oldLast.next = last;
            last.prev = oldLast;
        }
        oldLast = null;
        ++size;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
        else {
            last = first;
        }
        --size;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Item item = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        else {
            first = last;
        }
        --size;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void display(Deque<Item> deque) {
        for (Item t : deque) {
            System.out.print(t + "\t");
        }
        System.out.println();
    }

    // unit testing (required)
    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>();

        deque.addLast(1);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(2);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.removeFirst();
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.removeFirst();
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(5);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(6);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(7);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(8);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(9);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.addLast(10);
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);

        deque.removeFirst();
        System.out.println("\nSize = " + deque.size);
        deque.display(deque);
    }
}
