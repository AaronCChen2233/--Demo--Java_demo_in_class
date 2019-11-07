package Model;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJackDeck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Card> playerHandCards = new ArrayList<Card>();
    private ArrayList<Card> bankerHandCards = new ArrayList<Card>();
    private int cardIndex = 0;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> getPlayerHandCards() {
        return playerHandCards;
    }

    public ArrayList<Card> getBankerHandCards() {
        return bankerHandCards;
    }

    public int GetBankerHandCardsValue() {
        int total = 0;
        for (Card c : bankerHandCards) {
            total += c.getCardValueInt();
        }
        return total;
    }

    public int GetPlayerHandCardsValue() {
        int total = 0;
        for (Card c : playerHandCards) {
            total += c.getCardValueInt();
        }
        return total;
    }

    public BlackJackDeck() {
        for (CardSuite cardSuite : CardSuite.values()) {
            for (CardValue cardValue : CardValue.values()) {
                if (!cardValue.equals(CardValue.Joker)) {
                    cards.add(new Card(cardSuite, cardValue, CardDirection.FaceUp, GetCardValueInt(cardValue)));
                }
                /*test for now*/
//                else {
//                    cards.add(new Card(cardSuite, cardValue, CardDirection.FaceUp));
//                }
            }
        }
        NextRound();
    }

    public void NextRound() {
        Shuffle();
        playerHandCards = new ArrayList<Card>();
        bankerHandCards = new ArrayList<Card>();
        playerHandCards.add(cards.get(0));
        playerHandCards.add(cards.get(1));
        bankerHandCards.add(cards.get(2));
        bankerHandCards.add(cards.get(3));
        bankerHandCards.get(0).setCardDirection(CardDirection.FaceDown);
    }

    public void PlayerHit() {

    }

    public void PlayerStand() {

    }

    private int GetCardValueInt(CardValue cardValue) {
        switch (cardValue) {
            case Ace:
                return 1;
            case Two:
                return 2;
            case Three:
                return 3;
            case Four:
                return 4;
            case Five:
                return 5;
            case Six:
                return 6;
            case Seven:
                return 7;
            case Eight:
                return 8;
            case Nine:
                return 9;
            case Ten:
            case Jack:
            case Queen:
            case King:
                return 10;
            default:
                return 0;
        }
    }

    public void Shuffle() {
        Collections.shuffle(cards);
    }
}
