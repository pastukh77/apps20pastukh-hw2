package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private final Object[] elements;
    private int size;
    private static final int DEFAULT = 10;

    public ImmutableArrayList() {
        this(new Object[DEFAULT], DEFAULT);
        size = 0;
    }

    public ImmutableArrayList(Object[] source, int capacity) {
        capacity = capacity > source.length ? capacity : source.length;
        elements = Arrays.copyOf(source, capacity);
        size = source.length;
    }

    private static void shiftRight(Object[] arr, int start,
                                   int size, int shiftSize) {
        for (int i = 1; i < size - start + 1; i++) {
            arr[size + shiftSize - i] = arr[size - i];
        }
    }

    private static void shiftLeft(Object[] arr, int start, int shiftSize) {
        for (int i = start; i < arr.length && (i - shiftSize) >= 0; i++) {
            arr[i - shiftSize] = arr[i];
        }
    }

    private void crementSize(int crement) {
        size = size + crement;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size, e);
    }


    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});

    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ImmutableArrayList clone = new ImmutableArrayList(
                Arrays.copyOfRange(elements, 0, size),
                size + c.length);
        shiftRight(clone.elements, index, size, c.length);
        int cnt = 0;
        for (int i = index; i < index + c.length; i++) {
            clone.elements[i] = c[cnt];
            cnt++;
            clone.crementSize(1);
        }
        return clone;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList clone = new
                ImmutableArrayList(Arrays.copyOfRange(
                        elements, 0, size), size - 1);
        shiftLeft(clone.elements, index + 1, 1);
        clone.crementSize(-1);
        return clone;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableArrayList clone = new
                ImmutableArrayList(Arrays.copyOfRange(
                        elements, 0, size), 2 * size);
        clone.elements[index] = e;
        return clone;

    }

    @Override
    public int indexOf(Object e) {
        int cnt = 0;
        for (Object obj : elements) {
            if (obj.equals(e)) {
                return cnt;
            }
            cnt++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(Arrays.copyOfRange(elements, 0, size), size);
    }

    @Override
    public String toString() {
        StringBuffer arrayStr = new StringBuffer();
        arrayStr.append("{");
        for (int i = 0; i < size; i++) {
            arrayStr.append(elements[i]);
            if (i != size - 1) {
                arrayStr.append(", ");
            }
        }
        arrayStr.append("}");
        return arrayStr.toString();

    }
}

