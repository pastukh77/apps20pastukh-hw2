package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class ImmutableArrayListTest {

    private ImmutableArrayList simple;
    private ImmutableArrayList empty;
    private ImmutableArrayList oneElement;

    @Before
    public void init() {
        Object[] oneEl = new Object[] {1};
        Object[] simpleArr = new Object[] {1, 2, 3, 4, 5};
        simple = new ImmutableArrayList(simpleArr, simpleArr.length);
        empty = new ImmutableArrayList();
        oneElement = new ImmutableArrayList(oneEl, oneEl.length);
    }

    @Test
    public void testIsEmptyWithEmpty() {
        boolean actual = empty.isEmpty();
        assertTrue(actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithEmpty() {
        empty.get(0);
    }

    @Test
    public void testToArrayWithEmpty() {
        Object[] expected = new Object[]{};
        Object[] actual = empty.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddAllWithEmpty() {
        Object[] expected = new Object[]{1, 1};
        assertArrayEquals(expected, empty.addAll(new Object[]{1, 1}).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIncorrectIndexWithEmpty(){
        empty.addAll(1, new Object[]{7});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstWithEmpty() {
        empty.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastWithEmpty() {
        empty.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIncorrectIndexWithEmpty() {
        empty.get(1);
    }

    @Test
    public void testIsClearWithEmpty() {
        ImmutableArrayList expected = new ImmutableArrayList();
        assertArrayEquals(expected.toArray(), empty.clear().toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithEmpty() {
        empty.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIncorrectIndexWithEmpty() {
        empty.remove(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithEmpty() {
        empty.set(0, 77);
    }

    @Test
    public void testSizeWithEmpty() {
        int expected = 0;
        int actual = empty.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithEmpty() {
        String expected = "{}";
        String actual = empty.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmptyWithOneElement() {
        boolean actual = oneElement.isEmpty();
        assertFalse(actual);
    }
    @Test
    public void testGetWithOneElement() {
        Object expected = 1;
        Object actual = oneElement.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testToArrayWithOneElement() {
        Object[] expected = new Object[]{1};
        Object[] actual = oneElement.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddAllWithOneElement() {
        Object[] expected = new Object[]{1, 1, 2};
        assertArrayEquals(expected, oneElement.addAll(new Object[]{1, 2}).toArray());
    }

    @Test
    public void testAddAllWithIndexingOneElement() {
        Object[] expected = new Object[]{3, 2, 1};
        assertArrayEquals(expected,
                oneElement.addAll(0, new Object[]{3, 2}).toArray());
    }

    @Test
    public void testAddWithIndexingOneElement() {
        Object[] expected = new Object[]{2, 1};
        assertArrayEquals(expected, oneElement.add(0, 2).toArray());
    }

    @Test
    public void testAddWithOneElement() {
        Object[] expected = new Object[]{1, 2};
        assertArrayEquals(expected, oneElement.add(2).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIncorrectIndexWithOneElement() {
        oneElement.get(1);
    }

    @Test
    public void testClearWithOneElement() {
        Object[] expected = new Object[]{};
        Object[] actual = oneElement.clear().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWithOneElement() {
        Object[] expected = new Object[]{};
        Object[] actual = oneElement.remove(0).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIncorrectIndexWithOneElement() {
        oneElement.remove(1);
    }
    // set size index toStr
    @Test
    public void testSetWithOneElement() {
        Object exp = 2;
        Object act = oneElement.set(0, 2).get(0);
        assertEquals(exp, act);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIncorrectIndexWithOneElement() {
        oneElement.set(1, 2);
    }

    @Test
    public void testSizeWithOneElement() {
        int expected = 1;
        int actual = oneElement.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexoFWithOneElement() {
        int expected = 0;
        int actual = oneElement.indexOf(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithOneElement() {
        String expected = "{1}";
        String actual = oneElement.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmptyWithSimple() {
        boolean actual = simple.isEmpty();
        assertFalse(actual);
    }
    @Test
    public void testGetWithSimple() {
        Object expected = 1;
        Object actual = simple.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAnotherWithSimple() {
        Object expected = 2;
        Object actual = simple.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testToArrayWithSimple() {
        Object[] expected = new Object[]{1, 2, 3, 4, 5};
        Object[] actual = simple.toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddAllWithSimple() {
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 1, 2};
        assertArrayEquals(expected, simple.addAll(new Object[]{1, 2}).toArray());
    }

    @Test
    public void testAddAllWithIndexingSimple() {
        Object[] expected = new Object[]{1, 2, 3, 3, 2, 4, 5};
        assertArrayEquals(expected, simple.addAll(3, new Object[]{3, 2}).toArray());
    }

    @Test
    public void testAddWithIndexingSimple() {
        Object[] expected = new Object[]{1, 2, 3, 77, 4, 5};
        assertArrayEquals(expected, simple.add(3, 77).toArray());
    }

    @Test
    public void testAddWithSimple() {
        Object[] expected = new Object[]{1, 2, 3, 4, 5, 77};
        assertArrayEquals(expected, simple.add(77).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIncorrectIndexWithSimple() {
        simple.get(5);
    }

    @Test
    public void testClearWithOneSimple() {
        Object[] expected = new Object[]{};
        Object[] actual = simple.clear().toArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWithSimple() {
        Object[] expected = new Object[]{1, 2, 3, 5};
        Object[] actual = simple.remove(3).toArray();
        assertArrayEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIncorrectIndexWithSimple() {
        simple.remove(5);
    }

    @Test
    public void testSetWithSimple() {
        Object exp = 2;
        Object act = simple.set(0, 2).get(0);
        assertEquals(exp, act);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetIncorrectIndexWithSimple() {
        simple.set(5, 2);
    }

    @Test
    public void testSizeWithSimple() {
        int expected = 5;
        int actual = simple.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexoFWithSimple() {
        int expected = 4;
        int actual = simple.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringWithSimple() {
        String expected = "{1, 2, 3, 4, 5}";
        String actual = simple.toString();
        assertEquals(expected, actual);
    }
}
