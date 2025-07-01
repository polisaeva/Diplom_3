package ru.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practicum.steps.UserRegistrationSteps;

import java.io.IOException;

@RunWith(Parameterized.class)
public class ErrorMessageParameterizedTest extends BaseTest {

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

    @Before
    public void prepareTest() throws IOException {
        registrationSteps = new UserRegistrationSteps(driver);
    }

    //Проверка отображения сообщения об ошибке для некорректного пароля
    @Test
    @DisplayName("Error message")
    @Description("Check if the error message for incorrect password is displayed")
    public void errorMessageInGoogleChromeTest() {
        registrationSteps.checkingMessageDisplayForDifferentPasswordLengths(password, expectError);
    }
}