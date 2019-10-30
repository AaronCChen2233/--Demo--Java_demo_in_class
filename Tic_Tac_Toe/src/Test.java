public class Test {

    static int testTimes = 0;

    private static Tic_Tac_Toe tic_tac_toe = new Tic_Tac_Toe();

    public static void Test_Console_RunAll(int times) {
        testTimes = times;
        Test_Console_Print();
        Test_Console_Println();
        Test_Console_NewLine();
        Test_Console_RepeatChar();
        Test_Console_RepeatString();
    }

    public static void Test_Tic_Tac_Toe_Rule(){
        String [] testBroad = new String[]
                        {"O","O","O"
                        ,"4","5","6"
                        ,"7","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","3"
                        ,"O","O","O"
                        ,"7","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","3"
                        ,"4","5","6"
                        ,"O","O","O"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"O","2","3"
                        ,"O","5","6"
                        ,"O","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","O","3"
                        ,"4","O","6"
                        ,"7","O","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","O"
                        ,"4","5","O"
                        ,"7","8","O"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"O","2","3"
                        ,"4","O","6"
                        ,"7","8","O"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","O"
                        ,"4","O","6"
                        ,"O","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                         {"X","X","X"
                        ,"4","5","6"
                        ,"7","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","3"
                        ,"X","X","X"
                        ,"7","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","3"
                        ,"4","5","6"
                        ,"X","X","X"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"X","2","3"
                        ,"X","5","6"
                        ,"X","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","X","3"
                        ,"4","X","6"
                        ,"7","X","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","X"
                        ,"4","5","X"
                        ,"7","8","X"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"X","2","3"
                        ,"4","X","6"
                        ,"7","8","X"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));

        testBroad = new String[]
                        {"1","2","X"
                        ,"4","X","6"
                        ,"X","8","9"};
        Debug.logInfo("Winner is "+tic_tac_toe.CheckTest(testBroad));
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
