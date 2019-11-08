package Model;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJackDeck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private Player dealer;

    /*Because if multiple players so use list*/
    private ArrayList<Player> players;

    private int cardIndex = 0;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Player getDealer() {
        return dealer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int GetDealerHandCardsValue() {
        int total = 0;
        boolean hasAce = false;
        for (Card c : dealer.getHoldCards()) {
            total += c.getCardValueInt();
            if (c.getCardValue().equals(CardValue.Ace)) {
                hasAce = true;
            }
        }

        /*Rule for Ace Because if haven't bust more point is better*/
        /*so if haven't bust say Ace is 11 points*/
        /*already add 1 point in foreach loop so only +10 points*/
        if ((total + 10) <= 21 && hasAce) {
            total += 10;
        }
        return total;
    }

    public int GetPlayerHandCardsValue(int i) {
        int total = 0;
        boolean hasAce = false;
        for (Card c : players.get(i).getHoldCards()) {
            total += c.getCardValueInt();
            if (c.getCardValue().equals(CardValue.Ace)) {
                hasAce = true;
            }
        }

        /*Rule for Ace Because if haven't bust more point is better*/
        /*so if haven't bust say Ace is 11 points*/
        /*already add 1 point in foreach loop so only +10 points*/
        if ((total + 10) <= 21 && hasAce) {
            total += 10;
        }
        return total;
    }

    public BlackJackDeck() {
        for (CardSuite cardSuite : CardSuite.values()) {
            for (CardValue cardValue : CardValue.values()) {
                /*black jack doesn't use Joker*/
                if (!cardValue.equals(CardValue.Joker)) {
                    cards.add(new Card(cardSuite, cardValue, CardDirection.FaceUp, GetCardValueInt(cardValue)));
                }
            }
        }
        dealer = new Player();
    }

    public void NextRound(int playersCount) {
        Shuffle();
        dealer.RemoveAllHoldCard();
        players = new ArrayList<Player>();
        for (int i = 0; i < playersCount; i++) {
            Player player = new Player();
            player.GetCard(cards.get(cardIndex));
            cardIndex++;
            player.GetCard(cards.get(cardIndex));
            cardIndex++;
            players.add(player);
        }

        dealer.GetCard(cards.get(cardIndex));
        cardIndex++;
        dealer.GetCard(cards.get(cardIndex));
        cardIndex++;

        /*Dealer first card is face down*/
        dealer.getHoldCards().get(0).setCardDirection(CardDirection.FaceDown);
    }

    public Card PlayerHit(int playerIndex) {
        cardIndex++;
        players.get(playerIndex).GetCard(cards.get(cardIndex));
        return cards.get(cardIndex);
    }

    public Card DealerHit() {
        cardIndex++;
        dealer.GetCard(cards.get(cardIndex));
        return cards.get(cardIndex);
    }

    public void DealerShowCards() {
        /*Set every cards are face up*/
        for (Card c : dealer.getHoldCards()) {
            c.setCardDirection(CardDirection.FaceUp);
        }
    }

    public BlackJackResult GetResult(int playerIndex) {
        if (GetPlayerHandCardsValue(playerIndex) > 21) {
            /*Player Bust*/
            return BlackJackResult.DealerWin;
        }

        if (GetDealerHandCardsValue() > 21) {
            /*Dealer Bust*/
            return BlackJackResult.PlayerWin;
        }

        if (GetDealerHandCardsValue() > GetPlayerHandCardsValue(playerIndex)) {
            /*Dealer card value bigger than player DealerWin*/
            return BlackJackResult.DealerWin;
        } else if (GetDealerHandCardsValue() == GetPlayerHandCardsValue(playerIndex)) {
            /*Player card value equal dealer Push*/
            return BlackJackResult.Push;
        } else {
            /*Player card value bigger than dealer*/
            return BlackJackResult.PlayerWin;
        }
    }

    /*true is Bust*/
    public boolean CheckPlayerBust(int playerIndex) {
        return GetPlayerHandCardsValue(playerIndex) > 21;
    }

    /*true is Bust*/
    public boolean CheckDealerBust() {
        return GetDealerHandCardsValue() > 21;
    }

    /*Because different card value for different card game so put card value when initial the card game not in the Card class*/
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
        for(Card card :cards){
            card.setCardDirection(CardDirection.FaceUp);
        }
        cardIndex = 0;
    }
}
