package main.java.org.tp.definition;

public interface GSet<T> {
    void add(T a);
    void remove(T a);
    boolean isEmpty();
    T choose();
}