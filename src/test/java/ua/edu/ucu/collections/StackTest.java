package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {
    private Stack stack;

    @Before
    public void init() {
        stack = new Stack();
    }

    @Test
    public void testPush() {
        stack.push(5);
        int expectedValue = 5;
        assertEquals(expectedValue, stack.peek());
    }

    @Test
    public void testPeek() {
        stack.push(5);
        Object expectedValue = 5;
        Object actualValue = stack.peek();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testPop() {
        Object expectedValue = 5;
        stack.push(5);
        Object actualValue = stack.pop();
        assertEquals(expectedValue, actualValue);
    }

}

