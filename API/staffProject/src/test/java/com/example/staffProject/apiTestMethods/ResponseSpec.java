package com.example.staffProject.apiTestMethods;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import static com.example.staffProject.helper.statusCodes.OK_STATUS_CODE;

public class ResponseSpec {

    private static ResponseSpecification myResponseSpec;

    // this ensures that the response header has the correct status code
    // and content type
    // it also carries out a response time test to ensure that the end points
    // do not take too long to respond.Ideal response time is 0.1 seconds
    public static ResponseSpecification responseSpecification() {

        myResponseSpec = new ResponseSpecBuilder().
                expectResponseTime(Matchers.lessThan(1500l)).
                expectStatusCode(OK_STATUS_CODE).
                expectContentType(ContentType.JSON).
                build();

        return myResponseSpec;
    }
}
