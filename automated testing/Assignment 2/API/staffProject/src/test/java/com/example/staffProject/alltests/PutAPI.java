package com.example.staffProject.alltests;

import com.example.staffProject.apiTestMethods.RequestSpec;
import com.example.staffProject.apiTestMethods.ResponseSpec;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.staffProject.alltests.DeleteAPI.INTERNAL_SERVER_ERROR_STATUS_CODE;
import static com.example.staffProject.alltests.getTests.getResponseList;
import static com.example.staffProject.helper.statusCodes.CLIENT_ERROR_RESPONSE_CODE;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

public class PutAPI {
    JSONObject putData = new JSONObject();

    List<Object> employeeList;

    Object lastEmployee;

    @BeforeClass
    public void setUp() throws JSONException {
        putData.put("forename", "Sylvestor");
        putData.put("surname", "Stallone");
        putData.put("deptnumber", 432);
        employeeList = getResponseList();
        lastEmployee = employeeList.get(employeeList.size()-1);
    }

    @Test
    public void updateRecordInDatabase() {
        Response response = putResponse(lastEmployee);
        response.then().spec(ResponseSpec.responseSpecification()).log();
    }

    @Test(dependsOnMethods = "updateRecordInDatabase")
    public void updateRecordInDatabaseWithIncorrectData() {
        putData.clear();
        Response response = putResponse(lastEmployee);
        assertEquals(response.statusCode(), INTERNAL_SERVER_ERROR_STATUS_CODE);
    }

    @Test
    public void updateRecordWithIncorrectPathVariableType() {
        Response response = putResponse("test");
        assertEquals(response.statusCode(), CLIENT_ERROR_RESPONSE_CODE);
    }

    private Response putResponse(Object pathVariable) {
        Response response = given()
                .spec(RequestSpec.requestSpec()).
                body(putData.toJSONString()).
                when().
                put(String.format("/update-staff/%s", pathVariable));
        return response;
    }

    @Test
    private void subStringTest() {

        String test = "Hello there";
        assertThat("Expecting to find that the test string has Hello in it", test, Matchers.containsString("Hello"));
    }

    @Test
    private void testContainsMatcher() {
        List<String>names = new ArrayList<>();
        names.add("abby");
        names.add("anna");
        names.add("antony");
        names.add("bert");
        assertThat(names, Matchers.hasItem("bert"));
    }
}
