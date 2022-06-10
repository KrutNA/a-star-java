package io.deeplay.internship.java.solve;

import io.deeplay.internship.java.algorithm.AStarAlgorithm;
import io.deeplay.internship.java.algorithm.Algorithm;
import io.deeplay.internship.java.data.DoubleVertex;
import io.deeplay.internship.java.data.Graph;
import io.deeplay.internship.java.data.TwoDimCoordinate;
import io.deeplay.internship.java.data.Vertex;
import io.deeplay.internship.java.parser.data.CostInput;
import io.deeplay.internship.java.parser.Parser;
import io.deeplay.internship.java.parser.data.DefaultInputConfig;

import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    private static final String DEFAULT_COSTS_RESOURCE_PATH = "costs.json";
    private static final String DEFAULT_INPUT_RESOURCE_PATH = "input.json";
    private static final CostInput costs;
    private static final DefaultInputConfig defaultInputConfig;
    private static final Algorithm algorithm = new AStarAlgorithm();

    static {
        try (var isc = Solution.class.getClassLoader().getResourceAsStream(DEFAULT_COSTS_RESOURCE_PATH);
             var isi = Solution.class.getClassLoader().getResourceAsStream(DEFAULT_INPUT_RESOURCE_PATH)) {
            costs = Parser.processInputStream(isc, CostInput.class);
            defaultInputConfig = Parser.processInputStream(isi, DefaultInputConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getResult(String field, String character) {
        var size = new TwoDimCoordinate(defaultInputConfig.width(), defaultInputConfig.height());
        var vertices = new ArrayList<DoubleVertex<TwoDimCoordinate>>();
        var characterCosts = costs.data().get(character);
        if (characterCosts == null)
            throw new IllegalArgumentException(String.format("Unknown character %s", character));
        var fields = field.toCharArray();
        for (var i = 0; i < defaultInputConfig.height(); ++i) {
            for (var j = 0; j < defaultInputConfig.width(); ++j) {
                vertices.add(new DoubleVertex<TwoDimCoordinate>(
                        characterCosts.get(fields[i * 4 + j]).doubleValue(),
                        new TwoDimCoordinate(i, j))
                );
            }
        }
        var graph = new Graph<>(vertices, size);
        var from = new TwoDimCoordinate(0, 0);
        var to = new TwoDimCoordinate(defaultInputConfig.width() - 1, defaultInputConfig.height() - 1);
        var path = algorithm.solve(graph, from, to);

        return path.stream().skip(1).map(graph::get)
                .map(Vertex::getCost)
                .mapToInt(Number::intValue)
                .sum();
    }
}
