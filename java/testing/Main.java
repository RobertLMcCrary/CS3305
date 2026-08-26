import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("number: ");
        int number = sc.nextInt();
        System.out.println("\n");

        long ans = factorial(number);

        System.out.println("factorial: " + ans);

        sc.close();
    }

    static long factorial(int num) {
        if (num <= 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
