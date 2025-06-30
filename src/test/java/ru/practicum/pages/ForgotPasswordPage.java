package ru.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    //Локатор для кнопки "Войти"
    private By loginButtonForgotPasswordPage = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для клика по кнопке "Войти"
    @Step("Click on the 'Login' button on the 'Forgot your password?' page")
    public void clickLoginButtonForgotPasswordPage() {
        driver.findElement(loginButtonForgotPasswordPage).click();
    }
}