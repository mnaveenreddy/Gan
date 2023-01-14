package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    public @FindBy(css = ".newUser")
    WebElement button_joinNow;

    public void clickOnJoinNow() {
        clickOnElement(button_joinNow);
    }

}
