package com.example.staffProject.alltests;

import com.example.staffProject.apiTestMethods.RequestSpec;
import com.example.staffProject.apiTestMethods.ResponseSpec;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostAPI {
    JSONObject putData = new JSONObject();

    @BeforeClass
    public void setUp() throws JSONException {
        putData.put("forename", "Joe");
        putData.put("surname", "Bloggs");
        putData.put("deptnumber", 333);
    }

    @Test
    public void addRecordToDatabase() {
        given().
                spec(RequestSpec.requestSpec()).
                body(putData.toJSONString()).
                when().
                post("/add-new-staff-member").
                then().spec(ResponseSpec.responseSpecification()).log();
    }

    @Test
    public static void after() {
        Response response = given().
                spec(RequestSpec.requestSpec()).
                when().
                get("/get-all-staff");
        List<String> strList = response.jsonPath().getList("testing.transactionId");
        System.out.println(strList);
    }
}
