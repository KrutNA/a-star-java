package io.deeplay.internship.java.algorithm;

import io.deeplay.internship.java.data.Coordinate;
import io.deeplay.internship.java.data.Graph;
import io.deeplay.internship.java.data.Vertex;
import io.deeplay.internship.java.error.SolveException;

import java.util.*;
import java.util.function.Predicate;

public class AStarAlgorithm implements Algorithm {
    public <T extends Coordinate<T>, V extends Vertex<T, V>> List<T> solve(
            Graph<T, V> graph,
            T from,
            T to
    ) {
        var open = new ArrayList<IndexCost<T>>();
        var closed = new ArrayList<IndexCost<T>>();
        var current = new IndexCost<>(graph.get(from).getCoordinate(), 0.0, null);

        while (!current.coordinate.equals(to)) {
            closed.add(current);
            addAllAdjacent(graph, open, closed, current);
            open.sort(Comparator.comparing(IndexCost::cost));
            if (open.isEmpty()) return null;
            current = open.get(0);
            open.remove(0);
        }

        var path = new ArrayDeque<T>();
        while (current.parent != null) {
            path.addFirst(current.coordinate);
            current = current.parent;
        }

        return new ArrayList<>(path);
    }

    private <T extends Coordinate<T>, V extends Vertex<T, V>> void addAllAdjacent(
            Graph<T, V> graph,
            List<IndexCost<T>> open,
            List<IndexCost<T>> closed,
            IndexCost<T> current
    ) {
        for (var adj : current.coordinate.getAdjacent(graph.getSize())) {
            if (closedContainsAdjacent(closed, adj, graph.getSize())) {
                var vertex = graph.getVertices().get(adj);
                open.add(new IndexCost<T>(
                        vertex.getCoordinate(),
                        current.cost + vertex.getCost().doubleValue(),
                        current)
                );
            }
        }
    }

    private <T extends Coordinate<T>> boolean closedContainsAdjacent(List<IndexCost<T>> closed, Integer adj, T size) {
        return closed.stream().noneMatch(c -> c.coordinate().flattenForSize(size) == adj);
    }

    private record IndexCost<T>(
            T coordinate,
            double cost,
            IndexCost<T> parent
    ) {
    }
}
