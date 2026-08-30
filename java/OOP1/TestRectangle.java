// Name: Robert McCrary
// Class: CS3305 - Data Structures
// Term: Fall 2026
// Instrctor: Umama Tasnim 
// Assignment: 1
// IDE Name: Neovim
import java.util.Scanner;

/*
 * using string formatting instead of concatenation
 *  - better readability
 *  - more modern java feature (version 15+)
*/

class TestRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // myRect
        Rectangle myRectangle = new Rectangle();

        String myRectInfo = """
                myRectangle:
                ------------
                Width: %f
                Height: %f
                Area: %f
                Perimeter: %f

                %s
                """.formatted(myRectangle.getWidth(), myRectangle.getHeight(), myRectangle.getArea(),
                myRectangle.getPerimeter(), myRectangle.printRectangle("myRectangle"));

        System.out.println(myRectInfo);

        // yourRect

        // take user input with scanner
        System.out.print("Enter width: ");
        double width = input.nextDouble();
        System.out.print("\n");

        System.out.print("Enter width: ");
        double height = input.nextDouble();
        System.out.print("\n");

        Rectangle yourRectangle = new Rectangle(width, height);

        String yourRectangleInfo = """
                yourRectangle:
                ------------
                Width: %f
                Height: %f
                Area: %f
                Perimeter: %f

                %s
                """.formatted(yourRectangle.getWidth(), yourRectangle.getHeight(), yourRectangle.getArea(),
                yourRectangle.getPerimeter(), yourRectangle.printRectangle("yourRectangle"));

        System.out.println(yourRectangleInfo);

        input.close();
    }
}
