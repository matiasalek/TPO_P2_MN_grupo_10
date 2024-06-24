package main.java.org.tp;

import main.java.org.tp.definition.Set;
import main.java.org.tp.implementation.StaticStack;
import main.java.org.tp.implementation.StaticSet;


// @Matias Saffirio
public class Punto5 {
    public static void main(String[] args) {
        //Ejercicio 5
        //Dada una pila de elementos desordenados, generar una nueva pila sin elementos repetidos y ordenados
        System.out.print("IMPRIMO PILA CON REPES");
        StaticStack test = new StaticStack();
        test.add(3);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(4);
        test.add(5);
        test.add(1);
        imprimirPila(test);
        System.out.print("IMPRIMO PILA SIN REPES");
        noRepStack(test);
        //como resultado del analisis del calculo de complejidad computacional, podemos decir que
        //el costo de noRepStack es O(n^2)


    }

    public static void noRepStack(StaticStack s) {
        StaticStack stack = new StaticStack();
        Set conj = new StaticSet();
        int aux =0;
        int aux2 = 0;
        while(!s.isEmpty()) {
            aux = s.getTop();
            conj.add(aux);
            s.remove();
        }

        while(!conj.isEmpty()) {
            aux2 = conj.choose();
            stack.add(aux2);
            conj.remove(aux2);
        }
        //Hasta aca la complejidad es lineal. Los metodos add y remove son constantes.

        ordenarPila(stack);
        // El metodo OrdenarPila tiene complejidad Cuadratica ya que
        // evaluando el peor de lo casos, cada elemento de la pila temp se compara con todos los elementos de la pila
        imprimirPila(stack);

    }

    public static void ordenarPila(StaticStack stack) {
        StaticStack stackAux = new StaticStack();
        boolean changed = true;

        while (changed) {
            changed = false;
            // Mover elementos de pila a stackAux e intercambiar si se necesita
            while (!stack.isEmpty()) {
                int actual = stack.getTop();
                stack.remove();
                if (!stack.isEmpty()) {
                    int nextVal = stack.getTop();
                    if (actual > nextVal) {
                        stackAux.add(nextVal);
                        stack.remove();
                        stack.add(actual);
                        changed = true;
                    } else {
                        stackAux.add(actual);
                    }
                } else {
                    stackAux.add(actual);
                }
            }

            // Muevo todos los elementos de stackAux de vuelta a stack
            while (!stackAux.isEmpty()) {
                stack.add(stackAux.getTop());
                stackAux.remove();
            }
        }
    }
    public static void imprimirPila(StaticStack pila) {
        StaticStack temp = new StaticStack();
        while (!pila.isEmpty()) {
            int valor = pila.getTop();
            System.out.println(valor);
            temp.add(valor);
            pila.remove();
        }
        while (!temp.isEmpty()) {
            pila.add(temp.getTop());
            temp.remove();
        }
        System.out.println();
    }
}
