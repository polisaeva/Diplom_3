package ru.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.constants.URL;

import java.time.Duration;

public class ForgotPasswordPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    //Локатор для кнопки "Войти"
    private By loginButtonForgotPasswordPage = By.xpath(".//a[@class='Auth_link__1fOlj']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Метод для загрузки страницы ForgotPasswordPage
    @Step("Loading ForgotPasswordPage")
    public void loadingForgotPasswordPage() {
        driver.get(URL.TEST_STAND_FORGOT_PASSWORD);
    }

    //Метод для клика по кнопке "Войти"
    @Step("Click on the 'Login' button on the 'Forgot your password?' page")
    public void clickLoginButtonForgotPasswordPage() {
        driver.findElement(loginButtonForgotPasswordPage).click();
    }
}