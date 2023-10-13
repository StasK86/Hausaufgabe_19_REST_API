package com.krigersv.tests;
import com.krigersv.models.UsersResponseModel;
import org.junit.jupiter.api.Test;
import static com.krigersv.specs.UserAndLoginSpec.loginRequestSpec;
import static com.krigersv.specs.UserAndLoginSpec.loginResponseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void userDataVerificationTest() {
        UsersResponseModel response = step("Запрос данных пользователей", () ->
                given(loginRequestSpec)
                        .when()
                        .get("/users?page=2")
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(UsersResponseModel.class));

        step("Проверка ответа", () -> {
            assertEquals(2, response.getPage());
            assertEquals(6, response.getPerPage());
            assertEquals(12, response.getTotal());
            assertEquals(2, response.getTotalPages());
            assertEquals(2, response.getTotalPages());
            assertEquals(7,response.getData().get(0).getId());
            assertEquals("michael.lawson@reqres.in", response.getData().get(0).getEmail());
            assertEquals("Michael", response.getData().get(0).getFirstName());
            assertEquals("Lawson", response.getData().get(0).getLastName());
            assertEquals("https://reqres.in/img/faces/7-image.jpg", response.getData().get(0).getAvatar());
        });
    }
}