package ca.bcit.comp2526.a2a;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * DoublyLinkedList.
 * @author jennyly
 * @version 1.0
 * @param <E>
 */
public class DoubleLinkedList<E> implements Iterable<E>, Serializable {


    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Node.
     * @author jennyly
     * @version 1.0
     * @param <E>
     */
    public static class Node<E> implements Serializable {
        private Node<E> prev;
        private Node<E> next;
        private E data;


        /**
         * Constructor.
         * @param data as E
         */
        public Node(E data) {

        }
        
        /**
         * Constructor.
         * @param data as E
         * @param prev as E
         * @param next as E
         */
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
        /**
         * Gets dataValue.
         * @return data as an int
         */
        public int intValue() {
            return (int) this.data;
        }
    }

    /**
     * Adds to the front of linkedlist.
     * @param e as E
     * @throws CouldNotAddException as Exception
     */
    public void addToFront(E e) throws CouldNotAddException {

        if (e == null) {
            throw new CouldNotAddException();
        }

        Node<E> temp = new Node<>(e, null, head);
        size++; 

        if (head != null) {
            head.prev = temp;
        } else {
            tail = temp;
        }
        head = temp;


    }

    /**
     * Removes from front of linkedlist.
     * @return current.data as E
     * @throws CouldNotRemoveException as Exception
     */
    public E removeFromFront() throws CouldNotRemoveException {
        if (head == null) {
            throw new CouldNotRemoveException();
        }
        size--;
        Node<E> current = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            current.next = null;
        }
        return current.data;

    }

    /**
     * Adds to the end of linkedlist.
     * @param e as E
     * @throws CouldNotAddException as Exception
     */
    public void addToEnd(E e) throws CouldNotAddException {
        if (e == null) {
            throw new CouldNotAddException();
        } 
        Node<E> temp = new Node<>(e, tail, null);
        size++;
        if (tail != null) {
            tail.next = temp;     
        } else {
            head = temp;
        }
        tail = temp;

    }

    /**
     * Remove from end of linkedlist.
     * @return temp.data as E
     * @throws CouldNotRemoveException as Exception
     */
    public E removeFromEnd() throws CouldNotRemoveException {
        Node<E> temp = tail;
        if (tail == null) {
            throw new CouldNotRemoveException();
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        size--;
        return temp.data;
    }

    /**
     * Allows for iteration over doublelinkedlist.
     * @return iter as Iterator<E> 
     */
    public Iterator<E> iterator() {

        Iterator<E> iter = new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return (current != null);

            }

            @Override
            public E next() {
                Node<E> holder = current;
                if (!hasNext()) {
                    throw new NoSuchElementException();

                } else {
                    current = current.next;
                }
                return holder.data;
            }
        };

        return iter;

    }

    /**
     * Gets first node.
     * @return head as Node
     */
    public Node<E> getFirst() {
        if (head == null) {
            return null;
        } else {
            return head;
        }
    }

    /**
     * Gets the last node.
     * @return tail as Node
     */
    public Node<E> getLast() {
        if (tail == null) {
            return null;
        } else {
            return tail;
        }
    }

    /**
     * Returns the size of linkedlist.
     * @return size as int
     */
    public int size() {
        return size;
    } 

}
