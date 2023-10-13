package com.krigersv.tests;
import org.junit.jupiter.api.Test;
import static com.krigersv.specs.DeleteSpec.deleteSpec;
import static com.krigersv.specs.UserAndLoginSpec.loginRequestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class DeleteTest extends TestBase {

        @Test
        void userDeletionTest() {
            step("Проверка ответа при удалении пользователя", () -> {
                given(loginRequestSpec)
                        .delete("/users/2")
                        .then()
                        .log().body()
                        .spec(deleteSpec);
            });
        }
    }

