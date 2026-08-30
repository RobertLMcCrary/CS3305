// Name: Robert McCrary
// Class: CS3305 - Data Structures
// Term: Fall 2026
// Instrctor: Umama Tasnim
// Assignment: 1
// IDE Name: Neovim
import java.util.Scanner;

/*
 * using string formatting instead of concatenation here as well
 *  - better readability
 *  - more modern java feature (version 15+)
*/

class TestTemps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // prompt for all 7 daily temperatures
        System.out.print("Enter Monday's temperature: ");
        double mon = input.nextDouble();

        System.out.print("Enter Tuesday's temperature: ");
        double tues = input.nextDouble();

        System.out.print("Enter Wednesday's temperature: ");
        double wed = input.nextDouble();

        System.out.print("Enter Thursday's temperature: ");
        double thurs = input.nextDouble();

        System.out.print("Enter Friday's temperature: ");
        double fri = input.nextDouble();

        System.out.print("Enter Saturday's temperature: ");
        double sat = input.nextDouble();

        System.out.print("Enter Sunday's temperature: ");
        double sun = input.nextDouble();

        DailyTemps week = new DailyTemps(mon, tues, wed, thurs, fri, sat, sun);

        System.out.println("\nTesting method printTemps:");
        week.printTemps();

        System.out.println("\nTesting method Freezing:");
        String freezingInfo = """
                Number of freezing days is %d days
                """.formatted(week.Freezing());
        System.out.println(freezingInfo);

        System.out.println("Testing method Warmest:");
        String warmestInfo = """
                The warmest day of the week is %s
                """.formatted(week.Warmest());
        System.out.println(warmestInfo);

        System.out.println("Testing method setTemp:");
        System.out.print("Enter the index of the day to update (0=Monday ... 6=Sunday): ");
        int dayIndex = input.nextInt();

        System.out.print("Enter the new temperature: ");
        double newTemp = input.nextDouble();

        week.setTemp(dayIndex, newTemp);

        System.out.println("\nUpdated temperatures:");
        week.printTemps();

        input.close();
    }
}
