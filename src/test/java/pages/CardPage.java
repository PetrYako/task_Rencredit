package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CardPage {

    private final WebDriver driver;

    @FindBy(className = "order-form")
    private WebElement orderForm;

    private By lastName = By.name("ClientLastName");
    private By firstName = By.name("ClientName");
    private By secondNameCheckBox = By.cssSelector("div[data-ignoreid=\"1\"][class=\"jq-checkbox js-validation-ignore-checkbox\"]");
    private By phoneNumber = By.name("ClientMobilePhone");
    private By email = By.name("AdditionalEmail");
    private By creditRegion = By.name("CreditRegion");

    public CardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void fillLastName(String name) {
        orderForm.findElement(lastName).sendKeys(name);
    }

    public void fillFirstName(String name) {
        orderForm.findElement(firstName).sendKeys(name);
    }

    public void chooseCheckbox() {
        orderForm.findElement(secondNameCheckBox).click();
    }

    public void fillPhoneNumber(String number) {
        orderForm.findElement(phoneNumber).sendKeys(number);
    }

    public void fillEmail(String mail) {
        orderForm.findElement(email).sendKeys(mail);
    }

    public void selectCreditRegion(String region) {
        Select reg = new Select(orderForm.findElement(creditRegion));
        reg.selectByVisibleText(region);
    }
}
