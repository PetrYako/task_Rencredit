package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.CardPage;
import pages.ContributionPage;
import pages.HomePage;

public class TestConfig {

    public WebDriver driver;

    public HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();

        homePage = new HomePage(driver);
    }

    @AfterClass
    public void close() {
        driver.quit();
    }
}
