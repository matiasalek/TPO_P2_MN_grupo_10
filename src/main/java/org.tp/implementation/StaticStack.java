package main.java.org.tp.implementation;

import main.java.org.tp.definition.Stack;
import main.java.org.tp.definition.Set;

public class StaticStack implements Stack {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    private StaticStack(Builder builder) {
        this.array = new int[MAX];
        this.count = 0;
        // Add all elements from the builder to the stack
        for (int element : builder.elements) {
            this.add(element);
        }
    }

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (this.count >= MAX) {
            throw new RuntimeException("Limite excedido");
        }
        this.array[this.count++] = a;
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        this.count--;
    }

    @Override
    public int getTop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return this.array[this.count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    public static class Builder {
        private final int[] elements;
        private int size;

        public Builder() {
            this.elements = new int[MAX];
            this.size = 0;
        }

        public Builder add(int a) {
            if (size >= MAX) {
                throw new RuntimeException("Limite excedido");
            }
            this.elements[size++] = a;
            return this;
        }

        public Builder addAll(Set set) {
            // Assuming set is an instance of StaticSet
            StaticSet staticSet = (StaticSet) set;
            for (int i = 0; i < staticSet.count; i++) {
                this.add(staticSet.array[i]);
            }
            return this;
        }

        public StaticStack build() {
            return new StaticStack(this);
        }
    }
}
