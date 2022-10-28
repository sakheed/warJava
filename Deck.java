import java.util.Random;
public class Deck {
    private Card[] cards;
    public int numDealt;

    public Deck(){
        cards = new Card[52];
        numDealt = 0;
        int i = 0;
            for (int rankCheck = 0; rankCheck <= 12; rankCheck++) {
                for (int suitCheck = 0; suitCheck <= 3; suitCheck++) {
                    cards[i] = new Card(RANK.values()[rankCheck], SUIT.values()[suitCheck]);
                    i++;
            }
        }
    }


    public void zipShuffle(int shuffleTimes){
        //split the deck in half (left and right).
        //put the bottom card from left in shuffled array.
        //put the bottom card from right in shuffled array.
        //repeat steps 2+3 for shuffleTimes

    for (int j=0; j<shuffleTimes;j++) {
        Card[] left = new Card[26];
        Card[] right = new Card[26];
        for (int k=0; k<26;k++){
            left[k] = cards[k];
            right[k] = cards[k+26];
        }
        for (int i = 0; i <= left.length-1; i++) {
            cards[i * 2] = left[i];
            cards[i * 2 + 1] = right[i];
        }
        }
    }


    public Card deal(){
        //Card card = cards[0];
        //for (numDealt=0; numDealt<cards.length; numDealt++){
        //    card = cards[numDealt];
       // }
        //return card;
        return cards[numDealt++];
    }

    public boolean isEmpty(){
        if (numDealt == 52){
            return true;
        }
        return false;
    }


    public int getNumDealt(){
        return numDealt;
    }
    public Card[] getCards() {
        return cards;
    }

    //random shuffle method that assigns random index to temp and then swaps card indexes
    public Card[] randomShuffle(){
        Random rand = new Random();
        for (int i=0; i<cards.length; i++){
            int randomIndex = rand.nextInt(cards.length);
            Card temp = cards[randomIndex];
            cards[randomIndex] = cards[i];
            cards[i] = temp;

        }
        return cards;
    }


}

