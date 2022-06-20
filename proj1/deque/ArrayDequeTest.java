package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class ArrayDequeTest {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        ArrayDeque<Integer> correct = new ArrayDeque<>();

        int[] addItem = {4, 5, 6};
        for (int i = 0; i < addItem.length; i++){
            correct.addFirst(addItem[i]);
            correct.addFirst(addItem[i]);
            correct.addLast(addItem[i]);
            correct.addLast(addItem[i]);
        }
        correct.printDeque();
        assertEquals(12, correct.size());

        for (int i = 0; i < addItem.length; i++){
            correct.removeLast();
            correct.removeFirst();
            correct.removeFirst();
            int a = correct.get(0);
        }
        correct.removeLast();
        correct.removeFirst();
        correct.printDeque();
        correct.removeFirst();
        correct.printDeque();

    }
    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();

        int N = 1000, s = 0;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                s += 1;
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(s, size);
            } else if (L.size() > 0) {
                if (operationNumber == 2) {
                    int m = 3;
                    L.addFirst(m);
                    s += 1;
                }else if (operationNumber == 3) {
                    int removeVal = L.removeLast();
                    s -= 1;
                }else if (operationNumber == 4) {
                    int removeValFirst = L.removeFirst();
                    s -= 1;
                }
            }

        }
    }
}

