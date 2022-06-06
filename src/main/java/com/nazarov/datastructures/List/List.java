package com.nazarov.datastructures.List;

public interface List<T> {

    void add(T element);

    void add(int index, T element);

    T get(int index);

    T remove(int index);

    T set(int index, T element);

    void clear();

    int size();

    boolean isEmpty();

    T getFirst();

    T getLast();

    int indexOf(T value);

    int lastIndexOf(T element);

    String toString();

    boolean contains(T element);
}
