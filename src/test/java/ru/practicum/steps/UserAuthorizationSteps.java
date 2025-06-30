package ru.practicum.steps;

import org.openqa.selenium.WebDriver;
import ru.practicum.model.User;
import ru.practicum.pages.ForgotPasswordPage;
import ru.practicum.pages.HomePage;
import ru.practicum.pages.LoginPage;
import ru.practicum.pages.RegisterPage;

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
        homePage = new HomePage(driver);
        homePage.loadingHomePage();

        //Клик по кнопке "Войти в аккаунт"
        homePage.clickLoginToAccountButton();

        //Ожидание перехода на страницу авторизации
        loginPage = new LoginPage(driver);
        loginPage.waitingForLoginPageToLoad();

        //Заполнение полей ввода
        loginPage.setEmailFieldLoginPage(user.getEmail());
        loginPage.setPasswordFieldLoginPage(user.getPassword());

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        homePage.waitingForHomePageToLoad();

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                homePage.currentURLMatchesTheHomePageAddress());
    }

    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку "Личный кабинет"
    public void logInUsingThePersonalAccountButton(User user) {
        //Открываем страницу Stellar Burger
        homePage = new HomePage(driver);
        homePage.loadingHomePage();

        //Клик по кнопке "Личный кабинет"
        homePage.clickPersonalAccountButton();

        //Ожидание перехода на страницу авторизации
        loginPage = new LoginPage(driver);
        loginPage.waitingForLoginPageToLoad();

        //Заполнение полей ввода
        loginPage.setEmailFieldLoginPage(user.getEmail());
        loginPage.setPasswordFieldLoginPage(user.getPassword());

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        homePage.waitingForHomePageToLoad();

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                homePage.currentURLMatchesTheHomePageAddress());
    }

    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку в форме регистрации
    public void logInUsingTheButtonInTheRegistrationForm(User user) {
        //Открываем страницу регистрации пользователя
        registerPage = new RegisterPage(driver);
        registerPage.loadingRegisterPage();

        //Клик по кнопке "Войти" на странице регистрации
        registerPage.clickLoginButtonRegisterPage();

        //Ожидание перехода на страницу авторизации
        loginPage = new LoginPage(driver);
        loginPage.waitingForLoginPageToLoad();

        //Заполнение полей ввода
        loginPage.setEmailFieldLoginPage(user.getEmail());
        loginPage.setPasswordFieldLoginPage(user.getPassword());

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        homePage = new HomePage(driver);
        homePage.waitingForHomePageToLoad();

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                homePage.currentURLMatchesTheHomePageAddress());
    }

    //Метод, описывающий весь путь тестового сценария входа в систему через кнопку форме восстановления пароля
    public void loginUsingTheButtonInThePasswordRecoveryForm(User user) {
        //Открываем страницу с формой восстановления пароля
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.loadingForgotPasswordPage();

        //Клик по кнопке "Войти" на странице восстановления пароля
        forgotPasswordPage.clickLoginButtonForgotPasswordPage();

        //Ожидание перехода на страницу авторизации
        loginPage = new LoginPage(driver);
        loginPage.waitingForLoginPageToLoad();

        //Заполнение полей ввода
        loginPage.setEmailFieldLoginPage(user.getEmail());
        loginPage.setPasswordFieldLoginPage(user.getPassword());

        //Клик по кнопке "Войти"
        loginPage.clickLoginButtonLoginPage();

        // Ожидание перехода на главную страницу
        homePage = new HomePage(driver);
        homePage.waitingForHomePageToLoad();

        // Проверка успешного перехода
        assertTrue("После успешной авторизации должен быть переход на главную страницу",
                homePage.currentURLMatchesTheHomePageAddress());
    }
}