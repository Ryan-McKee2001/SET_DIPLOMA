package com.example.staffProject.apiTestMethods;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    private static RequestSpecification myRequestSpec = null;

    public static RequestSpecification requestSpec() {

        myRequestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost:8080").
                setContentType(ContentType.JSON).build();

        return myRequestSpec;
    }
}
