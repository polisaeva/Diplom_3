package ru.practicum.tests;

import net.datafaker.Faker;
import ru.practicum.model.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.ApiUser;
import ru.practicum.steps.UserAuthorizationSteps;

import java.io.IOException;

public class EntranceTest extends BaseTest {

    private UserAuthorizationSteps userAuthorizationSteps;
    private User user;
    private Faker faker;


    @Before
    public void prepareTest() throws IOException {
        faker = new Faker();
        user = generateRandomUser();
        //Отправить запрос на создание пользователя в системе
        Response response = ApiUser.submitARequestToCreateAUser(user);
        System.out.println("Status: " + response.getStatusCode());
        userAuthorizationSteps = new UserAuthorizationSteps(driver);
    }

    private User generateRandomUser() {
        return new User(
                faker.internet().emailAddress(),
                faker.internet().password(6, 8, true, true, true),
                faker.name().firstName()
        );
    }

        //Проверка входа в систему через кнопку "Войти в аккаунт"
        @Test
        @DisplayName("Successful login via the 'Login to account' button")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginViaTheLoginToAccountButtonTest() {
            userAuthorizationSteps.logInUsingTheLogInToAccountButton(user);
        }

        //Проверка входа в систему через кнопку "Личный кабинет"
        @Test
        @DisplayName("Successful login using the 'Personal Account' button")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingThePersonalAccountButtonTest() {
            userAuthorizationSteps.logInUsingThePersonalAccountButton(user);
        }

        //Проверка входа в систему через кнопку "Войти" в форме регистрации
        @Test
        @DisplayName("Successful login using the \"Login\" button in the registration form")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingTheLoginButtonInTheRegistrationFormTest() {
            userAuthorizationSteps.logInUsingTheButtonInTheRegistrationForm(user);
        }

        //Проверка входа в систему через кнопку "Войти" в форме восстановления пароля
        @Test
        @DisplayName("Successful login using the 'Login' button in the password recovery form")
        @Description("As a result, the main page of Stellar Burger is open")
        public void successfulLoginUsingTheLoginButtonInThePasswordRecoveryFormTest() {
            userAuthorizationSteps.loginUsingTheButtonInThePasswordRecoveryForm(user);
        }

    @After
    public void cleanUp() {
        //Отправить запрос на авторизацию пользователя в системе
        Response loginResponse = ApiUser.loginUser(user);
        //Получить токен accessToken пользователя
        if (loginResponse.getStatusCode() == 200) {
            String token = ApiUser.getAccessTokenFromUser(loginResponse);
            //Удалить пользователя из системы
            ApiUser.removeUserFromTheSystem(token);
        }
    }
}