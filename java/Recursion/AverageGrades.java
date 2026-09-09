// Name: Robert McCrary
// Class: CS3305 - Data Structures
// Term: Fall 2026
// Instrctor: Umama Tasnim 
// Assignment: 2
// IDE Name: Neovim

import java.util.Scanner;
import java.util.InputMismatchException;

public class AverageGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        int[] grades = null;

        // the array is full of zeros the moment it is allocated, so this tracks
        // whether option 2 actually filled it before option 3 averages it
        boolean gradesFilled = false;

        do {
            printMenu();
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Please enter a number 1-4.\n");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter class size: ");
                    int classSize = readInt(input);

                    // class size becomes the array size so it cannot be 0 or negative
                    while (classSize <= 0) {
                        System.out.print("Class size must be greater than 0. Enter class size: ");
                        classSize = readInt(input);
                    }

                    grades = new int[classSize];
                    gradesFilled = false;
                    System.out.println("\n");
                    break;
                case 2:
                    if (grades == null) {
                        System.out.println("Read the class size first (option 1).\n");
                        break;
                    }

                    for (int i = 0; i < grades.length; i++) {
                        System.out.print("Enter grade " + (i + 1) + ": ");
                        int grade = readInt(input);

                        while (grade < 0 || grade > 100) {
                            System.out.print("Grade must be between 0 and 100. Enter grade " + (i + 1) + ": ");
                            grade = readInt(input);
                        }

                        grades[i] = grade;
                    }

                    gradesFilled = true;
                    System.out.println("\n");
                    break;
                case 3:
                    if (!gradesFilled) {
                        System.out.println("Read the class grades first (option 2).\n");
                        break;
                    }

                    // printf instead of concatenation so the values line up in the
                    // same column like the assignment shows
                    System.out.printf("%-26s%d%n", "You entered class size:", grades.length);
                    System.out.printf("%-26s%s%n", "You entered grades:", gradesToText(grades));
                    System.out.printf("%-26s%.2f%n", "Class average:", findAverage(grades));
                    System.out.println("\n");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option");
                    continue;
            }
        } while (choice != 4);

        input.close();
    }

    // overloaded so findAverage itself is the recursive method
    // this one just starts the recursion and divides the total at the end
    static double findAverage(int[] grades) {
        return findAverage(grades, 0) / grades.length;
    }

    // recursive with no loop
    // this means:
    // -the index moves instead of copying the array, so nothing is reallocated
    // -returning double keeps the divide above from being integer division
    static double findAverage(int[] grades, int index) {
        // base case, walked past the last grade
        if (index == grades.length) {
            return 0.0;
        }

        return grades[index] + findAverage(grades, index + 1);
    }

    // same mismatch handling as the menu read, pulled out because the class size
    // and every grade need it
    static int readInt(Scanner input) {
        while (true) {
            try {
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    // puts the grades on one space separated line for the output
    static String gradesToText(int[] grades) {
        String text = "";

        for (int i = 0; i < grades.length; i++) {
            if (i > 0) {
                text += " ";
            }

            text += grades[i];
        }

        return text;
    }

    // helper funciton to print menu
    static void printMenu() {
        System.out.println("--------MAIN MENU-------");
        System.out.println("1. Read class size");
        System.out.println("2. Read class grades");
        System.out.println("3. Compute class average");
        System.out.println("4. Exit program");
        System.out.print("\n");
        System.out.print("Enter option number: ");
    }
}
