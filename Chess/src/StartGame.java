public class StartGame {
    private static CommandLine commandLine;
    private static boolean _runWindow = false;

    public static void main(String[] args) {
        commandLine = new CommandLine(args);
        _runWindow = commandLine.doesArgumentExists("-runwindow");
        if(_runWindow){
            ChessWindow chessWindow = new ChessWindow();
            chessWindow.setVisible(true);
        }else {
            Chess newChessGame = new Chess();
            Chess.ChessBoard newChessBoard = newChessGame.new ChessBoard();
        }
    }
}
