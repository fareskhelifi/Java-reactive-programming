package io.adad.twopatterns.iterator;

import java.util.LinkedList;
import java.util.Queue;

/*
    first-in-first-out structure
 */

public class BreadthFirstSearch<T> implements Iterator {
    private final Vertex<T> startVertex;

    public BreadthFirstSearch(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    @Override
    public void traverse() {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            Vertex<T> currentVertex = queue.poll();
            if(!currentVertex.isVisited()) {
                currentVertex.setVisited(true);
                System.out.println(currentVertex);
                queue.addAll(currentVertex.getNeighbors());
            }
        }
    }
}
