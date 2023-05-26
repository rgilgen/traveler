package traveler;

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

}
