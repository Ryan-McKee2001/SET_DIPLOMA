package com.example.staffProject.apiTestMethods;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static com.example.staffProject.helper.statusCodes.OK_STATUS_CODE;

public class ResponseSpec {

    private static ResponseSpecification myResponseSpec;
    public static ResponseSpecification responseSpecification() {

        myResponseSpec = new ResponseSpecBuilder().
                expectResponseTime(Matchers.lessThan(1500l)).
                expectStatusCode(OK_STATUS_CODE).
                expectContentType(ContentType.JSON).
                build();

        return myResponseSpec;
    }
}
