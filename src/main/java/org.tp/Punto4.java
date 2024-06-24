package main.java.org.tp;

import main.java.org.tp.implementation.StaticStack;
import main.java.org.tp.implementation.StaticSet;
import main.java.org.tp.implementation.StaticQueue;

// @Matias Aleksandrowicz
public class Punto4 {
    public static void main(String[] args) {
        StaticStack stack = new StaticStack.Builder()
                .add(1)
                .add(2)
                .add(3)
                .build();

        StaticSet set = new StaticSet.Builder()
                .add(4)
                .add(5)
                .add(6)
                .build();

        StaticStack stackWithSetElements = new StaticStack.Builder()
                .addAll(set)
                .build();

        // Trabaja con las pilas y conjuntos
        System.out.println("Elemento superior de stack: " + stack.getTop()); // Salida: 3
        stack.remove();
        System.out.println("Elemento superior de stack: " + stack.getTop()); // Salida: 2

        System.out.println("Elemento superior de stackWithSetElements: " + stackWithSetElements.getTop()); // Salida: 6
        stackWithSetElements.remove();
        System.out.println("Elemento superior de stackWithSetElements: " + stackWithSetElements.getTop()); // Salida: 5

        // Creación de una cola vacía
        StaticQueue emptyQueue = new StaticQueue();

        // Creación de una cola con elementos iniciales
        StaticQueue queueWithElements = new StaticQueue(1, 2, 3, 4, 5);

        // Trabaja con las colas
        System.out.println("El primer elemento de la cola con elementos: " + queueWithElements.getFirst()); // Salida: 1
        queueWithElements.remove();
        System.out.println("El primer elemento de la cola con elementos después de remover: " + queueWithElements.getFirst()); // Salida: 2

    }
}
