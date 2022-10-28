public class Hand {
    private Card[] cards;
    private int cardCount;

    public Hand(){
        this.cards = new Card[52];
        cardCount = 0;
    }

    public void addCard(Card newCard) {
        //takes in card object and adds it to cards array -- cannot add to array so create new one of same size + append
        // use cardCount field to keep track of where you must place new card
//        Card[] newList = new Card[cards.length+1];
//        for (cardCount = 0; cardCount<cards.length; cardCount++){
//            newList[cardCount] = cards[cardCount];
//        }
//        newList[cardCount] = newCard;
//        this.cards = newList;
        this.cards[cardCount++] = newCard;
    }

    public Card[] getCards() {
        return cards;
    }

    public int getCardCount() {
        return cardCount;
    }

    public Card removeFirstCard(){
        // the address of cards[0] should be set to null
        Card toRemove = cards[0];
        cards[0] = null;
        //players hand is shifted
        shiftHand();
        //card count is decreased
        cardCount --;
        return toRemove;

    }

    public void shiftHand(){
        for (int i =0; i<cards.length-1; i++){
            cards[i] = cards[i+1];
        }
    }

    public void putCardsAtEnd(int numCards){
        for (int i =0; i<numCards; i++){
            addCard(removeFirstCard());
        }
    }


}
