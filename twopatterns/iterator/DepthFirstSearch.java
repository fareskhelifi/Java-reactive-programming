package io.adad.twopatterns.iterator;

/*
    last-in-first-out structure
 */

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch<T> implements Iterator {
    private final Vertex<T> startVertex;

    public DepthFirstSearch(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    @Override
    public void traverse() {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            Vertex<T> currentVertex = stack.pop();
            if (!currentVertex.isVisited()) {
                currentVertex.setVisited(true);
                System.out.println(currentVertex);
                Collections.reverse(currentVertex.getNeighbors());
                currentVertex.getNeighbors().forEach(stack::push);
            }
        }
    }

    public void traverseRecursively(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbors().forEach(neighbor -> {
            if (!neighbor.isVisited()) {
                traverseRecursively(neighbor);
            }
        });
    }

    public void traverseRecursivelyStream(Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        vertex.getNeighbors().stream()
                .filter(neighbor -> !neighbor.isVisited())
                .forEach(this::traverseRecursively);
    }
}
