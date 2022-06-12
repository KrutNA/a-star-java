package io.deeplay.internship.java.algorithm;

import io.deeplay.internship.java.data.Coordinate;
import io.deeplay.internship.java.data.Graph;
import io.deeplay.internship.java.data.Vertex;

import java.util.List;

public interface Algorithm {
    <C extends Coordinate<C>, V extends Vertex<C, V>> List<C> solve(Graph<C, V> maze, C from, C to);
}
