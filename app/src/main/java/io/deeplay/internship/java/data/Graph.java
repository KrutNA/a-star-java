package io.deeplay.internship.java.data;

import java.util.List;
import java.util.Objects;

public class Graph<C extends Coordinate<C>, V extends Vertex<C, V>> {
    C size;
    List<V> vertices;

    public Graph(List<V> vertices, C size) {
        this.vertices = vertices;
        this.size = size;
    }
    public C getSize() { return size; }

    public V get(C coordinate) {
        return vertices.get(coordinate.flattenForSize(size));
    }

    public List<V> getVertices() { return vertices; }

    public List<V> getAdjacentOf(V vertex) {
        return vertex
                .getCoordinate()
                .getAdjacent(size)
                .stream()
                .map(vertices::get)
                .filter(Objects::nonNull)
                .toList();
    }
}
