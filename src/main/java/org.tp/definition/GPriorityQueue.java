package main.java.org.tp.definition;

public interface GPriorityQueue<T> {
    void add(T a, int priority);
    void remove();
    boolean isEmpty();
    T getFirst();
    int getPriority();
    }