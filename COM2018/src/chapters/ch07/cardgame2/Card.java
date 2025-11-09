package chapters.ch07.cardgame2;

public class Card {
    private String suit;
    private int rank;
    public static final String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
    public static final int numOfFullCards = 52;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}
