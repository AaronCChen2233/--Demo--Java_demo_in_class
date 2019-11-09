package View;

import Model.BlackJackDeck;
import Model.Card;

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
    private JPanel dealerCardPanel;
    private JLabel playerPointsLable;
    private JLabel dealerPointsLable;
    private JLabel resultLable;
    private JButton playAgainButton;
    private JPanel resultPanel;

    public BlackJackDeckPanel() throws IOException {
        super();
        blackJackDeck = new BlackJackDeck();
        /*Now only for one player, multiple coming soon~*/
        blackJackDeck.NextRound(1);
//        /*just for test*/
//        mainPanel.setLayout(new GridLayout(4, 13));
//        for(Card card : blackJackDeck.getCards()){
//            mainPanel.add(new JCard(card));
//        }

        NewGameStart();

        setBackground(new Color(2, 74, 40));
        mainPanel.setBackground(new Color(2, 74, 40));
        dealerCardPanel.setBackground(new Color(2, 74, 40));
        playerCardPanel.setBackground(new Color(2, 74, 40));
        add(mainPanel);

        standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*Use another thread for the effect dealer hit card one by one per second*/
                dealerPointsLable.setVisible(true);
                standButton.setEnabled(false);
                hitButton.setEnabled(false);
                TimeSetter timeSetter = new TimeSetter();
                Thread t = new Thread(timeSetter);
                t.start();
            }
        });

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    playerCardPanel.add(new JCard(blackJackDeck.PlayerHit(0)));
                    playerCardPanel.updateUI();
                    String playerPointsString = blackJackDeck.CheckPlayerIsBlackJack(0) ? "Black Jack" : String.valueOf(blackJackDeck.GetPlayerHandCardsValue(0));
                    playerPointsLable.setText(playerPointsString);
                    if (blackJackDeck.CheckPlayerBust(0)) {
                        /*Bust*/
                        ShowResult("You bust you lose~");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                blackJackDeck.NextRound(1);
                try {
                    NewGameStart();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void DealerShowCards() {
        blackJackDeck.DealerShowCards();
        String dealerPointsString = blackJackDeck.CheckDealerIsBlackJack() ? "Black Jack" : String.valueOf(blackJackDeck.GetDealerHandCardsValue());
        dealerPointsLable.setText(dealerPointsString);
        for (Component jcard : dealerCardPanel.getComponents()) {
            ((JCard) jcard).FaceUp();
        }
        dealerCardPanel.updateUI();
    }

    private void ShowResult(String s) {
        /*different color for different result*/
        switch (blackJackDeck.GetResult(0)) {
            case PlayerWin:
                resultLable.setForeground(Color.yellow);
                break;
            case DealerWin:
                resultLable.setForeground(Color.red);
                break;
            case Push:
                resultLable.setForeground(Color.blue);
                break;
        }
        resultPanel.setVisible(true);
        standButton.setVisible(false);
        hitButton.setVisible(false);
        resultLable.setText(s);
    }

    private void NewGameStart() throws IOException {
        standButton.setVisible(true);
        hitButton.setVisible(true);
        standButton.setEnabled(true);
        hitButton.setEnabled(true);
        resultPanel.setVisible(false);
        dealerPointsLable.setVisible(false);
        playerCardPanel.removeAll();
        dealerCardPanel.removeAll();

        for (Card c : blackJackDeck.getPlayers().get(0).getHoldCards()) {
            playerCardPanel.add(new JCard(c));
        }

        String playerPointsString = blackJackDeck.CheckPlayerIsBlackJack(0) ? "Black Jack" : String.valueOf(blackJackDeck.GetPlayerHandCardsValue(0));
        playerPointsLable.setText(playerPointsString);

        for (Card c : blackJackDeck.getDealer().getHoldCards()) {
            dealerCardPanel.add(new JCard(c));
        }

        dealerCardPanel.updateUI();
        playerCardPanel.updateUI();
    }

    class TimeSetter implements Runnable {
        @Override
        public void run() {
            DealerHit();
        }
    }

    private void DealerHit() {
        try {
            /*dealer show card*/
            DealerShowCards();
            Thread.sleep(1000);
            /*If Dealer hand cards value smaller than 17 dealer will keep hit*/
            while (blackJackDeck.GetDealerHandCardsValue() < 17) {
                dealerCardPanel.add(new JCard(blackJackDeck.DealerHit()));
                dealerCardPanel.updateUI();
                String dealerPointsString = blackJackDeck.CheckDealerIsBlackJack() ? "Black Jack" : String.valueOf(blackJackDeck.GetDealerHandCardsValue());
                dealerPointsLable.setText(dealerPointsString);
                if (blackJackDeck.CheckDealerBust()) {
                    /*Bust*/
                    ShowResult("Dealer bust you win!");
                    return;
                }
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }

        /*if hadn't bust and dealer points is bigger than 17 check*/
        String dealerPointsString = blackJackDeck.CheckDealerIsBlackJack() ? "Black Jack" : String.valueOf(blackJackDeck.GetDealerHandCardsValue()) + " points";
        switch (blackJackDeck.GetResult(0)) {
            case PlayerWin:
                ShowResult("Dealer has " + dealerPointsString + " you win!");
                break;
            case DealerWin:
                ShowResult("Dealer has " + dealerPointsString + " you lose~");
                break;
            case Push:
                ShowResult("Dealer also has " + dealerPointsString + " that push");
                break;
        }
    }
}
