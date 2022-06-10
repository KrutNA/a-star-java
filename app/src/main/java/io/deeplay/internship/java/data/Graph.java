package io.deeplay.internship.java.data;

import io.deeplay.internship.java.error.CoordinateException;

import java.util.List;
import java.util.Objects;

public class Graph<T extends Coordinate<T>, V extends Vertex<T, V>> {
    T size;
    List<V> vertices;

    public Graph(List<V> vertices, T size) {
        this.vertices = vertices;
        this.size = size;
    }
    public T getSize() { return size; }

    public V get(T coordinate) {
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
