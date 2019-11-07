package Model;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> HoldCards;

    public ArrayList<Card> getHoldCards() {
        return HoldCards;
    }

    public Player(){
        HoldCards = new ArrayList<Card>();
    }

    public void GetCard(Card card){
        HoldCards.add(card);
    }

    public void RemoveAllHoldCard(){
        HoldCards = new ArrayList<Card>();
    }
}
