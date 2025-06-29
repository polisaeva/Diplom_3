package ru.practicum.pages;

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
    public void clickRegisterButtonRegisterPage() {
        driver.findElement(registerButtonRegisterPage).click();
    }

    //Метод для клика по кнопке "Войти"
    public void clickLoginButtonRegisterPage() {
        driver.findElement(loginButtonRegisterPage).click();
    }

    //Метод для заполнения поля "Имя"
    public void setNameFieldRegisterPage(String name) {
        driver.findElement(nameFieldRegisterPage).sendKeys(name);
    }

    //Метод для заполнения поля "Email"
    public void setEmailFieldRegisterPage(String email) {
        driver.findElement(emailFieldRegisterPage).sendKeys(email);
    }

    //Метод для заполнения поля "Пароль"
    public void setPasswordFieldRegisterPage(String password) {
        driver.findElement(passwordFieldRegisterPage).sendKeys(password);
    }

    //Методы для проверки появления сообщения об ошибке для некорректного пароля
    public void assertPasswordErrorVisible() {
        assertTrue("Сообщение об ошибке пароля должно отображаться", driver.findElement(messageIncorrectPassword).isDisplayed());
    }

    public void assertPasswordErrorNotVisible() {
        List<WebElement> errorMessages = driver.findElements(messageIncorrectPassword);
        if (!errorMessages.isEmpty()) {
            assertFalse("Сообщение об ошибке пароля не должно отображаться",
                    errorMessages.get(0).isDisplayed());
        }
    }
}