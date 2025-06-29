package ru.practicum.steps;

import org.openqa.selenium.WebDriver;
import ru.practicum.constants.URL;
import ru.practicum.pages.HomePage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SectionSteps {

    private WebDriver driver;
    HomePage homePage;

    public SectionSteps(WebDriver driver) {
        this.driver = driver;
    }

    //Метод, описывающий весь путь тестового сценария проверки, что раздел "Булки" активен по умолчанию
    public void shouldBunsSectionBeActiveByDefault() {
        //Открываем страницу Stellar Burger
        driver.get(URL.TEST_STAND_HOME_PAGE);
        homePage = new HomePage(driver);

        //Проверить, что раздел "Булки" активен по умолчанию
        assertTrue("Раздел 'Булки' должен быть активен по умолчанию",
                homePage.isSectionActive("Булки"));
    }

    //Методы, описывающий весь путь тестового сценария проверки, что раздел "Булки" становится активным после клика
    public void shouldBunsSectionBecomeActiveWhenClicked() {
        //Открываем страницу Stellar Burger
        driver.get(URL.TEST_STAND_HOME_PAGE);
        homePage = new HomePage(driver);

        //Клик на раздел "Соусы"
        homePage.clickSectionSauces();

        //Клик на раздел "Булки"
        homePage.clickSectionBuns();

        //Проверить активность раздела "Булки"
        assertTrue("Раздел 'Булки' должен стать активным после клика",
                homePage.isSectionActive("Булки"));

        //Проверить, что разделы "Начинки" и "Соусы" не активны
        assertFalse("Раздел 'Начинки' должен стать неактивным",
                homePage.isSectionActive("Начинки"));
        assertFalse("Раздел 'Соусы' должен стать неактивным",
                homePage.isSectionActive("Соусы"));
    }

    //Метод, описывающий весь путь тестового сценария проверки, что раздел "Соусы" становится активным после клика
    public void shouldSaucesSectionBecomeActiveWhenClicked() {
        //Открываем страницу Stellar Burger
        driver.get(URL.TEST_STAND_HOME_PAGE);
        homePage = new HomePage(driver);

        //Клик на раздел "Соусы"
        homePage.clickSectionSauces();

        //Проверить активность раздела "Соусы"
        assertTrue("Раздел 'Соусы' должен стать активным после клика",
                homePage.isSectionActive("Соусы"));

        //Проверить, что разделы "Булки" и "Начинки" не активны
        assertFalse("Раздел 'Булки' должен стать неактивным",
                homePage.isSectionActive("Булки"));
        assertFalse("Раздел 'Начинки' должен стать неактивным",
                homePage.isSectionActive("Начинки"));
    }

    //Метод, описывающий весь путь тестового сценария проверки, что раздел "Начинки" становится активным после клика
    public void shouldFillingsSectionBecomeActiveWhenClicked() {
        //Открываем страницу Stellar Burger
        driver.get(URL.TEST_STAND_HOME_PAGE);
        homePage = new HomePage(driver);

        // Клик на раздел "Начинки"
        homePage.clickSectionFillings();

        //Проверить активность раздела "Начинки"
        assertTrue("Раздел 'Начинки' должен стать активным после клика",
                homePage.isSectionActive("Начинки"));

        //Проверить, что разделы "Булки" и "Соусы" не активны
        assertFalse("Раздел 'Булки' должен стать неактивным",
                homePage.isSectionActive("Булки"));
        assertFalse("Раздел 'Соусы' должен стать неактивным",
                homePage.isSectionActive("Соусы"));
    }
}