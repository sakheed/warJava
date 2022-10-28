/**
 * <h1> Project A: Card </h1>
 * <h2> CISC 181 Summer 2022 </h2>
 * <h3> University of Delaware </h3>
 * Description:
 *
 * @author Sakhee Desai
 * @since 2022-07-10
 */
public class Card {

    private final SUIT suit;

    private final RANK rank;

    public Card (RANK rank, SUIT suit){
        this.rank = rank;
        this.suit = suit;
    }

    public RANK getRank(){
        return rank;
    }
    
    public SUIT getSuit(){
        return suit;
    }

    @Override
    public String toString() {
        char suit = ' ';
        switch (this.suit) {
            case SPADES:   suit = '\u2660'; break;
            case DIAMONDS: suit = '\u2666'; break;
            case CLUBS:    suit = '\u2663'; break;
            case HEARTS:   suit = '\u2764'; break;
        }
        String rank = "";
        switch (this.rank) {
            case DEUCE: rank=" 2"; break;
            case THREE: rank=" 3"; break;
            case FOUR:  rank=" 4"; break;
            case FIVE:  rank=" 5"; break;
            case SIX:   rank=" 6"; break;
            case SEVEN: rank=" 7"; break;
            case EIGHT: rank=" 8"; break;
            case NINE:  rank=" 9"; break;
            case TEN:   rank="10"; break;
            case JACK:  rank=" J"; break;
            case QUEEN: rank=" Q"; break;
            case KING:  rank=" K"; break;
            case ACE:   rank=" A"; break;
        }
        return "----------" +
                "\n|" + rank + "      |" +
                "\n|   " + suit + "    |" +
                "\n|     " + rank + " |" +
                "\n----------\n";
    }

}
