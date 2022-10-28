public class Game {
    public static Player player1;
    public static Player player2;
    public static Deck deck;

    public static int numRounds = 3;

    public static int p1SkipIndex = 4;

    public static int p2SkipIndex = 4;

    public static void newGame(String name1, String name2){
        player1 = new Player(name1);
        player2 = new Player(name2);
        deck = new Deck();

    }

    public static void main(String[] args) {
            newGame("Player One", "Player 2");
            deck.zipShuffle(3);
            deck.randomShuffle();
            while (!deck.isEmpty()){
                player1.getHand().addCard(deck.deal());
                player2.getHand().addCard(deck.deal());
            }
            System.out.println("Let's play War!\n");
            System.out.println("HOW TO PLAY:\n\nEach player turns up a card at the same time and the \n" +
                    "player with the higher rank card takes both cards and puts them, \n" +
                    "face down, on the bottom of their stack.\n\n" +
                    "If the cards are the same rank, it is War. Each player turns \n" +
                    "three cards face down and the fourth card face up. The player with the \n" +
                    "higher rank cards takes both piles. If the turned-up cards \n" +
                    "are again the same rank, the player with the \n" +
                    "higher suited card and takes all 10 cards.\n\n" +
                    "The game ends when one player has won all the cards.\n");
            for (int i = 1; i <= numRounds; i++) {
                System.out.println("---------- Round "+ i + " ----------");
                playRound();
                System.out.println("**********************");
                System.out.println();
                System.out.println(player1.getName() + "'s Card count = " + player1.getHand().getCardCount());
                System.out.println(player2.getName() + "'s Card count = " + player2.getHand().getCardCount());
                System.out.println();
            }
        }

    public static void transferCards(Player losingPlayer, Player winningPlayer, int numCardsTransferred){
        for (int i=0; i<numCardsTransferred; i++){
            Card loser = losingPlayer.getHand().removeFirstCard();
            winningPlayer.getHand().addCard(loser);
        }
        winningPlayer.getHand().putCardsAtEnd(numCardsTransferred);
    }

    public static Player compareRank(int p1Position, int p2Position){
        //get both players card rank at the position passed into the parameter
        RANK p1Rank = player1.getHand().getCards()[p1Position].getRank();
        RANK p2Rank = player2.getHand().getCards()[p2Position].getRank();
        //compare ranks
        if (p1Rank.compareTo(p2Rank) < 0) {
            return player2;
        } else if (p1Rank.compareTo(p2Rank) > 0) {
            return player1;
        }
        else {
            return null;
        }
    }

    public static Player tieBreakWithSuit(int p1Position, int p2Position){
        //get both player's card suit at the position passed in the parameter
        SUIT p1Suit = player1.getHand().getCards()[p1Position].getSuit();
        SUIT p2Suit = player2.getHand().getCards()[p2Position].getSuit();

        // compare suit
        if (p2Suit.compareTo(p1Suit) < 0) {
            return player1;
        }
        else {
            return player2;
        }

    }

    public static Player war(){
        p1SkipIndex = 4;
        p2SkipIndex = 4;
        int p1 = player1.getHand().getCardCount();
        int p2 = player2.getHand().getCardCount();
        if (p1 < 5) {
            p1SkipIndex = p1 - 1;
        }
        if (p2 < 5) {
            p2SkipIndex = p2 - 1;
        }
        System.out.println(player1.getHand().getCards()[p1SkipIndex].toString());
        System.out.println(player2.getHand().getCards()[p2SkipIndex].toString());
        Player compare = compareRank(p1SkipIndex, p2SkipIndex);
        if (compare == null) {
            return tieBreakWithSuit(p1SkipIndex, p2SkipIndex);
        } else {
            return compare;
        }

    }

    public static void playRound(){
        player1.getName();
        player2.getName();
        System.out.println(player1.getHand().getCards()[0].toString());
        System.out.println(player2.getHand().getCards()[0].toString());
        Player winner = compareRank(0, 0);
        if (winner == player1) {
            transferCards(player2, player1, 1);
        } else if (winner == player2) {
            transferCards(player1, player2, 1);
        } else if (winner == null) {
            winner = war();
            transferCards(winner == player1 ? player2 : player1, winner, 5);
        }
        }

    }
