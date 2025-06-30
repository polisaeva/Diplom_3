package ru.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.steps.UserRegistrationSteps;
import ru.practicum.utils.BrowserManager;

@RunWith(Parameterized.class)
public class ErrorMessageParameterizedTest {

    private WebDriver driver;
    private String password;
    private boolean expectError;
    private UserRegistrationSteps registrationSteps;


    public ErrorMessageParameterizedTest(String password, boolean expectError) {
    this.password = password;
    this.expectError = expectError;
}


    @Parameterized.Parameters(name = "Тест №{index}: password: {0}, expect error: {1}")
    public static Object[] differentPasswordLength() {
        return new Object[][]{
                {"1", true},
                {"123", true},
                {"12345", true},
                {"123456", false}
        };
    }

    //Проверка отображения сообщения об ошибке для некорректного пароля в браузере Google Chrome
    @Test
    @DisplayName("Error message in google chrome")
    @Description("Check if the error message for incorrect password is displayed in Google Chrome browser")
    public void errorMessageInGoogleChromeTest() {
        driver = BrowserManager.createBrowser("chrome");
        registrationSteps = new UserRegistrationSteps(driver);
        registrationSteps.checkingMessageDisplayForDifferentPasswordLengths(password, expectError);
    }

        //Проверка отображения сообщения об ошибке для некорректного пароля в браузере Yandex Browser
    @Test
    @DisplayName("Error message in Yandex browser")
    @Description("Checking the display of an error message for an incorrect password in Yandex Browser")
    public void errorMessageInYandexBrowserTest() {
        driver = BrowserManager.createBrowser("yandex");
        registrationSteps = new UserRegistrationSteps(driver);
        registrationSteps.checkingMessageDisplayForDifferentPasswordLengths(password, expectError);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}