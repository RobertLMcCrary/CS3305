// Name: Robert McCrary
// Class: CS 3305 - Data Structures
// Term: Fall 2026
// Instructor: Umama Tasnim
// Assignment: 5
// IDE Name: Neovim

/*
  This class define a linked list that stores integer values.
  The class does NOT use Head and Tail pointer as the textbook class deos.
*/

public class LinkedList_No_HT {
    public Node ListName;

    // constructor method to create a list object with a specifc name.
    public LinkedList_No_HT() {
        ListName = null;
    }

    // method add node to end of list
    public void addLastNode(int data) {
        if (ListName == null)
            ListName = new Node(data); // one node list
        else {
            Node temp = ListName;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(data); // link new node as last node
        }
    }

    // ======== Your part to complete for this assignment =========

    // method #1: add first node
    public void addFirstNode(int data) {
        // complete this method
    }

    // method #2: add node at index
    public void addAtIndex(int index, int data) {
        // complete this method
    }

    // method #3: remove first node
    public void removeFirstNode() {
        // complete this method
    }

    // method #4: remove last node
    public void removeLastNode() {
        // complete this method
    }

    // method #5: remove node at index
    public void removeAtIndex(int index) {
        // complete this method
    }

    // method #6: countNodes
    public int countNodes() {
        int listSize = 0;

        // complete this method to return the list size.

        return listSize;
    }

    // method #7: pritnInReverse (must be a Recursive method)
    public void printInReverseRecursive(Node L) {
        // complete this method as recursive method to ptint the list in revers order.
    }

    // ================= end of your part ==============

    // method to print out the list
    public void printList() {
        Node temp;
        temp = ListName;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    // class to create nodes as objects
    private class Node {
        private int data; // data field
        private Node next; // link field

        public Node(int item) // constructor method
        {
            data = item;
            next = null;
        }
    }
}
