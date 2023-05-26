package traveler;

import java.util.Objects;

public class City {

    private int index;
    private int distance;

    private City() {

    }

    public City(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return index == city.index && distance == city.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, distance);
    }

    @Override
    public String toString() {
        return "City{" +
                "index=" + index +
                ", distance=" + distance +
                '}';
    }
}
