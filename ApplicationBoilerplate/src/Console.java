public class Console {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void newLines(int times) {
        for (int i = 0; i < times; i++) {
            System.out.println();
        }
    }

    public static void repeatChar(int times, char aChar) {
        for (int i = 0; i < times; i++) {
            System.out.println(aChar);
        }
    }

    public static void repeatString(int times, String aString) {
        for (int i = 0; i < times; i++) {
            System.out.println(aString);
        }
    }
}
