package main.java.org.tp.definition;

import main.java.org.tp.implementation.StaticQueue;

// @Matias Saffirio
public interface Queue_mod {
    /**
     * Postcondicion: Acola (coloca en el final de la cola) un valor.
     *
     * @param a valor a acolar.
     */
    void add(StaticQueue a);

    /**
     * Precondicion: La cola no esta vacia.
     * Postcondicion: Desacola (quita el primer elemento).
     */
    void remove();

    /**
     * @return <code>true</code> si la cola esta vacia, <code>false</code> en otro caso.
     */
    boolean isEmpty();

    /**
     * @return Devuelve el primero.
     */
    Queue getFirst();
}
