package ru.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicum.ApiUser;
import ru.practicum.steps.UserRegistrationSteps;
import ru.practicum.utils.BrowserManager;


public class RegistrationTest {

    private WebDriver driver;
    private UserRegistrationSteps registrationSteps;

    private String name = "User22";
    private String email = "user22@yandex.ru";
    private String password = "password";


    //Успешная регистрация в браузере Google Chrome
    @Test
    @DisplayName("Successful registration in google chrome browser")
    @Description("Upon successful registration, you are redirected to the user authorization page")
    public void registrationInChromeBrowserTest() {
        driver = BrowserManager.createBrowser("chrome");
        registrationSteps = new UserRegistrationSteps(driver);
        registrationSteps.registerUser(name, email, password);
    }

    //Успешная регистрация в Яндекс.Браузере
    @Test
    @DisplayName("Successful registration in yandex browser")
    @Description("Upon successful registration, you are redirected to the user authorization page")
    public void registrationInYandexBrowserTest() {
        driver = BrowserManager.createBrowser("yandex");
        registrationSteps = new UserRegistrationSteps(driver);
        registrationSteps.registerUser(name, email, password);
    }


    @After
    public void tearDown() {
        driver.quit();

        //Отправить запрос на авторизацию пользователя в системе
        Response loginResponse = ApiUser.loginUser(email, password, name);
        //Получить токен accessToken пользователя
        String token = ApiUser.getAccessTokenFromUser(loginResponse);
        //Удалить пользователя из системы
        ApiUser.removeUserFromTheSystem(token);
    }
}