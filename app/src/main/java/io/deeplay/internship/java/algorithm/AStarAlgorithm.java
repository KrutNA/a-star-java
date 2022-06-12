package io.deeplay.internship.java.algorithm;

import io.deeplay.internship.java.data.Coordinate;
import io.deeplay.internship.java.data.Graph;
import io.deeplay.internship.java.data.Vertex;

import java.util.*;

public class AStarAlgorithm implements Algorithm {
    public <C extends Coordinate<C>, V extends Vertex<C, V>> List<C> solve(
            Graph<C, V> graph,
            C from,
            C to
    ) {
        var open = new ArrayList<IndexCost<C>>();
        var closed = new ArrayList<IndexCost<C>>();
        var current = new IndexCost<>(graph.get(from).getCoordinate(), 0.0, null);

        while (!current.coordinate.equals(to)) {
            closed.add(current);
            addAllAdjacent(graph, open, closed, current);
            open.sort(Comparator.comparing(IndexCost::cost));
            if (open.isEmpty()) return null;
            current = open.get(0);
            open.remove(0);
        }

        var path = new ArrayDeque<C>();
        while (current.parent != null) {
            path.addFirst(current.coordinate);
            current = current.parent;
        }

        return new ArrayList<>(path);
    }

    private <C extends Coordinate<C>, V extends Vertex<C, V>> void addAllAdjacent(
            Graph<C, V> graph,
            List<IndexCost<C>> open,
            List<IndexCost<C>> closed,
            IndexCost<C> current
    ) {
        for (var adj : current.coordinate.getAdjacent(graph.getSize())) {
            if (closedContainsAdjacent(closed, adj, graph.getSize())) {
                var vertex = graph.getVertices().get(adj);
                open.add(new IndexCost<C>(
                        vertex.getCoordinate(),
                        current.cost + vertex.getCost().doubleValue(),
                        current)
                );
            }
        }
    }

    private <C extends Coordinate<C>> boolean closedContainsAdjacent(List<IndexCost<C>> closed, Integer adj, C size) {
        return closed.stream().noneMatch(c -> c.coordinate().flattenForSize(size) == adj);
    }

    private record IndexCost<C>(
            C coordinate,
            double cost,
            IndexCost<C> parent
    ) {
    }
}
