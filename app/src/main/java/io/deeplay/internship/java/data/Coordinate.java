package io.deeplay.internship.java.data;

import java.util.List;

public interface Coordinate<C extends Coordinate<C>> extends Comparable<C> {
    int flattenForSize(C size);
    List<Integer> getAdjacent(C size);
}
