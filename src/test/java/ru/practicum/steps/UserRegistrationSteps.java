package ru.practicum.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.constants.URL;
import ru.practicum.pages.RegisterPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class UserRegistrationSteps {
    private WebDriver driver;
    private RegisterPage registerPage;
    private boolean anErrorMessageIsDisplayed;

    public UserRegistrationSteps(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(driver);
    }

    //Метод, описывающий весь путь тестового сценария успешной регистрации
    public void registerUser(String name, String email, String password) {

        //Открываем страницу регистрации пользователя
        driver.get(URL.TEST_STAND_REGISTER);
        registerPage = new RegisterPage(driver);

        //Заполнение полей ввода
        registerPage.setNameFieldRegisterPage(name);
        registerPage.setEmailFieldRegisterPage(email);
        registerPage.setPasswordFieldRegisterPage(password);

        //Клик по кнопке "Зарегистрироваться"
        registerPage.clickRegisterButtonRegisterPage();

        //Ожидание перехода на страницу авторизации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("/login"));
        assertTrue("После успешной регистрации должен быть переход на страницу авторизации", driver
                .getCurrentUrl().endsWith("/login"));
    }

    //Метод, описывающий весь путь тестового сценария проверки появления сообщения об ошибке
    public void checkingMessageDisplayForDifferentPasswordLengths(String password, boolean expectError) {
        //Открываем страницу регистрации пользователя
        driver.get(URL.TEST_STAND_REGISTER);
        registerPage = new RegisterPage(driver);

        //Заполнить поле "Пароль" тестовыми данными
        registerPage.setPasswordFieldRegisterPage(password);

        //Снять фокус с поля "Пароль", кликнув на кнопку "Зарегистрироваться"
        registerPage.clickRegisterButtonRegisterPage();

        //Проверить, что сообщение о некорректном пароле отображается на странице
        if (expectError) {
            registerPage.assertPasswordErrorVisible();
        } else {
            registerPage.assertPasswordErrorNotVisible();
        }
    }
}