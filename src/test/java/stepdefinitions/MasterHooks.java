package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import utils.DriverFactory;

import java.io.IOException;

import static utils.TestBase.getProperty;

@Slf4j
public class MasterHooks extends DriverFactory {
    @Before
    public void setup() throws IOException {
        driver = getDriver();
        driver.get(getProperty("baseUrl"));
    }

    @After
    public void quit() {
        // I didn't closed the browser intentionally
        //	driver.quit();
    }
}
