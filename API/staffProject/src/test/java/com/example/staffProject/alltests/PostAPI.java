package com.example.staffProject.alltests;

import com.example.staffProject.apiTestMethods.RequestSpec;
import com.example.staffProject.apiTestMethods.ResponseSpec;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.example.staffProject.alltests.getTests.getResponseList;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostAPI {
    JSONObject putData = new JSONObject();

    List<Object> employeesList;

    @BeforeClass
    public void setUp() throws JSONException {
        putData.put("forename", "Joe");
        putData.put("surname", "Bloggs");
        putData.put("deptnumber", 333);
        employeesList = getResponseList();
    }

    @Test
    public void addRecordToDatabase() {
        given().
                spec(RequestSpec.requestSpec()).
                body(putData.toJSONString()).
                when().
                post("/add-new-staff-member").
                then().spec(ResponseSpec.responseSpecification()).log();
        int expectedSize = employeesList.size() + 1;
        int actualSize = getResponseList().size();
        assertEquals(actualSize, expectedSize);
    }

    @Test
    public void addRecordToDatabaseWithIncorrectData() {

        putData.clear();
        Response response = given().
                spec(RequestSpec.requestSpec()).
                body(putData.toJSONString()).
                when().
                post("/add-new-staff-member");
        assertEquals(response.getStatusCode(), 500);
        int expectedSize = employeesList.size();
        int actualSize = getResponseList().size();
        assertEquals(actualSize, expectedSize);
    }
}
