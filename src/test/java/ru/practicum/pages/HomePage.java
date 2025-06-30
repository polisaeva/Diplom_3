package ru.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    //Локатор для кнопки "Личный кабинет"
    private By personalAccountButton = By.xpath(".//p[@class='AppHeader_header__linkText__3q_va ml-2' " +
            "and text()='Личный Кабинет']");

    //Локатор для кнопки "Войти в аккаунт"
    private By loginToAccountButton = By.xpath(".//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");

    //Локатор для вкладки "Булки
    public By sectionBuns = By.xpath(".//span[@class='text text_type_main-default' and text()='Булки']");

    //Локатор для вкладки "Соусы"
    public By sectionSauces = By.xpath(".//span[@class='text text_type_main-default' and text()='Соусы']");

    //Локатор для вкладки "Начинки"
    public By sectionFillings = By.xpath(".//span[@class='text text_type_main-default' and text()='Начинки']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для клика по кнопке "Войти в аккаунт"
    @Step("Click on the 'Login to your account' button")
    public void clickLoginToAccountButton() {
        driver.findElement(loginToAccountButton).click();
    }

    //Метод для клика по кнопке "Личный кабинет"
    @Step("Click on the 'Personal Account' button")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    //Метод для клика на вкладку "Булки"
    @Step("Click on the 'Buns' tab")
    public void clickSectionBuns() {
        driver.findElement(sectionBuns).click();
    }

    //Метод для клика на вкладку "Соусы"
    @Step("Click on the 'Sauces' tab")
    public void clickSectionSauces() {
        driver.findElement(sectionSauces).click();
    }

    //Метод для клика на вкладку "Начинки"
    @Step("Click on the 'Fillings' tab")
    public void clickSectionFillings() {
        driver.findElement(sectionFillings).click();
    }

    //Метод для проверки, что выбранный раздел становится активным
    @Step("Checking that the selected section becomes active")
    public boolean isSectionActive(String sectionName) {
        By sectionLocator;
        switch (sectionName) {
            case "Булки":
                sectionLocator = sectionBuns;
                break;
            case "Соусы":
                sectionLocator = sectionSauces;
                break;
            case "Начинки":
                sectionLocator = sectionFillings;
                break;
            default:
                throw new IllegalArgumentException("Неизвестный раздел: " + sectionName);
        }
        WebElement sectionElement = driver.findElement(sectionLocator);
        String classes = sectionElement.findElement(By.xpath("./..")).getAttribute("class");
        return classes.contains("tab_tab_type_current__2BEPc");
    }
}