import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncomeTaxSquareTest {

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
}
