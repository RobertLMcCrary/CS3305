// Name: Robert McCrary
// Class: CS 3305 - Data Structures
// Term: Fall 2026
// Instructor: Umama Tasnim
// Assignment: 5
// IDE Name: Neovim

// using java docs comments for method documentation

public class Queue<E> {
    private Node first;
    private Node last;
    private int size;

    /**
     * private node element for queue
     */
    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Implements a generic queue using a singly linked list.
     */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Adds an element to the back of the queue.
     * If queue is empty then the new element is now the front and back of the
     * queue.
     */
    public void enqueue(E e) {
        Node newNode = new Node(e);

        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }

        this.size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * If queue is empty then return null.
     */
    public E dequeue() {
        if (this.isEmpty()) {
            return null;
        }

        E firstData = this.first.data;
        this.first = this.first.next;

        this.size--;

        if (this.isEmpty()) {
            this.last = null;
        }

        return firstData;
    }

    /**
     * Return the value of the first element in teh queue.
     * If queue is empty then just return null.
     */
    public E front() {
        if (isEmpty()) {
            return null;
        }

        return this.first.data;
    }

    /**
     * Just return the size.
     */
    public int size() {
        return this.size;
    }

    /**
     * Check if queue is empty by looking at the size.
     */
    public boolean isEmpty() {
        if (this.size > 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Just prints the queue.
     */
    public void printQueue() {
        Node current = this.first;

        while (current != null) {
            System.out.print(current.data + "   ");
            current = current.next;
        }

        System.out.println();
    }
}
