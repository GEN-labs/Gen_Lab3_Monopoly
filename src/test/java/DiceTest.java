

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @RepeatedTest(10)
    public void testFaceValueIsInRightRange(){
        Dice dice = new Dice();
        dice.roll();
        assertTrue(dice.getFaceValue() >= 1 && dice.getFaceValue() <= 6);
    }
}
