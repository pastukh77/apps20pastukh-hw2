package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList elements;

    public Queue() {
        elements = new ImmutableLinkedList();
    }

    public void enqueue(Object e) {
        elements = elements.addLast(e);
    }

    public Object dequeue() {
        Object e = elements.getFirst();
        elements = elements.removeFirst();
        return e;
    }

    public Object peek() {
        return elements.getFirst();
    }
}
