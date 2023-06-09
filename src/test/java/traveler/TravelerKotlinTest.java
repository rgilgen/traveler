package traveler;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelerKotlinTest {

    Traveler traveler = new TravelerKotlin();

    @Test
    void test_VisitingOneCity_oneIsReturned() {
        List<Integer> listOfCityDistances = List.of(50);
        int cityVisits = 1;
        int maxDistance = 60;
        Journey expectedJourney = new Journey(List.of(new City(0, 50)));

        Journey actualJourney = traveler.choose_best_sum(maxDistance, cityVisits, listOfCityDistances);

        assertEquals(expectedJourney, actualJourney);
    }

    @Test
    void test_VisitingOneCity_nullIsReturned() {
        List<Integer> listOfCityDistances = List.of(50);
        int cityVisits = 1;
        int maxDistance = 30;
        Journey expectedJourney = new Journey(Collections.emptyList());

        Journey actualJourney = traveler.choose_best_sum(maxDistance, cityVisits, listOfCityDistances);

        assertEquals(expectedJourney, actualJourney);
    }

    @Test
    void test_VisitingOneCity_correctOneIsReturned() {
        List<Integer> listOfCityDistances = List.of(50, 100, 30, 20, 40);
        int cityVisits = 1;
        int maxDistance = 30;
        Journey expectedJourney = new Journey(List.of(
                new City(2, 30)
        ));

        Journey actualJourney = traveler.choose_best_sum(maxDistance, cityVisits, listOfCityDistances);

        assertEquals(expectedJourney, actualJourney);
    }

    @Test
    void test_VisitingTwoCities_correctOneIsReturned() {
        List<Integer> listOfCityDistances = List.of(50, 100, 30, 20, 40);
        int cityVisits = 2;
        int maxDistance = 80;
        Journey expectedJourney = new Journey(List.of(
                new City(0, 50),
                new City(2, 30)
        ));

        Journey actualJourney = traveler.choose_best_sum(maxDistance, cityVisits, listOfCityDistances);

        assertEquals(expectedJourney, actualJourney);
    }
}
