package ru.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisterPage {
    private WebDriver driver;

    //Локатор для кнопки "Зарегистрироваться"
    private By registerButtonRegisterPage = By.xpath(".//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //Локатор для кнопки "Войти"
    private By loginButtonRegisterPage = By.xpath(".//a[@class='Auth_link__1fOlj']");

    //Локатор для поля "Имя"
    private By nameFieldRegisterPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    //Локатор для поля "Email"
    private By emailFieldRegisterPage = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    //Локатор для поля "Пароль"
    private  By passwordFieldRegisterPage = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='Пароль']");

    //Локатор для сообщения об ошибке для некорректного пароля
    private By messageIncorrectPassword = By.xpath(".//p[@class='input__error text_type_main-default']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для клика по кнопке "Зарегистрироваться"
    @Step("Click on the 'Register' button")
    public void clickRegisterButtonRegisterPage() {
        driver.findElement(registerButtonRegisterPage).click();
    }

    //Метод для клика по кнопке "Войти"
    @Step("Click on the 'Login' button")
    public void clickLoginButtonRegisterPage() {
        driver.findElement(loginButtonRegisterPage).click();
    }

    //Метод для заполнения поля "Имя"
    @Step("Filling in the 'Name' field")
    public void setNameFieldRegisterPage(String name) {
        driver.findElement(nameFieldRegisterPage).sendKeys(name);
    }

    //Метод для заполнения поля "Email"
    @Step("Filling in the 'Email' field")
    public void setEmailFieldRegisterPage(String email) {
        driver.findElement(emailFieldRegisterPage).sendKeys(email);
    }

    //Метод для заполнения поля "Пароль"
    @Step("Filling in the 'Password' field")
    public void setPasswordFieldRegisterPage(String password) {
        driver.findElement(passwordFieldRegisterPage).sendKeys(password);
    }

    //Методы для проверки появления сообщения об ошибке для некорректного пароля
    @Step("Check if an error message appears for an incorrect password")
    public void assertPasswordErrorVisible() {
        assertTrue("Сообщение об ошибке пароля должно отображаться", driver.findElement(messageIncorrectPassword).isDisplayed());
    }

    @Step("Checking for an error message for an incorrect password")
    public void assertPasswordErrorNotVisible() {
        List<WebElement> errorMessages = driver.findElements(messageIncorrectPassword);
        if (!errorMessages.isEmpty()) {
            assertFalse("Сообщение об ошибке пароля не должно отображаться",
                    errorMessages.get(0).isDisplayed());
        }
    }
}