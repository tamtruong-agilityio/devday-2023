package steps;

import helpers.Storage;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public static void initialization() {
        Storage.instantiateStorage();
    }
}
