
// Name: Robert McCrary
// Class: CS 3305 - Data Structures
// Term: Fall 2026
// Instructor: Umama Tasnim
// Assignment: 5
// IDE Name: Neovim
import java.util.Scanner;

public class RadixSort {
    public static int CountDigits(int number) {
        int digitCount = 0;

        do {
            digitCount++;
            number /= 10;
        } while (number > 0);

        return digitCount;
    }

    public static int ExtractDigit(int number, int position) {
        int digitPlace = 1;

        // 1, 10, 100, 1000, ...
        for (int i = 0; i < position; i++) {
            digitPlace *= 10;
        }

        return (number / digitPlace) % 10;
    }

    public static void radixSort(int[] inputs) {
        Queue<Integer> Q0 = new Queue<>();
        Queue<Integer> Q1 = new Queue<>();
        Queue<Integer> Q2 = new Queue<>();
        Queue<Integer> Q3 = new Queue<>();
        Queue<Integer> Q4 = new Queue<>();
        Queue<Integer> Q5 = new Queue<>();
        Queue<Integer> Q6 = new Queue<>();
        Queue<Integer> Q7 = new Queue<>();
        Queue<Integer> Q8 = new Queue<>();
        Queue<Integer> Q9 = new Queue<>();

        // find max number of digits
        // if countDigits(current number in inputs) is larger than maxDigits we have
        // found new maxDigits
        int maxDigits = 0;

        for (int num : inputs) {
            int digits = CountDigits(num);

            if (digits > maxDigits) {
                maxDigits = digits;
            }
        }

        // each digit position
        for (int position = 0; position < maxDigits; position++) {
            // distribute numbers into queues
            for (int num : inputs) {
                int digit = ExtractDigit(num, position);

                switch (digit) {
                    case 0:
                        Q0.enqueue(num);
                        break;
                    case 1:
                        Q1.enqueue(num);
                        break;
                    case 2:
                        Q2.enqueue(num);
                        break;
                    case 3:
                        Q3.enqueue(num);
                        break;
                    case 4:
                        Q4.enqueue(num);
                        break;
                    case 5:
                        Q5.enqueue(num);
                        break;
                    case 6:
                        Q6.enqueue(num);
                        break;
                    case 7:
                        Q7.enqueue(num);
                        break;
                    case 8:
                        Q8.enqueue(num);
                        break;
                    case 9:
                        Q9.enqueue(num);
                        break;
                }

            }

            // put number from queues back into inputs
            int index = 0;

            while (!Q0.isEmpty())
                inputs[index++] = Q0.dequeue();
            while (!Q1.isEmpty())
                inputs[index++] = Q1.dequeue();
            while (!Q2.isEmpty())
                inputs[index++] = Q2.dequeue();
            while (!Q3.isEmpty())
                inputs[index++] = Q3.dequeue();
            while (!Q4.isEmpty())
                inputs[index++] = Q4.dequeue();
            while (!Q5.isEmpty())
                inputs[index++] = Q5.dequeue();
            while (!Q6.isEmpty())
                inputs[index++] = Q6.dequeue();
            while (!Q7.isEmpty())
                inputs[index++] = Q7.dequeue();
            while (!Q8.isEmpty())
                inputs[index++] = Q8.dequeue();
            while (!Q9.isEmpty())
                inputs[index++] = Q9.dequeue();

        }

    }

    // print array values separated by commas
    public static void printArray(int[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]);

            if (i < inputs.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println();
    }

    // helper function to print out a menu
    static void printMenu() {
        System.out.println("\n\n---------------MAIN MENU---------------");
        System.out.println("1 - Read array size");
        System.out.println("2 - Read array values");
        System.out.println("3 - Run Radix Sort and print outputs");
        System.out.println("4 - Exit program");

        System.out.print("\nEnter option number: ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] inputs = null;
        int option = 0;
        int arraySize = 0;

        while (option != 4) {
            printMenu();
            option = scanner.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Enter array size: ");
                    arraySize = scanner.nextInt();

                    if (arraySize <= 0) {
                        System.out.println("Invalid array size.");
                        arraySize = 0;
                        inputs = null;
                    } else {
                        inputs = new int[arraySize];
                        System.out.println("Array size set to: " + arraySize);
                    }
                    break;

                case 2:
                    if (inputs == null) {
                        System.out.println("Please enter array size first.");
                        break;
                    }

                    for (int i = 0; i < inputs.length; i++) {

                        System.out.print("Enter value " + (i + 1) + ": ");
                        int value = scanner.nextInt();

                        // reject negative integers
                        if (value < 0) {
                            System.out.println("Negative values are not allowed.");
                            i--;
                            continue;
                        }

                        inputs[i] = value;
                    }

                    System.out.println("Array values successfully entered.");
                    break;

                case 3:
                    if (inputs == null) {
                        System.out.println("Please enter array size and values first.");
                        break;
                    }

                    // preserve original array values as a string
                    String original = "";

                    for (int i = 0; i < inputs.length; i++) {
                        original += inputs[i];

                        if (i < inputs.length - 1) {
                            original += ", ";
                        }
                    }

                    // run sorting algorithm
                    radixSort(inputs);

                    System.out.println("\nArray values before sorting: " + original);

                    System.out.print("Array values after sorting:  ");
                    printArray(inputs);

                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
