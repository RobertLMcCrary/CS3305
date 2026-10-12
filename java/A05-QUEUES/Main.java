
/*
 * WHEN DONE COPY THE CODE IN THIS FILE OVER TO TestQueue.java under the
 * mandatory class header before submitting.
 * This is just to run easily with the alias during development.
 * The real file that will be submitted will be TestQueue.java.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Integer> queue = new Queue<>();

        int choice = 0;

        while (choice != 7) {
            printMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = input.nextInt();

                    System.out.println("Queue before enqueue: ");
                    queue.printQueue();

                    queue.enqueue(value);

                    System.out.print("Queue after qnueue: ");
                    queue.printQueue();

                    break;

                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                        break;
                    }

                    System.out.print("Queue before dequeue: ");
                    queue.printQueue();

                    int removed = queue.dequeue();
                    System.out.println("Dequeued element: " + removed);

                    System.out.print("Queue after dequeue: ");
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                    } else {
                        queue.printQueue();
                    }

                    break;

                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                        break;
                    }

                    System.out.print("Queue contents: ");
                    queue.printQueue();

                    System.out.println("Front elements: " + queue.front());
                    break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                        break;
                    }

                    System.out.print("Queue contents: ");
                    queue.printQueue();

                    System.out.println("Queue size: " + queue.size());
                    break;

                case 5:
                    System.out.println("Queue contents: ");

                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                    } else {
                        queue.printQueue();
                    }

                    System.out.println("Is queue empty? " + queue.isEmpty());
                    break;

                case 6:
                    if (queue.isEmpty()) {
                        System.out.println("Empty Queue");
                    } else {
                        System.out.print("Queue contents: ");
                        queue.printQueue();
                    }
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        input.close();
    }

    static void printMenu() {
        System.out.println("\n\n--------MAIN MENU--------");
        System.out.println("1 - Enqueue element");
        System.out.println("2 - Dequeue element");
        System.out.println("3 - Get front element");
        System.out.println("4 - Get queue size");
        System.out.println("5 - Is Empty queue?");
        System.out.println("6 - Print queue");
        System.out.println("7 - Exit program");

        System.out.print("\nEnter option number: ");
    }
}
