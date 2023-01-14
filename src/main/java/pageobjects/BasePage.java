package pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverFactory;

@Slf4j
public class BasePage extends DriverFactory {

    protected WebDriverWait wait;
    protected JavascriptExecutor jsExecutor;

    public BasePage() {
        this.wait = new WebDriverWait(driver, 15);
        jsExecutor = ((JavascriptExecutor) driver);
    }

    public void clickOnElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
            LOG.info("Successfully clicked on the WebElement: " + "<" + element.toString() + ">");
        } catch (Exception exception) {
            LOG.info("Unable to wait and click on WebElement, Exception: " + exception.getMessage());

        }
    }

    public void type(WebElement element, String textToSend) {
        try {
            this.WaitUntilWebElementIsVisible(element);
            element.clear();
            element.sendKeys(textToSend);
            LOG.info("Successfully Sent the following keys: '" + textToSend + "' to " +
                    "element: " + "<" + element.toString() + ">");
        } catch (Exception exception) {
            LOG.info("Unable to send the keys to WebElement: " + "<" + exception.getMessage());

        }
    }

    public void WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            LOG.info("WebElement is visible using locator: " + "<" + element.toString() + ">");
        } catch (Exception exception) {
            LOG.info("WebElement is NOT visible, using locator: " + "<" + exception.getMessage() +
                    ">");
        }
    }

    protected void selectDropDownValue(WebElement webelement, String title) {
        try {
            this.WaitUntilWebElementIsVisible(webelement);
            LOG.info("WebElement is visible using locator: " + "<" + webelement.toString() + ">");
            new Select(webelement).selectByVisibleText(title);
        } catch (Exception exception) {
            LOG.info("WebElement is NOT visible, using locator: " + "<" + exception.getMessage() +
                    ">");
        }
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void jsScrollToView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView" +
                "(true);", element);
    }

    protected String getText(WebElement webElement) {
        this.WaitUntilWebElementIsVisible(webElement);
        return webElement.getText();
    }



}
