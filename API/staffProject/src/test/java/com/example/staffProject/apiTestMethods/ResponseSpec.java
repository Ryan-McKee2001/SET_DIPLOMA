package com.example.staffProject.apiTestMethods;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static com.example.staffProject.helper.statusCodes.OK_STATUS_CODE;

public class ResponseSpec {

    private static ResponseSpecification myResponseSpec;

    public static ResponseSpecification responseSpecification() {

        myResponseSpec = new ResponseSpecBuilder().
                expectStatusCode(OK_STATUS_CODE).
                expectContentType(ContentType.JSON).build();

        return myResponseSpec;
    }
}
