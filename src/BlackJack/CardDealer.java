package BlackJack;

import java.util.Random;

public class CardDealer {

    public Random random = new Random();

    private static int card;
    private String cardType;
    private int cardValue;

    public String getCard(){
        dealCard();
        return cardType;
    }

    public int getCardValue() {
        return cardValue;
    }
    public int calculateCard(){
        card = random.nextInt(52) + 1;
        return card;
    }

    public String getCardType() {
        return cardType;
    }

    public void dealCard(){
        calculateCard();

        if (card <= 4) {
                cardValue = 2;
                cardType = "Two";
            } else if (card <= 8){
                cardValue = 3;
                cardType = "Three";
            } else if (card <= 12){
                cardValue = 4;
                cardType = "Four";
            } else if (card <= 16){
                cardValue = 5;
                cardType = "Five";
            } else if (card <= 20){
                cardValue = 6;
                cardType = "Six";
            } else if (card <= 24){
                cardValue = 7;
                cardType = "Seven";
            } else if (card <= 28){
                cardValue = 8;
                cardType = "Eight";
            } else if (card <= 32){
                cardValue = 9;
                cardType = "Nine";
            } else if (card <= 36){
                cardValue = 10;
                cardType = "Ten";
            } else if (card <= 40){
                cardValue = 10;
                cardType = "Jack";
            } else if (card <= 44){
                cardValue = 10;
                cardType = "Queen";
            } else if (card <= 48){
                cardValue = 10;
                cardType = "King";
            } else if (card <= 52) {
                cardValue = 11;
                cardType = "Ace";
            } else {
                cardType = "unknown";
            }
        }
    }

