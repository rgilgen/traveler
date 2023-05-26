package traveler;

import traveler.App;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void test_it() {
        App app = new App();

        String greeting = app.getGreeting();
    }
}
