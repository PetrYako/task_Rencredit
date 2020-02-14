package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(className = "services_main")
    private WebElement mainServices;

    private By cardsButton = By.cssSelector("[href=\"/app/card/cc_full\"]");

    private By contributionsButton = By.cssSelector("[href=\"/contributions/\"]");

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open() {
        driver.get("https://rencredit.ru/");
    }

    public void goToCard() {
        mainServices.findElement(cardsButton).click();
    }

    public void goToContributions() {
        mainServices.findElement(contributionsButton).click();
    }
}
