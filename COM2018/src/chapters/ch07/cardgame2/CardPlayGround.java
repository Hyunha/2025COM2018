package chapters.ch07.cardgame2;

public class CardPlayGround {
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        Hand hand = new Hand(5);

        for (int i = 0; i < 5; i++) {
            Card c = deck.newCard();
            hand.receiveCard(c);
        }
        hand.showHand();
        hand.removeCard();
        hand.showHand();
    }
}
