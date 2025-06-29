package ru.practicum.tests;

import ru.practicum.pages.ForgotPasswordPage;
import ru.practicum.pages.HomePage;
import ru.practicum.pages.LoginPage;
import ru.practicum.pages.RegisterPage;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.ApiUser;
import ru.practicum.steps.UserAuthorizationSteps;
import ru.practicum.utils.BrowserManager;

public class EntranceTest {
    private WebDriver driver;
    private UserAuthorizationSteps userAuthorizationSteps;

    private String name = "User22";
    private String email = "user22@yandex.ru";
    private String password = "password";

    @Before
    public void setUp() {
        //Отправить запрос на создание пользователя в системе
        Response response = ApiUser.submitARequestToCreateAUser(email, password, name);
        System.out.println("Status: " + response.getStatusCode());
    }

        //Проверка входа в систему через кнопку "Войти в аккаунт" в браузере Google Chrome
        @Test
        @DisplayName("Successful login via the 'Login to account' button in Google Chrome")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginViaTheLoginToAccountButtonInGoogleChromeTest() {
            driver = BrowserManager.createBrowser("chrome");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.logInUsingTheLogInToAccountButton(email, password);
        }

        //Проверка входа в систему через кнопку "Личный кабинет" в браузере Google Chrome
        @Test
        @DisplayName("Successful login using the 'Personal Account' button in Google Chrome")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingThePersonalAccountButtonInGoogleChromeTest() {
            driver = BrowserManager.createBrowser("chrome");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.logInUsingThePersonalAccountButton(email, password);
        }

        //Проверка входа в систему через кнопку "Войти" в форме регистрации в браузере Google Chrome
        @Test
        @DisplayName("Successful login using the \"Login\" button in the registration form in Google Chrome")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingTheLoginButtonInTheRegistrationFormInGoogleChromeTest() {
            driver = BrowserManager.createBrowser("chrome");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.logInUsingTheButtonInTheRegistrationForm(email, password);
        }

        //Проверка входа в систему через кнопку "Войти" в форме восстановления пароля в браузере Google Chrome
        @Test
        @DisplayName("Successful login using the 'Login' button in the password recovery form in Google Chrome")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingTheLoginButtonInThePasswordRecoveryFormInGoogleChromeTest() {
            driver = BrowserManager.createBrowser("chrome");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.loginUsingTheButtonInThePasswordRecoveryForm(email, password);
        }

        //Проверка входа в систему через кнопку "Войти в аккаунт" в Яндекс.Браузере
        @Test
        @DisplayName("Successful login via the 'Login to account' button in Yandex Browser")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginViaTheLoginToAccountButtonInYandexBrowserTest() {
            driver = BrowserManager.createBrowser("yandex");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.logInUsingTheLogInToAccountButton(email, password);
        }

        //Проверка входа в систему через кнопку "Личный кабинет" в Яндекс.Браузере
        @Test
        @DisplayName("Successful login using the 'Personal Account' button in Yandex Browser")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingThePersonalAccountButtonInYandexBrowserTest() {
            driver = BrowserManager.createBrowser("yandex");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.logInUsingThePersonalAccountButton(email, password);
        }

        //Проверка входа в систему через кнопку "Войти" в форме регистрации в Яндекс.Браузере
        @Test
        @DisplayName("Successful login using the 'Login' button in the registration form in Yandex Browser")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingTheLoginButtonInTheRegistrationFormInYandexBrowserTest() {
            driver = BrowserManager.createBrowser("yandex");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.logInUsingTheButtonInTheRegistrationForm(email, password);
        }

        //Проверка входа в систему через кнопку "Войти" в форме восстановления пароля в Яндекс.Браузере
        @Test
        @DisplayName("Successful login using the 'Login' button in the password recovery form in Yandex Browser")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingTheLoginButtonInThePasswordRecoveryFormInYandexBrowserTest() {
            driver = BrowserManager.createBrowser("yandex");
            userAuthorizationSteps = new UserAuthorizationSteps(driver);
            userAuthorizationSteps.loginUsingTheButtonInThePasswordRecoveryForm(email, password);
        }

    @After
    public void tearDown() {
        driver.quit();

        //Отправить запрос на авторизацию пользователя в системе
        Response loginResponse = ApiUser.loginUser(email, password, name);
        //Получить токен accessToken пользователя
        if (loginResponse.getStatusCode() == 200) {
            String token = ApiUser.getAccessTokenFromUser(loginResponse);
            //Удалить пользователя из системы
            ApiUser.removeUserFromTheSystem(token);
        }
    }
}