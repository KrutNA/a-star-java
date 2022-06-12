package io.deeplay.internship.java.error;

import io.deeplay.internship.java.data.Coordinate;

public class CoordinateException extends SolveException {
    public <C extends Coordinate<C>>CoordinateException(C coordinate, C size) {
        super(String.format("Coordinate %s out of range for graph of size %s.", coordinate, size));
    }

    public <C extends Coordinate<C>>CoordinateException(C coordinate) {
        super(String.format("Vertex on coordinate %s doesn't exists.", coordinate));
    }
}
