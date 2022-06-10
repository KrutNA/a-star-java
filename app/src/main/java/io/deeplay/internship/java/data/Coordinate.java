package io.deeplay.internship.java.data;

import java.util.List;

public interface Coordinate<T extends Coordinate<T>> extends Comparable<T> {
    int flattenForSize(T size);
    List<Integer> getAdjacent(T size);
}
