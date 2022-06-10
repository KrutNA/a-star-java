package io.deeplay.internship.java;

import io.deeplay.internship.java.data.*;
import io.deeplay.internship.java.parser.data.CostInput;

import java.util.ArrayList;

public class GraphConverterFromInput {
    public static Graph<TwoDimCoordinate, DoubleVertex<TwoDimCoordinate>> parse(
            CostInput costs,
            String map,
            String character
    ) {
        var size = new TwoDimCoordinate(4, 4);
        var vertices = new ArrayList<DoubleVertex<TwoDimCoordinate>>();
        var characterCosts = costs.data().get(character);
        var fields = map.toCharArray();
        for (var i = 0; i < 4; ++i) {
            for (var j = 0; j < 4; ++j) {
                vertices.add(new DoubleVertex<TwoDimCoordinate>(
                        characterCosts.get(fields[i * 4 + j]).doubleValue(),
                        new TwoDimCoordinate(i, j))
                );
            }
        }

        return new Graph<>(vertices, size);
    }
}
