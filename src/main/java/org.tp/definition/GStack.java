package main.java.org.tp.definition;

// @Matias Aleksandrowicz
public interface GStack<T>{
    void add(T a);
    void remove();
    boolean isEmpty();
    T getTop();
}
