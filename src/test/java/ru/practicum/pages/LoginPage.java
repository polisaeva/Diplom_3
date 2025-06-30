package ru.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Локатор для кнопки "Зарегистрироваться"
    private By registerButtonLoginPage = By.xpath(".//a[@class='Auth_link__1fOlj' and " +
            "text()='Зарегистрироваться']");

    //Локатор для кнопки "Восстановить пароль"
    private By recoverPasswordButton = By.xpath(".//a[@class='Auth_link__1fOlj' and " +
            "text()='Восстановить пароль']");

    //Локатор для кнопки "Войти"
    private By loginButtonLoginPage = By.xpath(".//button[@class='button_button__33qZ0 " +
            "button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    //Локатор для поля "Email"
    private By emailFieldLoginPage = By.xpath(".//input[@class='text input__textfield " +
            "text_type_main-default' and @name='name']");

    //Локатор для поля "Пароль"
    private  By passwordFieldLoginPage = By.xpath(".//input[@class='text input__textfield " +
            "text_type_main-default' and @name='Пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для клика по кнопке "Зарегистрироваться"
    @Step("Click on the 'Register' button")
    public void clickRegisterButtonLoginPage() {
        driver.findElement(registerButtonLoginPage).click();
    }

    //Метод для клика по кнопке "Восстановить пароль"
    @Step("Click on the 'Recover Password' button")
    public void clickRecoverPasswordButtonLoginPage() {
        driver.findElement(recoverPasswordButton).click();
    }

    //Метод для клика по кнопке "Войти"
    @Step("Click on the 'Login' button")
    public void clickLoginButtonLoginPage() {
        driver.findElement(loginButtonLoginPage).click();
    }

    //Метод для заполнения поля "Email"
    @Step("Filling in the 'Email' field")
    public void setEmailFieldLoginPage(String email) {
        driver.findElement(emailFieldLoginPage).sendKeys(email);
    }

    //Метод для заполнения поля "Пароль"
    @Step("Filling in the 'Password' field")
    public void setPasswordFieldLoginPage(String password) {
        driver.findElement(passwordFieldLoginPage).sendKeys(password);
    }
}