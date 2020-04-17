import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board = new Board();

    @ParameterizedTest
    @ValueSource(ints = {-4, 40, 50})
    void testGetSquareOutOfBound(int pos){
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            board.getSquare(pos);
        });
        String expectedMessage = "This square is out of the board";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    void testGetSquare1(){
        Square sq = board.getSquare(12);
        Square newSq = board.getSquare(sq,10);
        assertEquals(sq.getId()+10,newSq.getId());
    }

    @Test
    void testGetSquare2(){
        Square sq = board.getSquare(33);
        assertEquals(33,sq.getId());
    }

}
