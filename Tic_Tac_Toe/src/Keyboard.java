import java.util.Scanner;

public class Keyboard {
    static Scanner scanner = new Scanner(System.in);

    public static boolean nextBoolean() {
        return scanner.hasNextBoolean();
    }//	Reads a boolean value from the user


    public static byte nextByte() {
        return scanner.nextByte();
    } //	Reads a byte value from the user


    public static double nextDouble() {
        return scanner.nextDouble();
    }//	Reads a double value from the user


    public static float nextFloat() {
        return scanner.nextFloat();
    }//	Reads a float value from the user


    public static int nextInt() {
        return scanner.nextInt();
    }	//Reads a int value from the user


    public static String nextLine()	{
        return scanner.nextLine();
    }// Reads a String value from the user


    public static long nextLong() {
        return scanner.nextLong();
    }//	Reads a long value from the user


    public static short nextShort() {
        return scanner.nextShort();
    }//	Reads a short value from the user


    public static boolean hasNext()
    {
        return scanner.hasNext();
    } // returns if there is input waiting

    public static int AskNumberQuestion(String askMessage) {
        int answer;
        while (true) {
            System.out.println(askMessage);
            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                break;
            } else {
                Console.println("Please type a number");
                scanner.next();
            }
        }
        return answer;
    }

}
