public class App {
    private static boolean _shouldTerminate = false;

    private static boolean _shouldRunTests = false;

    private static boolean _runWindow = false;

    private static CommandLine commandLine;

    private static Tic_Tac_Toe tic_tac_toe = new Tic_Tac_Toe();


    public static void main(String[] args) {
        commandLine = new CommandLine(args);
        /*-runtest 5*/
        _shouldRunTests = commandLine.doesArgumentExists("-runtest");
        _runWindow = commandLine.doesArgumentExists("-runwindow");

        if (_shouldRunTests) {
            Test.Test_Console_RunAll(commandLine.Arguments.length == 2 ? Integer.valueOf(commandLine.Arguments[1]) : 1);
            Test.Test_Tic_Tac_Toe_Rule();
        }

        if(_runWindow){
            Tic_Tac_ToeWindow ticTacToeWindow = new Tic_Tac_ToeWindow();
            ticTacToeWindow.setVisible(true);
        }

        /*If run windows don't run StartGameByUseTerminal*/
        if(!_runWindow&&!_shouldRunTests) {
            do {
                tic_tac_toe.StartGameByUseTerminal();
                Console.println("Play again?(Y/N)");
                Keyboard.nextLine();
                _shouldTerminate = Keyboard.nextLine().toLowerCase().equals("y");
            } while (_shouldTerminate);
        }
    }
}
