public class Board {

    private static final int BOARD_SIZE = 40;
    public static final int GO_TO_JAIL_POSITION = 25;
    public static final int JAIL_POSITION = 19;
    public static final int[] INCOME_TAX_POSITION = {15, 30};

    private Square[] squares;

    public Board(){
        this.squares =  new Square[BOARD_SIZE];
        squares[0] = new GoSquare(0,"Go");
        for (int i = 1; i < BOARD_SIZE; i++) {
            squares[i] = new RegularSquare(i,"Square " + i);
        }

        //Set positions of "special" squares
        for(int its : Board.INCOME_TAX_POSITION)
            squares[its] = new IncomeTaxSquare(its);

        squares[Board.JAIL_POSITION] = new JailSquare(Board.JAIL_POSITION);
        squares[Board.GO_TO_JAIL_POSITION] = new GoToJailSquare(GO_TO_JAIL_POSITION, (JailSquare) squares[Board.JAIL_POSITION]);

    }

    public Square getSquare(Square oldLoc, int fvTot){
        int newPos = (oldLoc.getId() + fvTot) % BOARD_SIZE;
        Square newLoc = squares[newPos];

        System.out.println("Deplacement : " + oldLoc.getName() + " =====> " + newLoc.getName() + "\n");

        return newLoc;
    }

    public Square getSquare(int id){
        if(id >= BOARD_SIZE || id < 0){
            throw new IndexOutOfBoundsException("This square is out of the board");
        }
        return squares[id];
    }
}
