public class Player {
    private Hand hand;
    private String name;

    public Player(String name){
        this.name = name;
        this.hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}
