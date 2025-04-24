package io.adad.twopatterns.iterator;

import java.util.Arrays;

public class TestGraphs {
    public static void main(String[] args) {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);

        v0.setNeighbors(Arrays.asList(v1, v2, v3));
        v2.setNeighbors(Arrays.asList(v4));

//        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(v0);
//        bfs.traverse();

        DepthFirstSearch dfs = new DepthFirstSearch(v0);
        dfs.traverse();
    }
}
