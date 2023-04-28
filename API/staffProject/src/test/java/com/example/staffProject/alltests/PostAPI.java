package com.example.staffProject.alltests;

import com.example.staffProject.models.Management;
import com.example.staffProject.apiTestMethods.RequestSpec;
import com.example.staffProject.apiTestMethods.ResponseSpec;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.example.staffProject.alltests.getTests.getResponseList;
import static com.example.staffProject.helper.statusCodes.CLIENT_ERROR_RESPONSE_CODE;
import static com.example.staffProject.helper.statusCodes.INTERNAL_SERVER_ERROR_STATUS_CODE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostAPI {
    JSONObject putData = new JSONObject();

    List<Object> employeesList;

    Gson gsonObject;

    Management managementObj;

    String jsonObject;

    protected static RequestSpecification requestSpec = RequestSpec.requestSpec();

    protected  static ResponseSpecification responseSpec = ResponseSpec.responseSpecification();

    @BeforeClass
    public void setUp() throws JSONException {

        gsonObject = new Gson();
        managementObj = new Management("john", "Doherty", 911);
        jsonObject = gsonObject.toJson(managementObj);
        employeesList = getResponseList();
    }

    @Test
    public void addRecordToDatabase() {

        given().
                spec(requestSpec).
                body(jsonObject).
                when().
                post("/add-new-staff-member").
                then().spec(responseSpec).log();

        int before = employeesList.size();
        int after = getResponseList().size();

        System.out.println(employeesList);
        assertThat(after, greaterThan(before));
    }

    @Test
    public void addRecordToDatabaseWithIncorrectData() {

        jsonObject = gsonObject.toJson(managementObj);
        Response response = given().
                spec(requestSpec).
                body("test").
                when().
                post("/add-new-staff-member");

        assertEquals(response.getStatusCode(), CLIENT_ERROR_RESPONSE_CODE);
        int expectedSize = employeesList.size();
        int actualSize = getResponseList().size();
        assertEquals(actualSize, expectedSize);
    }
}
