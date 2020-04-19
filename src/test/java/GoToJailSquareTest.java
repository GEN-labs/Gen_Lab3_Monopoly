import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoToJailSquareTest {

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
}
