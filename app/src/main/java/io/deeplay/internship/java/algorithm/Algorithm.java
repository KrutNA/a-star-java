package io.deeplay.internship.java.algorithm;

import io.deeplay.internship.java.data.Coordinate;
import io.deeplay.internship.java.data.Graph;
import io.deeplay.internship.java.data.Vertex;
import io.deeplay.internship.java.error.SolveException;

import java.util.List;

public interface Algorithm {
    <T extends Coordinate<T>, C extends Vertex<T, C>> List<T> solve(Graph<T, C> maze, T from, T to);
}
