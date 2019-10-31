import javax.swing.*;
import java.awt.*;

public class ChessWindow extends JFrame {

    private JPanel broadPanel;
    private JPanel mainPanel;

    public ChessWindow() {
        add(mainPanel);
        setTitle("Aaron Chess");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Chess newChessGame = new Chess();
        Chess.ChessBoard newChessBoard = newChessGame.new ChessBoard();

        broadPanel.setLayout(new GridLayout(8, 8));
        for (Chess.Square s : newChessBoard.getSquares()) {
            JButton piceButton = new JButton();
            piceButton.setMinimumSize(new Dimension(30, 30));
            Chess.Piece p = s.getPiece();
            if (p != null) {
                piceButton.setText(p.getNameOfPieces().getLabel());
            }

            broadPanel.add(piceButton);
        }
    }
}
