import java.util.Scanner;

public class Assignment {
    public static void main(String[] args) {
        System.out.println("    J     A     V     V    A");
        System.out.println("    J    A A     V   V    A A");
        System.out.println("J   J   AAAAA     V V    AAAAA");
        System.out.println(" J J   A     A     V    A     A");

        System.out.println();

        System.out.println("n" + "\t" + "n^2" + "\t" + "n^3");
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + "\t" + i * i + "\t" + i * i * i);
        }

//        System.out.println("a\ta^2\ta^3\t");
//        for (int i = 1; i <= 4; i++) {
//            System.out.printf("%d\t%d\t%d\t\n",i,i*i,i*i*i);
//        }

        System.out.println();

        System.out.println("9.5 * 4.5 - 2.5 * 3");
        System.out.println("——————————————————— = " + (9.5 * 4.5 - 2.5 * 3) / (45.5 - 3.5));
        System.out.println("    45.5 - 3.5     ");

        System.out.println();

        System.out.println("1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = " + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9);

        System.out.println();

        double principal;
        double rate;
        double years;

        Scanner input = new Scanner(System.in);

        System.out.print("Tell me principal:");
        principal = input.nextDouble();
        System.out.print("Tell me rate:");
        rate = input.nextDouble();
        System.out.print("Tell me how many years:");
        years = input.nextDouble();

        /*Convert to percent*/
        rate /= 100;
        rate /= 12;
        /*Convert to month*/
        years *= 12;
        System.out.println("Your Mortgage monthly payment is: " + MortgageCalculator.calculatMortgage(principal, rate, years));
        input.close();
    }
}