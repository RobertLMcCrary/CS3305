// Name: Robert McCrary
// Class: CS3305 - Data Structures
// Term: Fall 2026
// Instrctor: Umama Tasnim 
// Assignment: 2
// IDE Name: Neovim

import java.util.Scanner;
import java.util.InputMismatchException;

public class Vowels {
    // declaring vowel list at top level and static to avoid re allocating every
    // recursive call
    static final char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int choice;
        String lastStr = "";

        do {
            printMenu();
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Invalid input. Please enter a number 1-3.]\n");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter string: ");
                    lastStr = input.nextLine();
                    break;
                case 2:
                    System.out.println("You entered a string: " + lastStr);
                    System.out.println("Number of vowels: " + countVowels(lastStr.toLowerCase()));
                    System.out.println("\n");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid option");
                    continue;
            }
        } while (choice != 3);

        input.close();
    }

    // vowels array is static lifetime, also only lowercase
    // this means:
    // -only have to allocate once
    // -the argument passed in this function is converted to lowercase when the
    // function is called
    static int countVowels(String word) {
        // base case
        if (word.isEmpty()) {
            return 0;
        }

        char currentChar = word.charAt(0);

        int isVowel = 0;
        for (int i = 0; i < vowels.length; i++) {
            if (vowels[i] == currentChar) {
                isVowel = 1;
                break;
            }
        }

        return isVowel + countVowels(word.substring(1));
    }

    // helper funciton to print menu
    static void printMenu() {
        System.out.println("---------MAIN MENU---------");
        System.out.println("1. Read input string");
        System.out.println("2. Compute number of vowels");
        System.out.println("3. Exit program");
        System.out.print("\n");
        System.out.print("Enter option number: ");
    }
}
