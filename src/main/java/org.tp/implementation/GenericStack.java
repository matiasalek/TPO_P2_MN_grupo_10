package main.java.org.tp.implementation;

import main.java.org.tp.definition.GStack;

public class GenericStack<T> implements GStack<T> {
    private static final int MAX = 10000;

    private final Object[] array;
    private int count;

    public GenericStack() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    @Override
    public void add(Object a) {
        if (this.count >= MAX) {
            throw new RuntimeException("Limite excedido.");
        }
        this.array[this.count++] = a;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacia.");
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacia.");
        }
        T top = (T) this.array[this.count - 1];
        return top;
    }
}
