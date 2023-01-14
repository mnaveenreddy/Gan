package stepdefinitions;

import cucumber.api.java.en.Given;
import utils.DriverFactory;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HomePageTest extends DriverFactory {

    private static final String HOMEPAGE_TITLE = "Play Online Casino Games Now | " +
            "MoneyGaming.com";

    @Given("^a web browser is at the money gaming home page$")
    public void aWebBrowserIsAtTheMoneyGamingHomePage() throws IOException {
        assertThat(getDriver().getTitle(), is(equalTo(HOMEPAGE_TITLE)));
    }

    @Given("^the user navigates to the registration page$")
    public void theUserNavigatesToTheRegistrationPage() {
        homePage.clickOnJoinNow();
    }


}
