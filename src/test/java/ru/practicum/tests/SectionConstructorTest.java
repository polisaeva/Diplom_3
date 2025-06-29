package ru.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.steps.SectionSteps;
import ru.practicum.utils.BrowserManager;


public class SectionConstructorTest {

    private WebDriver driver;
    private SectionSteps sectionSteps;


    @Test
    @DisplayName("Buns Section Be Active By Default In Google Chrome")
    @Description("When you open the Stellar Burger page, the Buns section is active by default In Google Chrome")
    public void shouldBunsSectionBeActiveByDefaultInGoogleCromeTest() {
        driver = BrowserManager.createBrowser("chrome");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldBunsSectionBeActiveByDefault();
    }

    @Test
    @DisplayName("Buns Section Become Active When Clicked In Google Chrome")
    @Description("The 'Buns' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder in the Google Chrome browser")
    public void bunsSectionBecomeActiveWhenClickedInGoogleChromeTest() {
        driver = BrowserManager.createBrowser("chrome");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldBunsSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Sauces Section Become Active When Clicked In Google Chrome")
    @Description("The 'Sauces' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder in the Google Chrome browser")
    public void saucesSectionBecomeActiveWhenClickedInGoogleChromeTest() {
        driver = BrowserManager.createBrowser("chrome");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldSaucesSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Fillings Section Become Active When Clicked In Google Chrome")
    @Description("The 'Fillings' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder in the Google Chrome browser")
    public void fillingsSectionBecomeActiveWhenClickedInGoogleChromeTest() {
        driver = BrowserManager.createBrowser("chrome");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldFillingsSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Buns Section Be Active By Default In Yandex Browser")
    @Description("When you open the Stellar Burger page, the Buns section is active by default In Yandex Browser")
    public void shouldBunsSectionBeActiveByDefaultInYandexBrowserTest() {
        driver = BrowserManager.createBrowser("yandex");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldBunsSectionBeActiveByDefault();
    }

    @Test
    @DisplayName("Buns Section Become Active When Clicked In Yandex Browser")
    @Description("The 'Buns' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder in Yandex Browser")
    public void bunsSectionBecomeActiveWhenClickedInYandexBrowserTest() {
        driver = BrowserManager.createBrowser("yandex");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldBunsSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Sauces Section Become Active When Clicked In Yandex Browser")
    @Description("The 'Sauces' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder in Yandex Browser")
    public void saucesSectionBecomeActiveWhenClickedInYandexBrowserTest() {
        driver = BrowserManager.createBrowser("yandex");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldSaucesSectionBecomeActiveWhenClicked();
    }

    @Test
    @DisplayName("Fillings Section Become Active When Clicked In Yandex Browser")
    @Description("The 'Fillings' section becomes active when switching between sections in the 'Stellar Burger' " +
            "website builder in Yandex Browser")
    public void fillingsSectionBecomeActiveWhenClickedInYandexBrowserTest() {
        driver = BrowserManager.createBrowser("yandex");
        sectionSteps = new SectionSteps(driver);
        sectionSteps.shouldFillingsSectionBecomeActiveWhenClicked();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}