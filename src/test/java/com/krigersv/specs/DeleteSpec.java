package com.krigersv.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.filter.log.LogDetail.STATUS;

public class DeleteSpec {
    public static ResponseSpecification deleteSpec = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .log(STATUS)
            .build();
}


