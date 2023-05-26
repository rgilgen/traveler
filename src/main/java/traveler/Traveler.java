package traveler;

import java.util.List;

public interface Traveler {
    Journey choose_best_sum(int maxDistance, int cityVisits, List<Integer> listOfCityDistances);
}
