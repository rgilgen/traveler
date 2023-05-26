package traveler;

import java.util.List;
import java.util.Objects;

public class Journey {

    private List<City> cities;

    public Journey(List<City> cities) {
        this.cities = cities;
    }

    public int getTotalDistance() {
        int sum = 0;
        for (City city : cities) {
            sum += city.getDistance();
        }
        return sum;
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journey journey = (Journey) o;
        return Objects.equals(cities, journey.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cities);
    }

    @Override
    public String toString() {
        return "Journey{" +
                "cities=" + cities +
                '}';
    }
}
