package com.krigersv.specs;

import com.krigersv.tests.TestBase;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class CreateUserSpec extends TestBase {
    public static RequestSpecification createUserRequestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath(config.basePath());

    public static ResponseSpecification createUserResponseSuccessSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectStatusCode(201)
            .build();
}
