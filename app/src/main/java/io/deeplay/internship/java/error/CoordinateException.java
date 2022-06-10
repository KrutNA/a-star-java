package io.deeplay.internship.java.error;

import io.deeplay.internship.java.data.Coordinate;

public class CoordinateException extends SolveException {
    public <T extends Coordinate<T>>CoordinateException(T coordinate, T size) {
        super(String.format("Coordinate %s out of range for graph of size %s.", coordinate, size));
    }

    public <T extends Coordinate<T>>CoordinateException(T coordinate) {
        super(String.format("Vertex on coordinate %s doesn't exists.", coordinate));
    }
}
