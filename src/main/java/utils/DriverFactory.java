package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.HomePage;
import pageobjects.RegistrationPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver driver;
    public static HomePage homePage;
    public static RegistrationPage registrationPage;
    private static final String ENV_PATH = "/src/main/resources/config.properties";

    public WebDriver getDriver() throws IOException {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream =
                    new FileInputStream(System.getProperty("user.dir") + ENV_PATH);
            properties.load(fileInputStream);

            switch (properties.getProperty("browser")) {
                case "chrome":
                    if (null == driver) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        driver.manage().window().maximize();
                    }
                    break;
                case "firefox":
                    if (null == driver) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        driver.manage().window().maximize();
                    }
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert driver != null;
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
            homePage = PageFactory.initElements(driver, HomePage.class);
            registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        }
        return driver;
    }
}
