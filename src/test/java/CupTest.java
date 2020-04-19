import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CupTest {

    private final Dice[] dices = {new Dice(), new Dice()};
    Cup cup = new Cup(dices);


    @RepeatedTest(10)
    public void testTotalValueIsInRightRange() {
        cup.roll();
        assertTrue(cup.getTotal() >= 2 && cup.getTotal() <= 12);
    }
}