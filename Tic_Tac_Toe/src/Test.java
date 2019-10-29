public class Test {

    static int testTimes = 0;

    public static void Test_Console_RunAll(int times) {
        testTimes = times;
        Test_Console_Print();
        Test_Console_Println();
        Test_Console_NewLine();
        Test_Console_RepeatChar();
        Test_Console_RepeatString();
    }

    public static void Test_Console_Print() {
        for (int i = 0; i < testTimes; i++) {
            Debug.logInfo("Test_Console_Print");
            Console.print(String.valueOf(i));
        }
    }

    public static void Test_Console_Println() {
        for (int i = 0; i < testTimes; i++) {
            Debug.logInfo("Test_Console_Println");
            Console.println(String.valueOf(i));
        }
    }

    public static void Test_Console_NewLine() {
        for (int i = 0; i < testTimes; i++) {
            Debug.logInfo("Test_Console_NewLine");
            Console.newLines(i);
        }
    }

    public static void Test_Console_RepeatChar() {
        for (int i = 0; i < testTimes; i++) {
            Debug.logInfo("Test_Console_RepeatChar");
            Console.repeatChar(i, 't');
        }
    }

    public static void Test_Console_RepeatString() {
        for (int i = 0; i < testTimes; i++) {
            Debug.logInfo("Test_Console_RepeatString");
            Console.repeatString(i, "TestString" + String.valueOf(i + 1));
        }
    }
}
