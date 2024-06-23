package main.java.org.tp.definition;

public interface GStack<T>{
    void add(T a);
    void remove();
    boolean isEmpty();
    T getTop();
}
