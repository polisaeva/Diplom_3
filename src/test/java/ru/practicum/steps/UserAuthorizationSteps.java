package ru.practicum.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.constants.URL;
import ru.practicum.model.User;
import ru.practicum.pages.ForgotPasswordPage;
import ru.practicum.pages.HomePage;
import ru.practicum.pages.LoginPage;
import ru.practicum.pages.RegisterPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class UserAuthorizationSteps {

    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;

    public UserAuthorizationSteps(WebDriver driver) {
        this.driver = driver;
    }


    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку "Войти в аккаунт"
    public void logInUsingTheLogInToAccountButton(User user) {
        //Открываем страницу Stellar Burger
        driver.get(URL.TEST_STAND_HOME_PAGE);
        homePage = new HomePage(driver);

        //Клик по кнопке "Войти в аккаунт"
        homePage.clickLoginToAccountButton();

        // Ожидание перехода на страницу авторизации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);
        //Заполнение полей ввода
        String validEmail = user.getEmail();
        String validPassword = user.getPassword();
        loginPage.setEmailFieldLoginPage(validEmail);
        loginPage.setPasswordFieldLoginPage(validPassword);

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        wait.until(ExpectedConditions.urlToBe(URL.TEST_STAND_HOME_PAGE));

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                driver.getCurrentUrl().equals(URL.TEST_STAND_HOME_PAGE));
    }

    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку "Личный кабинет"
    public void logInUsingThePersonalAccountButton(User user) {
        //Открываем страницу Stellar Burger
        driver.get(URL.TEST_STAND_HOME_PAGE);
        homePage = new HomePage(driver);

        //Клик по кнопке "Личный кабинет"
        homePage.clickPersonalAccountButton();

        // Ожидание перехода на страницу авторизации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);
        //Заполнение полей ввода
        String validEmail = user.getEmail();
        String validPassword = user.getPassword();
        loginPage.setEmailFieldLoginPage(validEmail);
        loginPage.setPasswordFieldLoginPage(validPassword);

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        wait.until(ExpectedConditions.urlToBe(URL.TEST_STAND_HOME_PAGE));

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                driver.getCurrentUrl().equals(URL.TEST_STAND_HOME_PAGE));
    }

    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку в форме регистрации
    public void logInUsingTheButtonInTheRegistrationForm(User user) {
        //Открываем страницу регистрации пользователя
        driver.get(URL.TEST_STAND_REGISTER);
        registerPage = new RegisterPage(driver);

        //Клик по кнопке "Войти" на странице регистрации
        registerPage.clickLoginButtonRegisterPage();

        // Ожидание перехода на страницу авторизации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);
        //Заполнение полей ввода
        String validEmail = user.getEmail();
        String validPassword = user.getPassword();
        loginPage.setEmailFieldLoginPage(validEmail);
        loginPage.setPasswordFieldLoginPage(validPassword);

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        wait.until(ExpectedConditions.urlToBe(URL.TEST_STAND_HOME_PAGE));

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                driver.getCurrentUrl().equals(URL.TEST_STAND_HOME_PAGE));
    }

    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку форме восстановления пароля
    public void loginUsingTheButtonInThePasswordRecoveryForm(User user) {
        //Открываем страницу с формой восстановления пароля
        driver.get(URL.TEST_STAND_FORGOT_PASSWORD);
        forgotPasswordPage = new ForgotPasswordPage(driver);

        //Клик по кнопке "Войти" на странице восстановления пароля
        forgotPasswordPage.clickLoginButtonForgotPasswordPage();

        // Ожидание перехода на страницу авторизации
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        loginPage = new LoginPage(driver);
        //Заполнение полей ввода
        String validEmail = user.getEmail();
        String validPassword = user.getPassword();
        loginPage.setEmailFieldLoginPage(validEmail);
        loginPage.setPasswordFieldLoginPage(validPassword);

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        wait.until(ExpectedConditions.urlToBe(URL.TEST_STAND_HOME_PAGE));

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                driver.getCurrentUrl().equals(URL.TEST_STAND_HOME_PAGE));
    }
}