package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContributionPage {

    private final WebDriver driver;

    @FindBy(className = "calculator__content")
    private WebElement calculatorContent;

    @FindBy(className = "deposits-terms")
    private WebElement depositsTerms;

    private By depositUncheckedCheckbox = By.cssSelector("div[class=\"jq-checkbox calculator__check\"]:not(.checked)");
    private By documentForDownload = By.cssSelector("a[class=\"document__title-link\"]");

    public ContributionPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void getTermsDocument() {
        depositsTerms.findElement(documentForDownload).click();
    }

    public void fillAmount(String amount) {
        calculatorContent.findElement(By.name("amount")).sendKeys(amount);
    }

    public void changePeriodSlider() {
        WebElement slider = calculatorContent.findElement(By.cssSelector("div[data-property=\"period\"]"))
                .findElement(By.className("ui-slider-range"));

        Actions move = new Actions(driver);
        Action action = move.dragAndDropBy(slider, 0, 0).build();
        action.perform();
    }

    public void changeDepositCheckbox() {
        calculatorContent.findElement(depositUncheckedCheckbox).click();
    }
}
