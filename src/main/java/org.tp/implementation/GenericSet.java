package main.java.org.tp.implementation;

import main.java.org.tp.definition.GSet;
import java.util.Random;

public class GenericSet<T> implements GSet<T> {
    private static final int MAX = 10000;

    private Object[] array;
    private int count;

    public GenericSet() {
        this.array = new Object[MAX];
        this.count = 0;
    }

    public GenericSet(GenericSet<T> other) {
        this.array = new Object[MAX];
        this.count = other.count;
        System.arraycopy(other.array, 0, this.array, 0, other.count);
    }

    @Override
    public void add(T a) {
        if (count == MAX) {
            throw new RuntimeException("Limite de elementos alcanzado");
        }
        for (int i = 0; i < count; i++) {
            if (this.array[i].equals(a)) {
                return;
            }
        }
        this.array[count] = a;
        this.count++;
    }

    @Override
    public void remove(T a) {
        for (int i = 0; i < count; i++) {
            if (this.array[i].equals(a)) {
                this.array[i] = this.array[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T choose() {
        if (this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        @SuppressWarnings("unchecked")
        T element = (T) this.array[new Random().nextInt(this.count)];
        return element;
    }

    // metodo auxiliar para copiar el Set
    public GenericSet<T> copy() {
        return new GenericSet<>(this);
    }
}
