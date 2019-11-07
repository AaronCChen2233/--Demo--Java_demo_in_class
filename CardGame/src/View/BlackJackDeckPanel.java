package View;

import Model.BlackJackDeck;
import Model.Card;
import Model.CardDirection;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BlackJackDeckPanel extends JPanel {
    private BlackJackDeck blackJackDeck;
    private JPanel mainPanel;
    private JButton hitButton;
    private JButton standButton;
    private JPanel playerCardPanel;
    private JPanel bankerCardPanel;
    private JLabel playerPointsLable;
    private JLabel bankerPointsLable;

    public BlackJackDeckPanel() throws IOException {
        super();
        blackJackDeck = new BlackJackDeck();
//        /*just for test*/
//        mainPanel.setLayout(new GridLayout(4, 13));
//        for(Card card : blackJackDeck.getCards()){
//            mainPanel.add(new JCard(card));
//        }

        for(Card c: blackJackDeck.getPlayerHandCards()){
            playerCardPanel.add(new JCard(c));
        }
        playerPointsLable.setText(String.valueOf(blackJackDeck.GetPlayerHandCardsValue()));

        for(Card c: blackJackDeck.getBankerHandCards()){
            bankerCardPanel.add(new JCard(c));
        }
        setBackground(new Color(2,74,40));
        mainPanel.setBackground(new Color(2,74,40));
        bankerCardPanel.setBackground(new Color(2,74,40));
        playerCardPanel.setBackground(new Color(2,74,40));
        add(mainPanel);
    }

}
