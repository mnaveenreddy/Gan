package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends BasePage {

    public RegistrationPage() {
        super();
    }

    private @FindBy(css = "#title")
    WebElement dropdownButton_title;
    private @FindBy(css = "#forename")
    WebElement textField_firstName;
    private @FindBy(css = "[name='map(lastName)']")
    WebElement textField_lastName;
    private @FindBy(css = "#form")
    WebElement button_joinNow;
    private @FindBy(css = "[name='map(terms)']")
    WebElement chkbx_terms;
    private @FindBy(css = "label[for='dob']")
    WebElement button_dob_errorMessage;


    public RegistrationPage selectTitle(String title) {
        selectDropDownValue(dropdownButton_title, title);
        return new RegistrationPage();
    }

    public RegistrationPage enterFirstName(String firstName) {
        type(textField_firstName, firstName);
        return new RegistrationPage();
    }

    public RegistrationPage enterLastName(String lastName) {
        type(textField_lastName, lastName);
        return new RegistrationPage();
    }

    public RegistrationPage clickOnJoinNow() {
        clickOnElement(button_joinNow);
        return new RegistrationPage();
    }

    public RegistrationPage clickOnTermsCheckBox() {
        jsScrollToView(chkbx_terms);
        jsClick(chkbx_terms);
        return new RegistrationPage();
    }

    public String getDobErrorMessage() {
        return getText(button_dob_errorMessage);
    }
}
