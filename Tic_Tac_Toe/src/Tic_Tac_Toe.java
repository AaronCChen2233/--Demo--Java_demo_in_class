public class Tic_Tac_Toe {
    String[] ticTacToeBroad = new String[9];
    boolean isTestMode = false;

    Tic_Tac_Toe() {
        NewGame();
    }

    public void StartGame() {
        NewGame();
        PrintBroad();
        int position = 0;
        boolean isXTurn = false;
        String winner = "";
        for (int i = 0; i < 9; i++) {
            isXTurn = i % 2 == 0;

            position = AskPlayerWhichPosition(isXTurn);

            ticTacToeBroad[position - 1] = isXTurn ? "X" : "O";
            PrintBroad();
            winner = CheckWinner();
            if (!winner.equals("")) {
                Console.println("Winner is " + winner);
                return;
            }
        }
        Console.println("This game is draw");
    }

    public String CheckTest(String[] testbroad) {
        isTestMode = true;
        ticTacToeBroad = testbroad;
        System.out.println();
        PrintBroad();
        return CheckWinner();
    }

    private void NewGame() {
        /*New a Empty Broad*/
        for (int i = 0; i < ticTacToeBroad.length; i++) {
            ticTacToeBroad[i] = String.valueOf(i + 1);
        }
    }

    private int AskPlayerWhichPosition(boolean isXTurn) {
        int position;
        String message = "";
        boolean shouldShowErrorMessage = false;
        message = isXTurn ? "Now is X turn please choose index" : "Now is O turn please choose index";
        shouldShowErrorMessage = false;
        do {
            if (shouldShowErrorMessage) {
                Console.println("Please type from 1 to 9");
            }
            position = Keyboard.AskNumberQuestion(message);
            shouldShowErrorMessage = true;
        } while (position > 9 || position < 1);

        while (ticTacToeBroad[position - 1].equals("X") || ticTacToeBroad[position - 1].equals("O")) {
            Console.println("This block already have piece please try another one");
            position = Keyboard.AskNumberQuestion(message);
        }
        return position;
    }

    private void PrintBroad() {
        for (int i = 0; i < 3; i++) {
            Console.println(ticTacToeBroad[i * 3 + 0] + " " + ticTacToeBroad[i * 3 + 1] + " " + ticTacToeBroad[i * 3 + 2]);
        }
    }

    private String CheckWinner() {
        /**
         0 1 2
         3 4 5
         6 7 8
         **/
        String winner = "";
        if (ticTacToeBroad[0].equals(ticTacToeBroad[1]) && ticTacToeBroad[0].equals(ticTacToeBroad[2])) {
            if(isTestMode){
                Console.println("1");
            }

            return ticTacToeBroad[0];
        }
        if (ticTacToeBroad[3].equals(ticTacToeBroad[4]) && ticTacToeBroad[3].equals(ticTacToeBroad[5])) {
            if(isTestMode){
                Console.println("2");
            }
            return ticTacToeBroad[3];
        }
        if (ticTacToeBroad[6].equals(ticTacToeBroad[7]) && ticTacToeBroad[6].equals(ticTacToeBroad[8])) {
            if(isTestMode){
                Console.println("3");
            }
            return ticTacToeBroad[6];
        }

        if (ticTacToeBroad[0].equals(ticTacToeBroad[3]) && ticTacToeBroad[0].equals(ticTacToeBroad[6])) {
            if(isTestMode){
                Console.println("4");
            }
            return ticTacToeBroad[0];
        }
        if (ticTacToeBroad[1].equals(ticTacToeBroad[4]) && ticTacToeBroad[1].equals(ticTacToeBroad[7])) {
            if(isTestMode){
                Console.println("5");
            }
            return ticTacToeBroad[1];
        }
        if (ticTacToeBroad[2].equals(ticTacToeBroad[5]) && ticTacToeBroad[2].equals(ticTacToeBroad[8])) {
            if(isTestMode){
                Console.println("6");
            }
            return ticTacToeBroad[2];
        }

        if (ticTacToeBroad[0].equals(ticTacToeBroad[4]) && ticTacToeBroad[0].equals(ticTacToeBroad[8])) {
            if(isTestMode){
                Console.println("7");
            }
            return ticTacToeBroad[0];
        }
        if (ticTacToeBroad[2].equals(ticTacToeBroad[4]) && ticTacToeBroad[2].equals(ticTacToeBroad[6])) {
            if(isTestMode){
                Console.println("8");
            }
            return ticTacToeBroad[2];
        }
        return winner;
    }
}
