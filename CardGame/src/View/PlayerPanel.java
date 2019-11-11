package View;

import Model.Card;

import javax.swing.*;
import java.io.IOException;

public class PlayerPanel extends JPanel {
    private JPanel playerCardPanel;
    private JLabel playerPointsLable;
    private JPanel playerPanel;

    public PlayerPanel() {

    }

    public void setPlayerCardValue(String text) {
        playerPointsLable.setText(text);
    }

    public void addPlayerHoldCard(Card card) throws IOException {
        playerCardPanel.add(new JCard(card));
        playerCardPanel.updateUI();
    }

    public void removeAllCard() {
        playerCardPanel.removeAll();
        playerCardPanel.updateUI();
    }
}
