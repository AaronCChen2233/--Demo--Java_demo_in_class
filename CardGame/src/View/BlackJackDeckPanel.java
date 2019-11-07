package View;

import Model.BlackJackDeck;
import Model.Card;
import Model.CardDirection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel resultLable;
    private JButton playAgainButton;
    private JPanel resultPanel;

    public BlackJackDeckPanel() throws IOException {
        super();
        blackJackDeck = new BlackJackDeck();
//        /*just for test*/
//        mainPanel.setLayout(new GridLayout(4, 13));
//        for(Card card : blackJackDeck.getCards()){
//            mainPanel.add(new JCard(card));
//        }

        NewGameStart();

        setBackground(new Color(2, 74, 40));
        mainPanel.setBackground(new Color(2, 74, 40));
        bankerCardPanel.setBackground(new Color(2, 74, 40));
        playerCardPanel.setBackground(new Color(2, 74, 40));
        add(mainPanel);

        standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimeSetter timeSetter = new TimeSetter();
                Thread t = new Thread(timeSetter);
                t.start();
            }
        });

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playerCardPanel.add(new JCard(blackJackDeck.PlayerHit()));
                    playerCardPanel.updateUI();
                    playerPointsLable.setText(String.valueOf(blackJackDeck.GetPlayerHandCardsValue()));
                    if (blackJackDeck.CheckPlayerBust()) {
                        /*Bust*/
                        ShowResult("Yor bust you lost~");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blackJackDeck.NextRound();
                try {
                    NewGameStart();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void BankerShowCards() {
        blackJackDeck.BankerShowCards();
        bankerCardPanel.removeAll();
        for (Card c : blackJackDeck.getBankerHandCards()) {
            try {
                bankerCardPanel.add(new JCard(c));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        bankerCardPanel.updateUI();
    }

    private void ShowResult(String s) {
        standButton.setVisible(false);
        hitButton.setVisible(false);
        resultPanel.setVisible(true);
        resultLable.setText(s);
        /*banker show card*/
        BankerShowCards();
    }

    private void NewGameStart() throws IOException {
        standButton.setVisible(true);
        hitButton.setVisible(true);
        resultPanel.setVisible(false);
        playerCardPanel.removeAll();
        bankerCardPanel.removeAll();

        for (Card c : blackJackDeck.getPlayerHandCards()) {
            playerCardPanel.add(new JCard(c));
        }

        playerPointsLable.setText(String.valueOf(blackJackDeck.GetPlayerHandCardsValue()));

        for (Card c : blackJackDeck.getBankerHandCards()) {
            bankerCardPanel.add(new JCard(c));
        }

        bankerCardPanel.updateUI();
        playerCardPanel.updateUI();
    }

    class TimeSetter implements Runnable {
        @Override
        public void run() {
            /*If Banker hand cards value smaller than 17 banker will keep hit*/
            while (blackJackDeck.GetBankerHandCardsValue() < 17) {
                try {
                    bankerCardPanel.add(new JCard(blackJackDeck.BankerHit()));
                    bankerCardPanel.updateUI();
                    if (blackJackDeck.CheckBankerBust()) {
                        /*Bust*/
                        ShowResult("Banker bust you win!");
                        return;
                    }
                    Thread.sleep(1000);
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            /*if hadn't bust and banker points is bigger than 17 check*/
            switch (blackJackDeck.GetResult()) {
                case PlayerWin:
                    ShowResult("Banker has "+ String.valueOf(blackJackDeck.GetBankerHandCardsValue())+" points"+" you win!");
                    break;
                case BankerWin:
                    ShowResult("Banker has "+ String.valueOf(blackJackDeck.GetBankerHandCardsValue())+" points"+" you lost!");
                    break;
                case Push:
                    ShowResult("Banker has "+ String.valueOf(blackJackDeck.GetBankerHandCardsValue())+" points"+" that push");
                    break;
            }
        }
    }
}
