package ru.practicum;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.practicum.constants.URL;

import static io.restassured.RestAssured.given;

public class ApiUser {

    //Метод для шага "Отправить запрос на создание пользователя в системе"
    @Step("Send POST request to /api/auth/register")
    public static Response submitARequestToCreateAUser(String email, String password, String name) {
        Response response = given().baseUri(URL.TEST_STAND_HOME_PAGE).header("Content-type", "application/json")
                .body("{"
                        + "\"email\": \"" + email + "\", "
                        + "\"password\": \"" + password + "\", "
                        + "\"name\": \"" + name + "\""
                        + "}")
                .when().post("/api/auth/register");
        return response;
    }


    //Метод для шага "Отправить запрос на авторизацию пользователя в системе"
    @Step("Send a request for user authorization in the system")
    public static Response loginUser(String email, String password, String name) {
        Response response = given().baseUri(URL.TEST_STAND_HOME_PAGE).header("Content-type", "application/json")
                .body("{"
                        + "\"email\": \"" + email + "\", "
                        + "\"password\": \"" + password + "\", "
                        + "\"name\": \"" + name + "\""
                        + "}")
                .when().post("/api/auth/login");
        return response;
    }

    //Метод для шага "Получить токен accessToken пользователя"
    @Step("Get accessToken from user")
    public static String getAccessTokenFromUser(Response response) {
        String accessToken = response.jsonPath().getString("accessToken").split(" ")[1];
        return accessToken;
    }

    //Метод для шага "Удалить пользователя из системы"
    @Step("Remove user from the system")
    public static Response removeUserFromTheSystem(String accessToken) {
        Response response = given().baseUri(URL.TEST_STAND_HOME_PAGE).header("Authorization", "Bearer " + accessToken)
                .when().delete("/api/auth/user");
        return response;
    }
}