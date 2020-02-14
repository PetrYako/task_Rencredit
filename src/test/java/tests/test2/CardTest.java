package tests.test2;

import config.TestConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CardPage;
import pages.HomePage;

@Test(testName = "Тестирование вкладки \"Карта\"")
public class CardTest extends TestConfig {

    public CardPage cardPage;

    @BeforeClass
    public void beforeClass() {
        cardPage = new CardPage(driver);
    }

    @Test(description = "Открыть сайт rencredit.ru")
    public void openHomePage() {
        homePage.open();
    }

    @Test(dependsOnMethods = {"openHomePage"}, description = "Перейти на страницу \"Карта\"")
    public void goToCard() {
        homePage.goToCard();
    }

    @Test(dependsOnMethods = {"goToCard"}, description = "Ввести в поля \"Фамилия\", \"Имя\", \"Мобильный телефон\"" +
                                                            ", \"e-mail\" значения")
    public void fill_firstName_phoneNumber_email() {
        cardPage.fillFirstName("Иванов");
        cardPage.fillLastName("Иван");
        cardPage.fillPhoneNumber("8999111111");
        cardPage.fillEmail("andrey@mail.ru");
    }

    @Test(dependsOnMethods = {"fill_firstName_phoneNumber_email"}, description = "Выбрать чекбокс \"Нет отчества\"")
    public void chooseSecondNameCheckBox() {
       cardPage.chooseCheckbox();
    }

    @Test(dependsOnMethods = {"chooseSecondNameCheckBox"}, description = "Выбрать значение из выпадающего списка" +
                                                                        "\"Где вы желаете получить карту\"")
    public void selectCreditRegion() {
        cardPage.selectCreditRegion("Московская область");
    }
}
