package BlackJack;

public enum Suit {

    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");

    final String suitName;

    Suit(String suitName){
        this.suitName = suitName;
    }

    @Override
    public String toString() {
        return suitName;
    }
}
