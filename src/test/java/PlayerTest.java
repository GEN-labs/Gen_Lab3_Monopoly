
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PlayerTest {

    @Test
    void getPlayerName(){
        Board board = new Board();
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
        Player player = new Player("Nico le poireau", board, cup);
        assertEquals(player.getName(), "Nico le poireau");
    }

    @Test
    void getPlayerPieceAndSetPlayerPiece(){
        Board board = new Board();
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
        Piece piece = new Piece("chaussure", new RegularSquare(0, "JE_SUIS_UN_SQUARE"));
        Player player = new Player("Nico le poireau", board, cup);
        player.setPiece(piece);
        assertEquals(player.getPiece(), piece);
    }

    @Test
    void testTakeTurn() {
        Board board = new Board();
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
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
        Board board = new Board();
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
        Player p = new Player("Maurice", board, cup);
        assertEquals(Player.INITIAL_NETWORTH, p.getNetWorth());
    }

    @Test
    void addCashTest(){
        Board board = new Board();
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
        Player p = new Player("Maurice", board, cup);
        p.addCash(1000);
        assertEquals(Player.INITIAL_NETWORTH + 1000, p.getNetWorth());
    }

    @Test
    void reduceCashTest(){
        Board board = new Board();
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
        Player p = new Player("Maurice", board, cup);
        p.reduceCash(1000);
        assertEquals(Player.INITIAL_NETWORTH - 1000, p.getNetWorth());
    }

}
