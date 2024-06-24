package main.java.org.tp.implementation;

import main.java.org.tp.definition.GQueue;

// @Matias Aleksandrowicz
public class GenericQueue<T> implements GQueue<T> {
    private static final int MAX = 10000;
    private final T[] array;
    private int count;

    public GenericQueue() {
        this.array = (T[]) new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(Object a) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = (T) a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for (int i = 0; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return array[0];
    }
}
