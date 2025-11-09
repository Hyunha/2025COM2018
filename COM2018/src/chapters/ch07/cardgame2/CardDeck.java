package chapters.ch07.cardgame2;

public class CardDeck {
    private Card[] deck;
    private int numCards;

    private void generateDeck() {
        int i = 0;
        for (int rank = 1; rank < 13; rank++) {
            for (int suit_idx = 0; suit_idx < 4; suit_idx++) {
                deck[i] = new Card(Card.suits[suit_idx], rank);
                i++;
            }
        }
        numCards = i;
    }

    public CardDeck() {
        deck = new Card[Card.numOfFullCards];
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
