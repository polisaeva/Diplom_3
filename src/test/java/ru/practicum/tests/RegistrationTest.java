package ru.practicum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.ApiUser;
import ru.practicum.model.User;
import ru.practicum.steps.UserRegistrationSteps;

import java.io.IOException;


public class RegistrationTest extends BaseTest {

    private UserRegistrationSteps registrationSteps;
    private User user;
    private Faker faker;


    @Before
    public void prepareTest() throws IOException {
        faker = new Faker();
        user = generateRandomUser();
        registrationSteps = new UserRegistrationSteps(driver);
    }

    private User generateRandomUser() {
        return new User(
                faker.internet().emailAddress(),
                faker.internet().password(6, 8, true, true, true),
                faker.name().firstName()
        );
    }

    //Успешная регистрация
    @Test
    @DisplayName("Successful registration")
    @Description("Upon successful registration, you are redirected to the user authorization page")
    public void registrationTest() {
        registrationSteps.registerUser(user);
    }

    @After
    public void cleanUp() {
        //Отправить запрос на авторизацию пользователя в системе
        Response loginResponse = ApiUser.loginUser(user);
        //Получить токен accessToken пользователя
        String token = ApiUser.getAccessTokenFromUser(loginResponse);
        //Удалить пользователя из системы
        ApiUser.removeUserFromTheSystem(token);
    }
}