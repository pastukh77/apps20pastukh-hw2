package ua.edu.ucu.collections.immutable;

import java.util.Objects;

public final class ImmutableLinkedList implements ImmutableList {

    static class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    private int llSize;

    private Node head;

    public ImmutableLinkedList() {
        head = null;
        llSize = 0;
    }

    public ImmutableLinkedList(Node node) {
        head = node;
        int counter = 0;
        Node temp = node;
        while (temp != null) {
            counter += 1;
            temp = temp.next;
        }
        llSize = counter;
    }

    public ImmutableLinkedList(Object[] objects) {
        if (objects.length != 0) {
            head = new Node(objects[0]);
            Node temp = head;
            for (int i = 1; i < objects.length; i++) {
                temp.next = new Node(objects[i]);
                temp = temp.next;
            }
        }
        llSize = objects.length;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private void checkIndexOutOfBounds() {
        if (llSize == 0) {
            throw new IndexOutOfBoundsException();
        }
    }


    public ImmutableLinkedList copy() {
        if (isEmpty()) {
            return new ImmutableLinkedList();
        } else {
            Node headCopy = new Node(head.data);
            Node tempCopy = headCopy;
            Node temp = head.next;
            while (temp != null) {
                tempCopy.next = new Node(temp.data);
                temp = temp.next;
                tempCopy = tempCopy.next;
            }
            return new ImmutableLinkedList(headCopy);
        }
    }

    @Override
    public Object get(int index) {
        checkIndexOutOfBounds();
        if (index >= llSize) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(llSize - 1);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(llSize, c);
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[]{e});
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) addAll(llSize, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > llSize) {
            throw new IndexOutOfBoundsException();
        }
        if (c.length == 0) {
            return copy();
        }
        if (isEmpty()) {
            return new ImmutableLinkedList(c);
        }
        ImmutableLinkedList clone = copy();
        Node newHead = clone.head;

        if (index == 0) {
            newHead.data = c[0];
            Node temp = newHead;
            for (int i = 1; i < c.length; i++) {
                temp.next = new Node(c[i]);
                temp = temp.next;
            }
            temp.next = copy().head;
            for (int i = 0; i < llSize; i++) {
                temp = temp.next;
            }
        } else {
            Node temp = newHead;
            int j = 0;
            while (j != index - 1) {
                temp = temp.next;
                j++;
            }
            for (int i = 0; i < c.length; i++) {
                temp.next = new Node(c[i]);
                temp = temp.next;
            }
            if (j < llSize) {
                for (int i = 0; i < llSize - j - 1; i++) {
                    temp.next = new Node(get(j + i + 1));
                    temp = temp.next;
                }
            }
        }
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public ImmutableList add(Object e) {
        return addAll(new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= llSize) {
            throw new IndexOutOfBoundsException();
        }
        checkIndexOutOfBounds();
        ImmutableLinkedList clone = copy();
        Object[] arr = clone.toArray();
        Object[] newArr = new Object[clone.size() - 1];
        int removed = 0;
        for (int i = 0; i < clone.size() - 1; i++) {
            if (i == index) {
                removed++;
            }
            newArr[i] = arr[i + removed];
        }

        return new ImmutableLinkedList(newArr);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(llSize - 1);
    }


    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= llSize) {
            throw new IndexOutOfBoundsException();
        }
        checkIndexOutOfBounds();
        ImmutableLinkedList clone = copy();
        Node newHead = clone.head;
        Node temp = newHead;
        for (int i = 0; i < llSize; i++) {
            if (i == index) {
                temp.data = e;
            }
            temp = temp.next;
        }
        return new ImmutableLinkedList(newHead);
    }

    @Override
    public int size() {
        return llSize;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[llSize];
        for (int i = 0; i < llSize; i++) {
            arr[i] = get(i);
        }
        return arr;
    }

    @Override
    public int indexOf(Object e) {
        Node temp = head;
        for (int i = 0; i < llSize; i++) {
            if (Objects.equals(temp.data, e)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < llSize; i++) {

            sb.append(get(i));
            sb.append(", ");
        }
        if (sb.length() > 2) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("}");
        return sb.toString();
    }
}
