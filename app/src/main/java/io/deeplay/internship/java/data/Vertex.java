package io.deeplay.internship.java.data;

public interface Vertex<C extends Coordinate<C>, V extends Vertex<C, V>> extends Comparable<V> {
    C getCoordinate();

    Number getCost();
}
