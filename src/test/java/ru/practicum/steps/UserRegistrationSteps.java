package ru.practicum.steps;

import org.openqa.selenium.WebDriver;
import ru.practicum.model.User;
import ru.practicum.pages.LoginPage;
import ru.practicum.pages.RegisterPage;


import static org.junit.Assert.assertTrue;

public class UserRegistrationSteps {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    public UserRegistrationSteps(WebDriver driver) {
        this.driver = driver;
        this.registerPage = new RegisterPage(driver);
    }

    //Метод, описывающий весь путь тестового сценария успешной регистрации
    public void registerUser(User user) {

        //Открываем страницу регистрации пользователя
        registerPage = new RegisterPage(driver);
        registerPage.loadingRegisterPage();

        //Заполнение полей ввода
        registerPage.setNameFieldRegisterPage(user.getName());
        registerPage.setEmailFieldRegisterPage(user.getEmail());
        registerPage.setPasswordFieldRegisterPage(user.getPassword());

        //Клик по кнопке "Зарегистрироваться"
        registerPage.clickRegisterButtonRegisterPage();

        //Ожидание перехода на страницу авторизации
        loginPage = new LoginPage(driver);
        loginPage.waitingForLoginPageToLoad();
        assertTrue("После успешной регистрации должен быть переход на страницу авторизации",
                loginPage.currentURLMatchesTheLoginPageAddress());
    }

    //Метод, описывающий весь путь тестового сценария проверки появления сообщения об ошибке
    public void checkingMessageDisplayForDifferentPasswordLengths(String password, boolean expectError) {
        //Открываем страницу регистрации пользователя
        registerPage = new RegisterPage(driver);
        registerPage.loadingRegisterPage();

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