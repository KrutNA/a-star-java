package io.deeplay.internship.java.data;

public interface Vertex<T extends Coordinate<T>, C extends Vertex<T, C>> extends Comparable<C> {
    T getCoordinate();

    Number getCost();
}
