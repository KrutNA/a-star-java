package io.deeplay.internship.java.data;

import java.util.ArrayList;
import java.util.List;

public class TwoDimCoordinate implements Coordinate<TwoDimCoordinate>{
    private final int x, y;

    public TwoDimCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int flattenForSize(TwoDimCoordinate size) {
        return flattenForSize(this.x, this.y, size.x);
    }

    private static int flattenForSize(int x, int y, int width) {
        return y * width + x;
    }

    @Override
    public List<Integer> getAdjacent(TwoDimCoordinate size) {
        var adjacent = new ArrayList<Integer>();
        if (this.x != 0) adjacent.add(flattenForSize(this.x-1, this.y, size.x));
        if (this.y != 0) adjacent.add(flattenForSize(this.x, this.y-1, size.x));
        if (this.x + 1 < size.x) adjacent.add(flattenForSize(this.x+1, this.y, size.x));
        if (this.y + 1 < size.y) adjacent.add(flattenForSize(this.x, this.y+1, size.x));
        return adjacent;
    }

    @Override
    public int compareTo(TwoDimCoordinate o) {
        return this.x < o.x && this.y < o.y ? -1 : 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TwoDimCoordinate o) {
            return this.x == o.x && this.y == o.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("{ %d, %d }", x, y);
    }
}
