package main.java.org.tp.implementation;

import main.java.org.tp.definition.Queue;

public class StaticQueue implements Queue {

    private static final int MAX = 10000;
    private final int[] array;
    private int count;

    // Constructor sin parámetros
    public StaticQueue() {
        this.array = new int[MAX];
        this.count = 0;
    }

    // Constructor con cantidad de parámetros variables (varargs)
    public StaticQueue(int... elements) {
        this.array = new int[MAX];
        this.count = 0;
        for (int element : elements) {
            this.add(element);
        }
    }

    @Override
    public void add(int a) {
        if (count == MAX) {
            throw new RuntimeException("No se puede agregar el elemento");
        }
        array[count] = a;
        count++;
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
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
    public int getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacía");
        }
        return array[0];
    }
}
