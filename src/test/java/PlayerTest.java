
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    private Board board = new Board();
    private Dice[] dices = {new Dice(), new Dice()};
    private Cup cup = new Cup(dices);

    @Test
    void getPlayerName(){
        Player player = new Player("Nico le poireau", board, cup);
        assertEquals(player.getName(), "Nico le poireau");
    }

    @Test
    void getPlayerPieceAndSetPlayerPiece(){

        Piece piece = new Piece("chaussure", new RegularSquare(0, "JE_SUIS_UN_SQUARE"));
        Player player = new Player("Nico le poireau", board, cup);
        player.setPiece(piece);
        assertEquals(player.getPiece(), piece);
    }

    @Test
    void testTakeTurn() {
        Piece piece = new Piece("chaussure", board.getSquare(0));
        Player player = new Player("Nico le poireau", board, cup);
        player.setPiece(piece);

        Square actualSquare = player.getPiece().getLocation();
        player.takeTurn();
        Square newSquare = player.getPiece().getLocation();

        assertNotEquals(actualSquare, newSquare);
    }

    @Test
    void getInitialNetWorthTest(){
        Player p = new Player("Maurice", board, cup);

        assertEquals(Player.INITIAL_NETWORTH, p.getNetWorth());
    }

    @Test
    void addCashTest(){
        Player p = new Player("Maurice", board, cup);
        p.addCash(1000);
        assertEquals(Player.INITIAL_NETWORTH + 1000, p.getNetWorth());
    }

    @Test
    void addCashNegativeValueTest() throws Exception{
        assertThrows(IllegalArgumentException.class, () -> {
            Player p = new Player("Maurice", board, cup);
            p.addCash(-200);
        });
    }

    @Test
    void reduceCashTest() {
        Player p = new Player("Maurice", board, cup);
        p.reduceCash(200);
        assertEquals(p.getNetWorth(),Player.INITIAL_NETWORTH - 200);
    }

    @Test
    void reduceCashZeroTest(){
        Player p = new Player("Maurice", board, cup);
        p.reduceCash(2000);
        assertEquals(p.getNetWorth(),0);
    }
}
