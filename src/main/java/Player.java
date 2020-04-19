
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
        piece.getLocation().landOn(this);
    }

    public int getNetWorth() {
        return netWorth;
    }

    public void addCash(int value) throws IllegalArgumentException{
        if(value < 0){
            throw new IllegalArgumentException("La valeur doit être > 0!");
        }
        this.netWorth += value;
    }

    /*
    @remark netWorth can't be lower than 0
     */
    public void reduceCash(int min) {
        netWorth -= min;
        if(netWorth < 0){
            netWorth = 0;
        }
    }

}
