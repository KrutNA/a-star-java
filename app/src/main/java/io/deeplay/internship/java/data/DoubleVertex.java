package io.deeplay.internship.java.data;

public class DoubleVertex<C extends Coordinate<C>> implements Vertex<C, DoubleVertex<C>> {
    private final double cost;
    private final C coordinate;

    public DoubleVertex(double cost, C coordinate) {
        this.cost = cost;
        this.coordinate = coordinate;
    }

    @Override
    public Double getCost() { return this.cost; }

    public C getCoordinate() { return this.coordinate; }

    @Override
    public int compareTo(DoubleVertex<C> o) {
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
