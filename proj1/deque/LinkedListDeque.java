package deque;

//import java.util.Deque;

public class LinkedListDeque<T> {
    public class DequeNode {
        public T val;
        public DequeNode next;
        public DequeNode prev;

        public DequeNode (T v, DequeNode n, DequeNode p) {
            val = v;
            next = n;
            prev = p;
        }
    }

    private DequeNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new DequeNode((T)"null", null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new DequeNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new DequeNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DequeNode B = sentinel.next;
        for (int i = 0; i < size; i++){   // not sure
            System.out.print(B.val + " ");
            B = B.next;
        }
        System.out.println();
    }

    public T get(int index) {
        DequeNode B = sentinel.next;
        for (int i = 0; i < size; i++){
            if (i == index) {
                return B.val;
            }
            B = B.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index > size || isEmpty() || index < 0) {
            return null;
        }
        return RecursiveHelper(sentinel.next, index);
    }

    private T RecursiveHelper(DequeNode B, int index){
        if (index == 0) {
            return B.val;
        }
        B = B.next;
        return RecursiveHelper(B, index - 1);

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T x = sentinel.next.val;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return x;
    }

    /* avoid using get() here which waste much time*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T x = sentinel.prev.val;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return x;
    }

//    public Iterator<T> iterator() {}

    public boolean equals(Object o) {
        if (o instanceof LinkedListDeque && ((LinkedListDeque<?>) o).size == size) {
            return equalsHelper((LinkedListDeque) o);
        }
        return false;
    }

    public boolean equalsHelper(LinkedListDeque oppo) {
        for (int i = 0; i < size; i++){
            if (oppo.get(i) != this.get(i)) {
                return false;
            }
        }
        return true;
    }

}

