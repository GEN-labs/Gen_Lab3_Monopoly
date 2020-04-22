import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoSquareTest {

    @Test
    void goSquareTest(){
        Board board = new Board();
        Player p = new Player("Maurice", board, new Cup(new Dice[]{new Dice(), new Dice()}));
        p.setPiece(new Piece("Piece ", board.getSquare(0)));

        GoSquare goSquare = (GoSquare) board.getSquare(0);

        goSquare.landOn(p);

        assertEquals(200 + Player.INITIAL_NETWORTH, p.getNetWorth());
    }
}
