package cz.erebos.cpa.core.history;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BoundedFifo<T> {

    private final int capacity;
    private final Deque<T> deque;

    public BoundedFifo(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be > 0");
        this.capacity = capacity;
        this.deque = new ArrayDeque<>(capacity);
    }

    public synchronized void add(T item) {
        if (deque.size() == capacity) {
            deque.removeFirst();
        }
        deque.addLast(item);
    }

    public synchronized int size() {
        return deque.size();
    }

    public int capacity() {
        return capacity;
    }

    public synchronized T peekOldest() {
        return deque.peekFirst();
    }

    public synchronized T peekNewest() {
        return deque.peekLast();
    }

    public synchronized List<T> snapshot() {
        return new ArrayList<>(deque);
    }

    public synchronized void clear() {
        deque.clear();
    }
}