package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes2() {
        IntList snd = IntList.of(1, 4, 8, 10);
        boolean changed = IntListExercises.squarePrimes(snd);
        assertEquals("1 -> 4 -> 8 -> 10", snd.toString());
        assertFalse(changed);
    }

    @Test
    public void testSquarePrimes4() {
        IntList fth = IntList.of(3, 7, 11, 22);
        boolean changed = IntListExercises.squarePrimes(fth);
        assertEquals("9 -> 49 -> 121 -> 22", fth.toString());
        assertTrue(changed);
    }
}
