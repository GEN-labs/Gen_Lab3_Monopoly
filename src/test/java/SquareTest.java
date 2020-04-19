import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;


public class SquareTest {


    @Test
    void goSquareTest(){
        Board board = new Board();
        Player p = new Player("Maurice", board, new Cup(new Dice[]{new Dice(), new Dice()}));
        p.setPiece(new Piece("Piece ", board.getSquare(0)));

        GoSquare goSquare = (GoSquare) board.getSquare(0);

        goSquare.landOn(p);

        assertEquals(200 + Player.INITIAL_NETWORTH, p.getNetWorth());

    }

    @Test
    void IncomeTaxSquareTenPercent() throws Exception {
        Board board = new Board();
        Player p = new Player("Maurice", board, new Cup(new Dice[]{new Dice(), new Dice()}));
        p.setPiece(new Piece("Piece ", board.getSquare(0)));

        IncomeTaxSquare incomeTaxSquare = (IncomeTaxSquare) board.getSquare(Board.INCOME_TAX_POSITION[0]);

        incomeTaxSquare.landOn(p);
        int expectedNetWorth = p.INITIAL_NETWORTH - (((Player.INITIAL_NETWORTH) / 100) * 10);
        //Tax is 10% of the networth
        assertEquals(expectedNetWorth , p.getNetWorth());
    }

    @Test
    void IncomeTaxSquareMinValue() throws Exception {
        Board board = new Board();
        Player p = new Player("Maurice", board, new Cup(new Dice[]{new Dice(), new Dice()}));
        p.setPiece(new Piece("Piece ", board.getSquare(0)));

        IncomeTaxSquare incomeTaxSquare = (IncomeTaxSquare) board.getSquare(Board.INCOME_TAX_POSITION[0]);

        p.addCash(10000);
        incomeTaxSquare.landOn(p);
        //Tax is 10% of the networth but if the 10% is greater than 200 we take 200
        assertEquals((Player.INITIAL_NETWORTH + 10000) - 200, p.getNetWorth());
    }

    @Test
    void goToJailTest(){
        Board board = new Board();
        Player p = new Player("Maurice", board, new Cup(new Dice[]{new Dice(), new Dice()}));
        p.setPiece(new Piece("Piece ", board.getSquare(0)));

        GoToJailSquare goToJailSquare = (GoToJailSquare) board.getSquare(Board.GO_TO_JAIL_POSITION);

        JailSquare jailSquare = (JailSquare) board.getSquare(Board.JAIL_POSITION);

        //Player land on goToJail square
        goToJailSquare.landOn(p);

        //Check that the player has landed in jail
        assertEquals(p.getPiece().getLocation().getId(), jailSquare.getId());

    }

    @Test
    void getSquareId(){
        Square square = new RegularSquare(0,"square");
        assertSame(square.getId(), 0);
    }
}