import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CupTest {

    @RepeatedTest(10)
    public void testTotalValueIsInRightRange() {
        Dice[] dices = {new Dice(), new Dice()};
        Cup cup = new Cup(dices);
        cup.roll();
        assertTrue(cup.getTotal() >= 2 && cup.getTotal() <= 12);
    }
}