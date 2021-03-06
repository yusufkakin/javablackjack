package BlackJack;

import java.util.ArrayList;
import java.util.Random;

public class CardDealer {

    private static int card;
    public Random random = new Random();
    private String cardType;
    private int cardValue;

    //SHUFFLE A SUIT FOR THE CARDS
    public static String getSuit(){
        ArrayList<Suit> suits = new ArrayList<>();
        Random random = new Random();
        int nxt = random.nextInt(4);
        suits.add(0, Suit.CLUB);
        suits.add(1, Suit.SPADE);
        suits.add(2, Suit.DIAMOND);
        suits.add(3, Suit.HEART);
        return String.valueOf(suits.get(nxt));
    }

    //GET A RANDOMIZED CARD
    public String getCard() {
        dealCard();
        return cardType;
    }

    //SHUFFLES THE DECK AND PICKS A CARD
    public void dealCard() {
        calculateCard();

        if (card <= 4) {
            cardValue = 2;
            cardType = "Two";
        } else if (card <= 8) {
            cardValue = 3;
            cardType = "Three";
        } else if (card <= 12) {
            cardValue = 4;
            cardType = "Four";
        } else if (card <= 16) {
            cardValue = 5;
            cardType = "Five";
        } else if (card <= 20) {
            cardValue = 6;
            cardType = "Six";
        } else if (card <= 24) {
            cardValue = 7;
            cardType = "Seven";
        } else if (card <= 28) {
            cardValue = 8;
            cardType = "Eight";
        } else if (card <= 32) {
            cardValue = 9;
            cardType = "Nine";
        } else if (card <= 36) {
            cardValue = 10;
            cardType = "Ten";
        } else if (card <= 40) {
            cardValue = 10;
            cardType = "Jack";
        } else if (card <= 44) {
            cardValue = 10;
            cardType = "Queen";
        } else if (card <= 48) {
            cardValue = 10;
            cardType = "King";
        } else if (card <= 52) {
            cardValue = 11;
            cardType = "Ace";
        } else {
            cardType = "unknown";
        }
    }

    //RANDOMIZE THE CARDS/SHUFFLE
    public void calculateCard() {
        card = random.nextInt(52) + 1;
    }

    //GET THE VALUE FOR THE CARD
    public int getCardValue() {
        return cardValue;
    }

    //GET THE TYPE OF THE CARD
    public String getCardType() {
        return cardType;
    }
}


