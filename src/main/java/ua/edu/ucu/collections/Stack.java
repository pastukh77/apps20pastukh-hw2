package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList elements;

    public Stack() {
        elements = new ImmutableLinkedList();
    }

    public Object peek() {
        return elements.getLast();
    }

    public Object pop() {
        Object e = elements.getLast();
        elements = elements.removeLast();
        return e;
    }

    public void push(Object e) {
        elements = elements.addLast(e);
    }
}