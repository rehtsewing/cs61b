package deque;

public class ArrayDeque<T> {
    private T[] ADeque;
    private int size;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        ADeque = (T []) new Object[8];
        size = 0;
        firstIndex = ADeque.length - 1;
        lastIndex = 0;
    }

    private void resize(int capacity) {
        T[] temp = (T []) new Object[capacity];
        int newFront = temp.length;
        int start = indexTrans(firstIndex + 1);
        int end = indexTrans(lastIndex - 1);
        if(start <= end || size == 0) {
            System.arraycopy(ADeque, start, temp, 0, size);
            lastIndex = size;
        }else{
            int lastRange = ADeque.length - start;
            newFront = capacity - lastRange;
            System.arraycopy(ADeque, 0, temp, 0, lastIndex);
            System.arraycopy(ADeque, start, temp, newFront, lastRange);
        }
        firstIndex = indexTrans(newFront - 1);
        ADeque = temp;
    }

    private int indexTrans(int index) {
        if(index < 0) {
            return ADeque.length - 1;
        }else if(index == ADeque.length) {
            return 0;
        }else {
            return index;
        }
    }

    public void addFirst(T item) {
        if (size == ADeque.length) {
            resize(size * 2);
        }
        ADeque[firstIndex] = item;
        firstIndex = indexTrans(firstIndex - 1);
        size += 1;
    }

    public void addLast(T item) {
        if (size == ADeque.length) {
            resize(size * 2);
        }
        ADeque[lastIndex] = item;
        lastIndex = indexTrans(lastIndex + 1);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = firstIndex;
        while (size != 0 && i >= firstIndex || i < lastIndex - 1) {
            i = indexTrans(i + 1);
            System.out.print(ADeque[i] + " ");
        }
        System.out.println();
    }

    public T get(int index) {
        if (size <= 0) {
            return null;
        }
        int actualIndex = firstIndex + index + 1;
        if (actualIndex < ADeque.length) {
            return ADeque[actualIndex];
        }else {
            return ADeque[actualIndex - ADeque.length];
        }
    }

    private void shrinkSize() {
        if (4 * size <= ADeque.length && size > 8) {
            resize((int) ADeque.length / 2);
        }
    }

    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        firstIndex = indexTrans(firstIndex + 1);
        T item = ADeque[firstIndex];
        ADeque[firstIndex] = null;
        size -= 1;
        shrinkSize();
        return item;
    }

    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        lastIndex = indexTrans(lastIndex - 1);
        T item = ADeque[lastIndex];
        ADeque[lastIndex] = null;
        size -= 1;
        shrinkSize();
        return item;
    }

//    public Iterator<T> iterator() {}

    public boolean equals(Object o) {
        if (o instanceof ArrayDeque && ((ArrayDeque<?>) o).size == size) {
            return equalsHelper((ArrayDeque) o);
        }
        return false;
    }

    public boolean equalsHelper(ArrayDeque oppo) {
        for (int i = 0; i < size; i++){
            if (oppo.get(i) != this.get(i)) {
                return false;
            }
        }
        return true;
    }

}
