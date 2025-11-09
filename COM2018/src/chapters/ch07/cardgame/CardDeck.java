package chapters.ch07.cardgame;

public class CardDeck {
    private Card[] deck;
    private int numCards;

    private void generateDeck() {
        String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        int i = 0;
        for (int rank = 1; rank < 13; rank++) {
            for (int suit_idx = 0; suit_idx < 4; suit_idx++) {
                deck[i] = new Card(suits[suit_idx], rank);
                i++;
            }
        }
        numCards = i;
    }

    public CardDeck() {
        deck = new Card[52];
        generateDeck();
    }

    public Card newCard() {
        if (numCards == 0) {
            generateDeck();
        }
        return deck[--numCards];
    }

    public boolean moreCard() {
        return numCards > 0;
    }
}
