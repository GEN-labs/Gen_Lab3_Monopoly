
public class Player {

    public static final int INITIAL_NETWORTH = 1500;

    private String name;
    private Piece piece;
    private Board board;
    private Cup cup;
    private int netWorth;

    public Player(String name, Board board, Cup cup){
        this.name = name;
        this.board = board;
        this.cup = cup;
        this.netWorth = 1500;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }
    
    public String getName(){
        return this.name;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void takeTurn(){
        cup.roll();
        int fvTot = cup.getTotal();
        System.out.println("Total du lancer des dés : " + fvTot);

        piece.setLocation(board.getSquare(piece.getLocation(), fvTot));

    }

    public int getNetWorth() {
        return netWorth;
    }

    public void addCash(int value){
        if(value < 0){
            System.out.println("La valeur doit être > 0 !");
            return;
        }
        this.netWorth += value;
    }

    public void reduceCash(int min) {
        //TODO check bound ? no negatif netWorth
        netWorth -= min;
    }

}
