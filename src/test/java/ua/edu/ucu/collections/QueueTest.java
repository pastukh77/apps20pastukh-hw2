package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    private Queue queue;

    @Before
    public void init() {
        queue = new Queue();
    }

    @Test
    public void testPeekAndEnqueue() {
        queue.enqueue(5);
        int expectedValue = 5;
        assertEquals(expectedValue, queue.peek());
    }

    @Test
    public void testDenqueue() {
        queue.enqueue(5);
        queue.enqueue(6);
        int expectedValue = 5;
        assertEquals(expectedValue, queue.dequeue());
    }
}

