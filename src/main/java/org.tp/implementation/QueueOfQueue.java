package main.java.org.tp.implementation;

import main.java.org.tp.definition.Queue;
import main.java.org.tp.definition.Queue_mod;
import main.java.org.tp.definition.Stack;


// @Matias Saffirio
public class QueueOfQueue implements Queue_mod {

    private final StaticQueue[] queues;
    private int count;

    //partiendo de la implementacion StaticQueue
    public QueueOfQueue() {
        queues = new StaticQueue[10000];
        count = 0;
    }

    public void add(StaticQueue queue) {
        if (count == queues.length) {
            throw new RuntimeException("No se puede agregar la cola");
        }
        queues[count] = queue;
        count++;
    }

    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        for (int i = 0; i < count - 1; i++) {
            queues[i] = queues[i + 1];
        }
        count--;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public StaticQueue getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("No se puede obtener la primera cola de una cola vacia");
        }
        return queues[0];
    }

    public static QueueOfQueue concatenate(QueueOfQueue... queueOfQueues) {
        QueueOfQueue result = new QueueOfQueue();
        for (QueueOfQueue qoq : queueOfQueues) {
            for (int i = 0; i < qoq.count; i++) {
                result.add(qoq.queues[i]);
            }
        }
        return result;
    }

    public StaticQueue flat() {
        StaticQueue queueFlat = new StaticQueue();
        for (int i = 0; i < count; i++) {
            StaticQueue currentQueue = queues[i];
            while (!currentQueue.isEmpty()) {
                queueFlat.add(currentQueue.getFirst());
                currentQueue.remove();
            }
        }
        return queueFlat;
    }

    public void reverseWithDepth() {
        // invierto el orden de las colas en QueueOfQueue
        for (int i = 0; i < count / 2; i++) {
            StaticQueue temp = queues[i];
            queues[i] = queues[count - 1 - i];
            queues[count - 1 - i] = temp;
        }

        // invierto el orden de los elementos en cada StaticQueue
        for (int i = 0; i < count; i++) {
            queues[i] = reverseQueue(queues[i]);
        }
    }

    private StaticQueue reverseQueue(StaticQueue queue) {
        StaticStack stack_temp = new StaticStack();
        while (!queue.isEmpty()) {
            stack_temp.add(queue.getFirst());
            queue.remove();
        }

        StaticQueue reversedQueue = new StaticQueue();
        while (!stack_temp.isEmpty()) {
            reversedQueue.add(stack_temp.getTop());
        }
        return reversedQueue;
    }
}
