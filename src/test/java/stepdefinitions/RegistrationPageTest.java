package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RegistrationPageTest extends DriverFactory {

    private static final String REGISTRATION_PAGE_TITLE = "Join now to Play Online " +
            "Casino Games - Free or Cash | MoneyGaming.com";
    public static final String MANDATORY_FIELD = "This field is required";

    @When("^the user enters title, username and password$")
    public void theUserEntersTitleUsernameAndPassword(List<Map<String, String>> dataTable) {
        assertThat(driver.getTitle(), is(equalTo(REGISTRATION_PAGE_TITLE)));
        dataTable.forEach(data -> {
            registrationPage.selectTitle(data.get("Title"));
            registrationPage.enterFirstName(data.get("UserName"));
            registrationPage.enterLastName("PassWord");
        });
    }

    @And("^the user accepts the terms and conditions$")
    public void theUserAcceptsTheTermsAndConditions() {
        registrationPage.clickOnTermsCheckBox();
    }

    @And("^the user clicks the join now button$")
    public void theUserClicksTheJoinNowButton() {
        registrationPage.clickOnJoinNow();
    }

    @Then("^the error message is displayed$")
    public void theErrorMessageIsDisplayed() {
        assertThat(registrationPage.getDobErrorMessage(), is(equalTo(MANDATORY_FIELD)));
    }


}
