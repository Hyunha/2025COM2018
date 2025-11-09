package chapters.ch07.cardgame;

public class Hand {
    private Card[] hand;
    private int numberOfCards;

    public Hand(int maxNumberOfCards) {
        hand = new Card[5];
        numberOfCards = 0;
    }

    public void showHand() {
        for (int i = 0; i < numberOfCards; i++) {
            Card card = hand[i];
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }

    public boolean receiveCard(Card card) {
        if (hand[numberOfCards] == null) {
            hand[numberOfCards++] = card;
            return true;
        } else {
            return false;
        }
    }

    public Card removeCard() {
        if (numberOfCards == 0) {
            return null;
        } else {
            Card pick = hand[--numberOfCards];
            return pick;
        }
    }
}
