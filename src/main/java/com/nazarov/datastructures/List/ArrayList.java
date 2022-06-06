package com.nazarov.datastructures.List;

import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROW_COEFFICIENT = 1.5;
    private int size;
    private Object[] arrayCore;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Index can`t be between 0 or less!");
        }
        arrayCore = new Object[DEFAULT_CAPACITY];
    }

    private void growIfNeeded() {
        if (arrayCore.length == size) {
            Object[] newArray = new Object[(int) (arrayCore.length * GROW_COEFFICIENT)];
            System.arraycopy(arrayCore, 0, newArray, 0, size);
            arrayCore = newArray;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 && index > size) {
            throw new IndexOutOfBoundsException("Index should be between 0 and " + size);
        }
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void add(int index, T element) {
        validateIndex(index);
        growIfNeeded();
        System.arraycopy(arrayCore, index, arrayCore, index + 1, size - index);
        arrayCore[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return (T) arrayCore[index];
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T removed = (T) arrayCore[index];
        System.arraycopy(arrayCore, index + 1, arrayCore, index, size - index - 1);
        size--;
        return removed;
    }

    @Override
    public T set(int index, T element) {
        validateIndex(index);
        T setted = (T) (arrayCore[index] = element);
        return setted;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(T element) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (arrayCore[i].equals(element)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(T element) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (arrayCore[i].equals(element)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public T getFirst() {
        return get(0);
    }

    @Override
    public T getLast() {
        return get(size - 1);
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(arrayCore[i].toString());
        }
        return stringJoiner.toString();
    }
}
