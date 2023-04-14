package com.example.staffProject;

import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostAPI {
    // Class Object
    JSONObject putData = new JSONObject();

    @BeforeClass
    public void setUp() throws JSONException {
        putData.put("forename", "Joe");
        putData.put("surname", "Bloggs");
        putData.put("deptnumber", 333);
        System.out.println(putData.toJSONString());
    }

    @Test
    public void addRecordToDatabase() {

        given().
                header("content-type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(putData.toJSONString()).
                when().
                post("http://localhost:8080/add-new-staff-member").
                then().statusCode(200);
    }
}
