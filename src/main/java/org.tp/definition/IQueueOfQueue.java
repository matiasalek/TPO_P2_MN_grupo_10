package main.java.org.tp.definition;

import main.java.org.tp.implementation.StaticQueue;
import java.util.LinkedList;

public interface IQueueOfQueue {
    void addQueue(StaticQueue queue);
    LinkedList<StaticQueue> getQueues();
    static IQueueOfQueue concatenate(IQueueOfQueue... qoqs) {
        return null;
    }
    StaticQueue flat();
    void reverseWithDepth();
}
