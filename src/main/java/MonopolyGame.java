

public class MonopolyGame {

    private static final int MAX_ROUND = 20;

    private Player[] players;
    private final Board board = new Board();
    private final Dice[] dices = {new Dice(), new Dice()};
    private final Cup cup = new Cup(dices);

    public MonopolyGame(int numberOfPlayer){
        //NumberOfPlayer is checked in the main console

        this.players =  new Player[numberOfPlayer];
        for (int i = 0; i < numberOfPlayer; i++) {
            this.players[i] = new Player("Player " + i, board, cup);
            this.players[i].setPiece(new Piece("Piece " + i, board.getSquare(0)));
        }
        System.out.println(this);
    }

    public void playGame(){
        System.out.println("La partie commence.\n");
        for (int i = 0; i < MAX_ROUND; i++) {
            System.out.println("Tour numero : " + i + "\n");
            playRound();
            System.out.println("#########################################");
        }
    }

    private void playRound(){
        for(Player player : players){
            System.out.println("Tour du joueur : " + player.getName());
            player.takeTurn();
            System.out.println("Argent disponible : " + player.getNetWorth() + "\n");
        }
    }
}
