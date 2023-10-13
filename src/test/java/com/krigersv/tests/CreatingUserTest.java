package com.krigersv.tests;

import com.krigersv.models.CreateUserRequestModel;
import com.krigersv.models.CreateUserIdResponseModel;
import org.junit.jupiter.api.Test;

import static com.krigersv.specs.CreateUserSpec.createUserRequestSpec;
import static com.krigersv.specs.CreateUserSpec.createUserResponseSuccessSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreatingUserTest {

    @Test
    void createUsersTest() {
        CreateUserRequestModel body = new CreateUserRequestModel();
        body.setName("morpheus");
        body.setJob("leader");

        CreateUserIdResponseModel response = step("Запрос сведений о пользователе", () ->
                given(createUserRequestSpec)
                        .body(body)
                        .when()
                        .post("/users")
                        .then()
                        .spec(createUserResponseSuccessSpec)
                        .extract().as(CreateUserIdResponseModel.class));

        step("Проверка полей в ответе", () -> {
            assertThat(response.getName(), equalTo("morpheus"));
            assertThat(response.getJob(), equalTo("leader"));
            assertNotNull(response.getId());
            assertNotNull(response.getCreatedAt());
        });
    }
}
