package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();

        int[] addItem = {4, 5, 6};
        for(int i = 0; i < addItem.length; i++){
            correct.addLast(addItem[i]);
            buggy.addLast(addItem[i]);
        }

        assertEquals(correct.size(), buggy.size());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeBuggy = B.size();
                assertEquals(size, sizeBuggy);
            } else if (L.size() > 0) {
                if (operationNumber == 2) {
                    int lastVal = L.getLast();
                    int lastValBuggy = B.getLast();
                    assertEquals(lastVal, lastValBuggy);
                }else if (operationNumber == 3) {
                    int removeVal = L.removeLast();
                    int removeValBuggy = B.removeLast();
                    assertEquals(removeVal, removeValBuggy);
                }
            }

        }
    }
}
