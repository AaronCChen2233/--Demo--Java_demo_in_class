public class App {
    private static boolean _shouldTerminate = false;

    private static boolean _shouldRunTests = false;

    private static CommandLine commandLine;



    public static void main(String[] args) {
        commandLine = new CommandLine(args);
        /*-runtest 5*/
        _shouldRunTests = commandLine.doesArgumentExists("-runtest");

        if (_shouldRunTests) {
            Test.Test_Console_RunAll(Integer.valueOf(commandLine.Arguments[1]));
            Test.Test_Math_RunAll(Integer.valueOf(commandLine.Arguments[1]));
        }

        do {
            Console.print("Exit?(Y/N)");
            _shouldTerminate = Keyboard.nextLine().toLowerCase().equals("y");
        } while (!_shouldTerminate);
    }
}
