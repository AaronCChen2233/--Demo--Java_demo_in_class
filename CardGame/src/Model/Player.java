package Model;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> HoldCards;
    private int leftToken;

    public int getLeftToken() {
        return leftToken;
    }

    public void setLeftToken(int leftToken) {
        this.leftToken = leftToken;
    }

    public ArrayList<Card> getHoldCards() {
        return HoldCards;
    }

    public Player(){
        HoldCards = new ArrayList<Card>();
    }

    public void getCard(Card card){
        HoldCards.add(card);
    }

    public void removeAllHoldCard(){
        HoldCards.clear();
    }
}
