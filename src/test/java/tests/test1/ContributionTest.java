package tests.test1;

import config.TestConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContributionPage;


@Test(testName = "Тестирование вкладки \"Вклад\"")
public class ContributionTest extends TestConfig {

    public ContributionPage contributionPage;

    @BeforeClass
    public void beforeClass() {
        contributionPage = new ContributionPage(driver);
    }

    @Test(description = "Открыть сайт rencredit.ru")
    public void openHomePage() {
        homePage.open();
    }

    @Test(dependsOnMethods = {"openHomePage"}, description = "Перейти на страницу \"Вклад\"")
    public void redirectToContributions() {
        homePage.goToContributions();
    }

    @Test(dependsOnMethods = {"redirectToContributions"}, description = "Поменять чекбокс \"Открытие вклада\"")
    public void changeDepositCheckbox() {
        contributionPage.changeDepositCheckbox();
    }

    @Test(dependsOnMethods = {"changeDepositCheckbox"}, description = "Ввести сумму вклада")
    public void changeAmountOfDeposit() {
        contributionPage.fillAmount("1 000 000");
    }

    @Test(dependsOnMethods = {"changeAmountOfDeposit"}, description = "Передвинуть ползунок \"На срок\"")
    public void changePeriodSlider() {
        contributionPage.changePeriodSlider();
    }

    @Test(dependsOnMethods = {"changePeriodSlider"}, description = "Выгрузить Печатную Форму \"Общие условия по вкладам\"")
    public void getTermsDocument() {
        contributionPage.getTermsDocument();
    }
}
