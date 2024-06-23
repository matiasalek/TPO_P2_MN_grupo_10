package main.java.org.tp.definition;

public interface GQueue<T> {
    void add(T a);
    void remove();
    boolean isEmpty();
    T getFirst();
}
