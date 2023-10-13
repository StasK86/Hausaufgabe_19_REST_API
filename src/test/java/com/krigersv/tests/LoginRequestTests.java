package com.krigersv.tests;

import com.krigersv.models.LoginRequestModel;
import com.krigersv.models.LoginErrorRequesModel;
import com.krigersv.models.LoginRequestSpecModel;
import org.junit.jupiter.api.Test;

import static com.krigersv.specs.UserAndLoginSpec.*;
import static com.krigersv.specs.UserAndLoginSpec.loginResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginRequestTests {

    @Test
    void successfulLoginVerificationTest() {
        LoginRequestModel body = new LoginRequestModel();
        body.setEmail("eve.holt@reqres.in");
        body.setPassword("cityslicka");

        LoginRequestSpecModel response = step("Запрос логина с паролем", () ->
                given(loginRequestSpec)
                        .body(body)
                        .when()
                        .post("/login")
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginRequestSpecModel.class));

        step("Проверка токена", () ->
                assertEquals("QpwL5tke4Pnpja7X4", response.getToken()));
    }

    @Test
    void failedLoginCheckTest() {
        LoginRequestModel body = new LoginRequestModel();
        body.setPassword("cityslicka");

        LoginErrorRequesModel response = step("Проверка логина c паролем", () ->
                given(loginRequestSpec)
                        .body(body)
                        .when()
                        .post("/login")
                        .then()
                        .spec(errorResponseSpec)
                        .extract().as(LoginErrorRequesModel.class));

        step("Проверка токена", () ->
                assertThat(response.getError(), equalTo("Missing email or username")));
    }
}
