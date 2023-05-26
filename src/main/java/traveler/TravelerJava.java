package traveler;

import java.util.List;

public class TravelerJava implements Traveler {
    @Override
    public Journey choose_best_sum(int maxDistance, int cityVisits, List<Integer> listOfCityDistances) {
        boolean isCityInRange = listOfCityDistances.stream().filter(d -> d.intValue() <= maxDistance).count() > 0;
        if (isCityInRange) {
            City city = new City(0, 0);
            for (int i = 0; i < listOfCityDistances.size(); i++) {
                Integer currentDistance = listOfCityDistances.get(i);
                if ((currentDistance <= maxDistance) &&
                        (currentDistance > city.getDistance())) {
                    city = new City(i, currentDistance);
                }
            }
            return new Journey(List.of(city));
        }
        return null;
    }
}
