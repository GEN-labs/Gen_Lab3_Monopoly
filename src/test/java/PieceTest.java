

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    void testGetLocation(){
        Square square = new GoSquare(0,"Go");
        Piece piece = new Piece("Piece 1", square);
        assertNotNull(piece.getLocation());
        assertEquals(piece.getLocation(), square);
    }

    @Test
    void testSetLocation(){
        Square square = new GoSquare(0,"Go");
        Piece piece = new Piece("Piece 1", square);
        Square newSquare = new RegularSquare(1, "NotGo");
        piece.setLocation(newSquare);
        assertNotNull(piece.getLocation());
        assertEquals(piece.getLocation(), newSquare);
        assertNotEquals(piece.getLocation(), square);
    }

    @Test
    void testGetName(){
        String name = "Piece";
        Piece piece = new Piece(name, new GoSquare(0,"Go"));
        assertNotNull(piece.getName());
        assertEquals(piece.getName(), name);
    }

}
