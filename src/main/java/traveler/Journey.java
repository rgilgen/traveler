package traveler;

import java.util.List;

public class Journey {

    private List<City> cities;

    public Journey(List<City> cities) {
        this.cities = cities;
    }

    public int getTotalDistance() {
        return 1;
    }

    public List<City> getCities() {
        return cities;
    }
}
