package io.deeplay.internship.java.data;

public class DoubleVertex<T extends Coordinate<T>> implements Vertex<T, DoubleVertex<T>> {
    private final double cost;
    private final T coordinate;

    public DoubleVertex(double cost, T coordinate) {
        this.cost = cost;
        this.coordinate = coordinate;
    }

    @Override
    public Double getCost() { return this.cost; }

    public T getCoordinate() { return this.coordinate; }

    @Override
    public int compareTo(DoubleVertex<T> o) {
        var diff = this.cost - o.cost;
        if (Math.abs(diff) < 1e-6) return 0;
        if (diff < 0) return -1;
        return 1;
    }

    @Override
    public String toString() {
        return String.format("{ %f, %s }", cost, coordinate);
    }
}
