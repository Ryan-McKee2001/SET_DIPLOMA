package com.example.staffProject.apiTestMethods;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpec {

    private static ResponseSpecification myResponseSpec;

    public static ResponseSpecification responseSpecification() {

        myResponseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).build();

        return myResponseSpec;
    }
}
