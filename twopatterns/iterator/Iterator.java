package io.adad.twopatterns.iterator;

/*
    Iterator
        - behavioral Design Pattern
    - extracts the traversal behavior of a collection into a separate object called an iterator
        -> traverses the elements of a collection without exposing its underlying representation
        -> encapsulates all the traversal details
            => several iterators can go through the same collection at the same time
 */

public interface Iterator {
    void traverse();
}
